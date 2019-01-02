package com.team.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
import com.team.web.domain.UserDeductions;
import com.team.web.service.IUserDeductionsService;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 用户扣费记录 信息操作处理
 * 
 * @author chenhuan
 * @date 2018-10-26
 */
@Controller
@RequestMapping("/team/userDeductions")
public class UserDeductionsController extends BaseController
{
    private String prefix = "team/userDeductions";
	
	@Autowired
	private IUserDeductionsService userDeductionsService;
	
	@RequiresPermissions("team:userDeductions:view")
	@GetMapping()
	public String userDeductions()
	{
	    return prefix + "/userDeductions";
	}
	
	/**
	 * 查询用户扣费记录列表
	 */
	@RequiresPermissions("team:userDeductions:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UserDeductions userDeductions)
	{
		startPage();
        List<UserDeductions> list = userDeductionsService.selectUserDeductionsList(userDeductions);
		return getDataTable(list);
	}
	
	/**
	 * 删除用户扣费记录
	 */
	@RequiresPermissions("team:userDeductions:remove")
	@Log(title = "用户扣费记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(userDeductionsService.deleteUserDeductionsByIds(ids));
	}
	
}
