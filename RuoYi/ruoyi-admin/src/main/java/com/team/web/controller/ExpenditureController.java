package com.team.web.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.team.web.domain.Activity;
import com.team.web.domain.Expenditure;
import com.team.web.domain.TeamInfo;
import com.team.web.domain.UserDeductions;
import com.team.web.service.IActivityService;
import com.team.web.service.IExpenditureService;
import com.team.web.service.ITeamInfoService;
import com.team.web.service.IUserBalanceService;
import com.team.web.service.IUserDeductionsService;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.common.base.AjaxResult;

/**
 * 球队支出 信息操作处理
 * 
 * @author 陈焕
 * @date 2018-10-26
 */
@Controller
@RequestMapping("/team/expenditure")
public class ExpenditureController extends BaseController
{
    private String prefix = "team/expenditure";
	
	@Autowired
	private IExpenditureService expenditureService;
	
	@Autowired
	private ISysDictDataService sysDictDataService;
	
	@Autowired
	private IActivityService activityService;
	
	@Autowired
	private IUserBalanceService userBalanceService;
	
	@Autowired
	private IUserDeductionsService userDeductionsService;
	
	@Autowired
	private ITeamInfoService teamInfoService;
	
	@RequiresPermissions("team:expenditure:view")
	@GetMapping()
	public String expenditure()
	{
		
	    return prefix + "/expenditure";
	}
	
	/**
	 * 查询球队支出列表
	 */
	@RequiresPermissions("team:expenditure:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Expenditure expenditure)
	{
		startPage();
        List<Expenditure> list = expenditureService.selectExpenditureList(expenditure);
		return getDataTable(list);
	}
	
	/**
	 * 新增球队支出
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		SysDictData dictData=new SysDictData();
		dictData.setDictType("tm_cost_type");
		List dictlist=sysDictDataService.selectDictDataList(dictData);
		
		mmap.addAttribute("tm_cost_type",dictlist);
		List activityList =activityService.selectActivityListTop(5);
		mmap.addAttribute("activitys", activityList);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存球队支出
	 */
	@RequiresPermissions("team:expenditure:add")
	@Log(title = "球队支出", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	@Transactional(rollbackForClassName={"RuntimeException","Exception"})
	public AjaxResult addSave(Expenditure expenditure)
	{	
		int num=expenditureService.insertExpenditure(expenditure);
		
		/**更新球队支出金额*/
		if(num>0)
		{
			TeamInfo team=new TeamInfo();
			team.setExpenditure(BigDecimal.valueOf(expenditure.getCostAmount().doubleValue()));
			team.setId(1);
			num+=teamInfoService.updateTeamInfo(team);
		}
		return toAjax(num);
	}

	/**
	 * 修改球队支出
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		SysDictData dictData=new SysDictData();
		dictData.setDictType("tm_cost_type");
		List dictlist=sysDictDataService.selectDictDataList(dictData);
		mmap.addAttribute("tm_cost_type",dictlist);
		Expenditure expenditure = expenditureService.selectExpenditureById(id);
		mmap.put("expenditure", expenditure);
		List activityList =activityService.selectActivityListTop(5);
		mmap.addAttribute("activitys", activityList);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存球队支出
	 */
	@RequiresPermissions("team:expenditure:edit")
	@Log(title = "球队支出", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Expenditure expenditure)
	{		
		return toAjax(expenditureService.updateExpenditure(expenditure));
	}
	
	
	/**
	 * 冲销
	 */
	@GetMapping("/writeOff/{id}")
	public String writeOff(@PathVariable("id") Long id, ModelMap mmap)
	{
		List<Map> users=userBalanceService.selectRechargeUserList(new HashMap<String, String>());
		mmap.put("users", users);
		Expenditure expenditure = expenditureService.selectExpenditureById(id);
		mmap.put("expenditure", expenditure);
	    return prefix + "/writeOff"; 
	}
	
	/**
	 * 冲销保存
	 */
	@RequiresPermissions("team:expenditure:writeOff")
	@Log(title = "球队支出", businessType = BusinessType.UPDATE)
	@PostMapping("/writeOff")
	@ResponseBody
	@Transactional(rollbackForClassName={"RuntimeException","Exception"})
	public AjaxResult writeOffSave(HttpServletRequest request)
	{	
		String[] userIds=request.getParameterValues("otherPeoples");
		String writeOffAmount=request.getParameter("writeOffAmount");
		String id=request.getParameter("id");
		String costName=request.getParameter("costName");
		String activityId=request.getParameter("activityId");
		String costTypeId=request.getParameter("costTypeId");
		
		if(userIds.length>0)
		{
			/**计算每人平均扣费*/
			double amount=Math.ceil(Float.parseFloat(writeOffAmount)/userIds.length*100)/100;
			Map map=new HashMap();
			map.put("userids", userIds);
			map.put("balance", amount);
			/**用户扣费*/
			userBalanceService.writeOffUserBalance(map);
			
			Activity ac=null;
			if(activityId!=null&&!activityId.equals(""))
			{
				ac=activityService.selectActivityById(Long.parseLong(activityId));
			}
			
			/**用户扣费记录*/
			for(int i=0;i<userIds.length;i++)
			{
				UserDeductions ud=new UserDeductions();
				//ud.setId(Long.parseLong(userIds[i]));
				ud.setUserId(Long.parseLong(userIds[i]));
				ud.setExpenditureId(Long.parseLong(id));
				ud.setDeductionsAmount(new BigDecimal(amount));
				ud.setCostTypeId(Integer.parseInt(costTypeId));
				if(ac!=null)
				{
					ud.setRemarks(ac.getActivityName()+" "+costName+"--均摊费用扣除");
				}else {
					ud.setRemarks(costName+"--预支费用冲销");
				}
				userDeductionsService.insertUserDeductions(ud);
			}
			
			/**冲销活动费用*/
			Expenditure ex=new Expenditure();
			ex.setId(Long.parseLong(id));
			ex.setWriteOffAmount(new BigDecimal(writeOffAmount));
			expenditureService.updateExpenditureWriteOffAmount(ex);
		}else
		{
			return toAjax(0);
		}
		return toAjax(1);
	}
	
	/**
	 * 删除球队支出
	 */
	@RequiresPermissions("team:expenditure:remove")
	@Log(title = "球队支出", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(expenditureService.deleteExpenditureByIds(ids));
	}
	
}
