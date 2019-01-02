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
import com.ruoyi.web.core.base.BaseController;
import com.team.web.domain.Expenditure;
import com.team.web.domain.TeamInfo;
import com.team.web.domain.UserBalance;
import com.team.web.domain.UserDeductions;
import com.team.web.domain.UserRechargeRecord;
import com.team.web.service.IActivityService;
import com.team.web.service.IDataStatisticsService;
import com.team.web.service.IExpenditureService;
import com.team.web.service.ITeamInfoService;
import com.team.web.service.IUserBalanceService;
import com.team.web.service.IUserDeductionsService;
import com.team.web.service.IUserRechargeRecordService;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.common.base.AjaxResult;

/**
 * 用户余额 信息操作处理
 * 
 * @author chenhuan
 * @date 2018-10-18
 */
@Controller
@RequestMapping("/team/userBalance")
public class UserBalanceController extends BaseController {
	private String prefix = "team/userBalance";

	@Autowired
	private IUserBalanceService userBalanceService;
	
	@Autowired
	private IUserRechargeRecordService userRechargeRecordService;
	
	@Autowired
	private IUserDeductionsService userDeductionsService;
	
	@Autowired
	private ITeamInfoService teammInfoService;
	
	@Autowired
	private IDataStatisticsService dataStatisticsService;
	
	@Autowired
    private ISysDictDataService dictDataService;
	
	@Autowired
	private ISysDictDataService sysDictDataService;
	
	@Autowired
	private IActivityService activityService;

	@RequiresPermissions("team:userBalance:view")
	@GetMapping()
	public String userBalance() {
		return prefix + "/userBalance";
	}
	
	@RequiresPermissions("team:userBalance:myinfo")
	@GetMapping("/myinfo")
	public String myInfo(ModelMap mmap) {
		SysUser user = getUser();
        user.setSex(dictDataService.selectDictLabel("sys_user_sex", user.getSex()));
        mmap.put("user", user);
		UserBalance ub=userBalanceService.selectUserBalanceById(this.getUser().getUserId());
		//System.out.println(ub.getAmount()+"    "+ub.getBalance());
		mmap.put("myinfo", ub);
		return prefix + "/myinfo";
	}
	
	/**
	 * 我的信息图表
	 */
	@RequiresPermissions("team:userBalance:chartData")
	@PostMapping("/chartData")
	@ResponseBody
	public Map chartData(HttpServletRequest request)
	{	
		//String num=request.getParameter("attendance_topnum");
		Map map=new HashMap();
		map.put("user_id", this.getUserId());
		//map.put("num", num);
		map.put("activtiyLevel", this.dataStatisticsService.selectUserActivityLevel(map));
		map.put("year", 10);
		map.put("yearExpenditure", this.dataStatisticsService.selectUserYearExpenditure(map));
		map.put("userExpenditureRatio", this.dataStatisticsService.selectUserExpenditureRatio(map));
		return map;
	}

	/**
	 * 查询用户余额列表
	 */
	@RequiresPermissions("team:userBalance:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UserBalance userBalance) {
		startPage();
		List<UserBalance> list = userBalanceService.selectUserBalanceList(userBalance);
		return getDataTable(list);
	}


	/**
	 * 用户充值
	 */
	@GetMapping("/recharge/{userId}")
	public String recharge(@PathVariable("userId") Long userId, ModelMap mmap) {
		// UserBalance userBalance = userBalanceService.selectUserBalanceById(userId);
		UserBalance userBalance = new UserBalance();
		userBalance.setUserId(userId);
		mmap.put("userBalance", userBalance);
		return prefix + "/recharge";
	}
	
	

	/**
	 * 保存用户充值
	 */
	@RequiresPermissions("team:userBalance:recharge")
	@Log(title = "用户余额", businessType = BusinessType.UPDATE)
	@PostMapping("/recharge")
	@ResponseBody
	@Transactional(rollbackForClassName={"RuntimeException","Exception"})
	public AjaxResult rechargeSave(UserBalance userBalance) {
		int num = 0;
		UserBalance old_userBalance = userBalanceService.selectUserBalanceById(userBalance.getUserId());
		//用户不存在余额表，则插入数据
		if (old_userBalance == null||old_userBalance.getUserId()==null) {
			num = userBalanceService.insertUserBalance(userBalance);
		} else {
			num = userBalanceService.updateUserBalance(userBalance);
		}
		
		String remark=userBalance.getRemark();
		if(num>0){
		/**正常充值的情况下，更新球队收入,增加用户充值的金额*/
		if(userBalance.getRechargeType().equals("1"))
		{
			TeamInfo team=new TeamInfo();
			team.setIncome(userBalance.getBalance());
			team.setId(1);//默认球队ID为1
			teammInfoService.updateTeamInfo(team);
			remark=(remark==null||remark.equals(""))?"正常充值":remark;
		}else
		{
			remark=(remark==null||remark.equals(""))?"错扣补差":remark;
		}
		/**用户充值记录*/
		UserRechargeRecord record =new UserRechargeRecord();
		record.setUserId(userBalance.getUserId());
		record.setRechargeAmount(userBalance.getBalance());
		record.setRechargeType(userBalance.getRechargeType());
		record.setRemark(remark);
		userRechargeRecordService.insertUserRechargeRecord(record);
		}
		return toAjax(num);
	}
	
	/**
	 * 用户扣费
	 */
	@GetMapping("/deductions/{userId}")
	public String deductions(@PathVariable("userId") Long userId, ModelMap mmap) {
		// UserBalance userBalance = userBalanceService.selectUserBalanceById(userId);
		UserDeductions userDeductions = new UserDeductions();
		userDeductions.setUserId(userId);
		mmap.put("userDeductions", userDeductions);
		Expenditure expenditure=new Expenditure();
		expenditure .setIsWriteOff(0);
		
		SysDictData dictData=new SysDictData();
		dictData.setDictType("tm_cost_type");
		List dictlist=sysDictDataService.selectDictDataList(dictData);
		mmap.addAttribute("tm_cost_type",dictlist);
		return prefix + "/deductions";
	}
	
	/**
	 * 修改保存用户扣费
	 */
	@RequiresPermissions("team:userBalance:deductions")
	@Log(title = "用户余额", businessType = BusinessType.UPDATE)
	@PostMapping("/deductions")
	@ResponseBody
	public AjaxResult deductionsSave(UserDeductions userDeductions) {
		int num = 0;
		UserBalance userBalance = userBalanceService.selectUserBalanceById(userDeductions.getUserId());
		
		if (userBalance == null||userBalance.getUserId()==null) {
			num=0;
		} else {
			userBalance.setBalance(new BigDecimal(0-userDeductions.getDeductionsAmount().doubleValue()));
			num = userBalanceService.updateUserBalance(userBalance);
		}
		
		if(num>0){
			/**用户扣费记录*/
			userDeductionsService.insertUserDeductions(userDeductions);
		}
		return toAjax(num);
	}

}
