package com.team.web.controller;

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
import com.ruoyi.common.utils.StringUtils;
import com.team.web.domain.Activity;
import com.team.web.domain.TeamInfo;
import com.team.web.service.IActivityService;
import com.team.web.service.ITeamInfoService;
import com.team.web.service.IUserBalanceService;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 *  球队活动 信息操作处理
 * 
 * @author chenhuan
 * @date 2018-10-29
 */
@Controller
@RequestMapping("/team/activity")
public class ActivityController extends BaseController
{
    private String prefix = "team/activity";
	
	@Autowired
	private IActivityService activityService;
	
	@Autowired
	private IUserBalanceService userBalanceService;
	
	@Autowired
	private ITeamInfoService teamInfoService;
	
	@RequiresPermissions("team:activity:view")
	@GetMapping()
	public String activity()
	{
	    return prefix + "/activity";
	}
	
	/**
	 * 查询 球队活动列表
	 */
	@RequiresPermissions("team:activity:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Activity activity)
	{
		startPage();
        List<Activity> list = activityService.selectActivityList(activity);
		return getDataTable(list);
	}
	
	/**
	 * 新增 球队活动
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		List<Map> users=userBalanceService.selectRechargeUserList(new HashMap<String, String>());
		mmap.put("users", users);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存 球队活动
	 */
	@RequiresPermissions("team:activity:add")
	@Log(title = " 球队活动", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	@Transactional(rollbackForClassName={"RuntimeException","Exception"})
	public AjaxResult addSave(Activity activity,HttpServletRequest request)
	{
		int  num=0;
		String[] peoples=request.getParameterValues("peoples");
		/*插入活动*/	
		activity.setPeopleNumber(peoples.length);
		num=activityService.insertActivity(activity);
		
		
		/**插入活动关联用户*/
		Map map=new HashMap();
		map.put("activityid", activity.getId());
		map.put("userids", peoples);
		num+=activityService.insertActivityUser(map);
		
		/**更新用户排序信息,根据参加活动次数变更*/
		userBalanceService.updateUserBalanceActivityCount1(map);
		/**更新用户排序信息，用户最近10次参加活动次数*/
		userBalanceService.updateUserBalanceActivityCount2();
		
		/**球队活动次数+1*/
		TeamInfo ti=new TeamInfo();
		ti.setActivityCount(1);
		ti.setId(1);
		teamInfoService.updateTeamInfo(ti);
		return toAjax(num);
	}

	/**
	 * 修改 球队活动
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Activity activity = activityService.selectActivityById(id);
		mmap.put("activity", activity);
		List<Map> users=userBalanceService.selectRechargeUserList(new HashMap<String, String>());
		mmap.put("users", users);
		String userids=StringUtils.join(activityService.selectActivityUserIDByActivityid(id), ",");
		//System.out.println(userids);
		mmap.put("selected_userids", userids);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存 球队活动
	 */
	@RequiresPermissions("team:activity:edit")
	@Log(title = " 球队活动", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	@Transactional(rollbackForClassName={"RuntimeException","Exception"})
	public AjaxResult editSave(Activity activity,HttpServletRequest request)
	{		
		int  num=0;
		String[] peoples=request.getParameterValues("peoples");
		activity.setPeopleNumber(peoples.length);
		activityService.updateActivity(activity);
		
		/** 删除关联用户*/
		activityService.deleteActivityUserByActivityid(activity.getId());
		/**插入活动关联用户*/
		Map map=new HashMap();
		map.put("activityid", activity.getId());
		map.put("userids", peoples);
		num+=activityService.insertActivityUser(map);
		
		/**更新用户排序信息,根据参加活动次数变更*/
		userBalanceService.updateUserBalanceActivityCount1(map);
		/**更新用户排序信息，用户最近10次参加活动次数*/
		userBalanceService.updateUserBalanceActivityCount2();
		return toAjax(num);
	}
	
	/**
	 * 删除 球队活动
	 */
	@RequiresPermissions("team:activity:remove")
	@Log(title = " 球队活动", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	@Transactional(rollbackForClassName={"RuntimeException","Exception"})
	public AjaxResult remove(String ids)
	{	
		/** 删除关联用户*/
		activityService.deleteActivityUserByActivityid(Long.valueOf(ids));
		/**球队活动次数-1*/
		TeamInfo ti=new TeamInfo();
		ti.setActivityCount(-1);
		ti.setId(1);
		teamInfoService.updateTeamInfo(ti);
		return toAjax(activityService.deleteActivityByIds(ids));
	}
	
}
