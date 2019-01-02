package com.team.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.team.web.domain.TeamInfo;
import com.team.web.service.IDataStatisticsService;
import com.team.web.service.ITeamInfoService;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 球队资金  信息操作处理
 * 
 * @author chenhuan
 * @date 2018-10-26
 */
@Controller
@RequestMapping("/team/teamInfo")
public class TeamInfoController extends BaseController
{
    private String prefix = "team/teamInfo";
	
	@Autowired
	private ITeamInfoService teamInfoService;
	
	@Autowired
	private IDataStatisticsService dataStatisticsService;
	
	//@RequiresPermissions("team:teamInfo:view")
	//@GetMapping()
	public String teamInfo()
	{
	    return prefix + "/teamInfo";
	}
	
	@RequiresPermissions("team:teamInfo:view")
	@GetMapping()
	public String teamInfo2(ModelMap mmap)
	{
		TeamInfo ti=this.teamInfoService.selectTeamInfoById(1);
		mmap.put("teaminfo", ti);
	    return prefix + "/teamInfo2";
	}
	
	/**
	 * 查询球队资金支出比例
	 */
	@RequiresPermissions("team:teamInfo:costRatios")
	@PostMapping("/costRatios")
	@ResponseBody
	public List<Map> costRatios()
	{
		return this.dataStatisticsService.selectExpenditureRatio();
	}
	
	/**
	 * 查询球队资金支出比例
	 */
	@RequiresPermissions("team:teamInfo:chartData")
	@PostMapping("/chartData")
	@ResponseBody
	public Map chartData(HttpServletRequest request)
	{
		String num=request.getParameter("attendance_topnum");
		Map map=new HashMap();
		map.put("num", num);
		List<Map> attendanceData=this.dataStatisticsService.selectUserAttendance(map);
		map.put("attendanceData", attendanceData);
		map.put("costRatios", this.dataStatisticsService.selectExpenditureRatio());
		map.put("latelyAttendanceData", this.dataStatisticsService.selectUserLatelyAttendance(map));
		map.put("activtiyLevel", this.dataStatisticsService.selectActivityLevel(map));
		map.put("year", 10);
		map.put("yearExpenditure", this.dataStatisticsService.selectYearExpenditure(map));
		return map;
	}
	
	/**
	 * 查询球队资金支出比例
	 */
	@RequiresPermissions("team:teamInfo:attendance")
	@PostMapping("/attendance")
	@ResponseBody
	public List<Map> attendance(HttpServletRequest request)
	{
		String num=request.getParameter("attendance_topnum");
		//System.out.println(num+"----------");
		Map map=new HashMap();
		map.put("num", num);
		return this.dataStatisticsService.selectUserAttendance(map);
	}
	
	/**
	 * 查询球队资金 列表
	 */
	@RequiresPermissions("team:teamInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TeamInfo teamInfo)
	{
		startPage();
        List<TeamInfo> list = teamInfoService.selectTeamInfoList(teamInfo);
		return getDataTable(list);
	}
	
	/**
	 * 新增球队资金 
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存球队资金 
	 */
	@RequiresPermissions("team:teamInfo:add")
	@Log(title = "球队资金 ", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TeamInfo teamInfo)
	{		
		return toAjax(teamInfoService.insertTeamInfo(teamInfo));
	}

	/**
	 * 修改球队资金 
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TeamInfo teamInfo = teamInfoService.selectTeamInfoById(id);
		mmap.put("teamInfo", teamInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存球队资金 
	 */
	@RequiresPermissions("team:teamInfo:edit")
	@Log(title = "球队资金 ", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TeamInfo teamInfo)
	{		
		return toAjax(teamInfoService.updateTeamInfo(teamInfo));
	}
	
	/**
	 * 删除球队资金 
	 */
	@RequiresPermissions("team:teamInfo:remove")
	@Log(title = "球队资金 ", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(teamInfoService.deleteTeamInfoByIds(ids));
	}
	
}
