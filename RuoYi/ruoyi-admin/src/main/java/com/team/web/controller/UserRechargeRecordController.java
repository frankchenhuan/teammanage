package com.team.web.controller;

import java.util.List;
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
import com.ruoyi.web.core.base.BaseController;
import com.team.web.domain.UserRechargeRecord;
import com.team.web.service.IUserRechargeRecordService;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 用户充值记录 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-10-18
 */
@Controller
@RequestMapping("/team/userRechargeRecord")
public class UserRechargeRecordController extends BaseController
{
    private String prefix = "team/userRechargeRecord";
	
	@Autowired
	private IUserRechargeRecordService userRechargeRecordService;
	
	@RequiresPermissions("team:userRechargeRecord:view")
	@GetMapping()
	public String userRechargeRecord()
	{
	    return prefix + "/userRechargeRecord";
	}
	
	/**
	 * 查询用户充值记录列表
	 */
	@RequiresPermissions("team:userRechargeRecord:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UserRechargeRecord userRechargeRecord)
	{
		startPage();
        List<UserRechargeRecord> list = userRechargeRecordService.selectUserRechargeRecordList(userRechargeRecord);
		return getDataTable(list);
	}
	
	
	/**
	 * 删除用户充值记录
	 */
	@RequiresPermissions("team:userRechargeRecord:remove")
	@Log(title = "用户充值记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(userRechargeRecordService.deleteUserRechargeRecordByIds(ids));
	}
	
}
