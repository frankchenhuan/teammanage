package com.team.web.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;
import com.team.web.domain.UserDeductions;
import com.team.web.mapper.UserDeductionsMapper;
import com.team.web.service.IUserDeductionsService;

/**
 * 用户扣费记录 服务层实现
 * 
 * @author 陈焕
 * @date 2018-10-26
 */
@Service
public class UserDeductionsServiceImpl implements IUserDeductionsService 
{
	@Autowired
	private UserDeductionsMapper userDeductionsMapper;

	/**
     * 查询用户扣费记录信息
     * 
     * @param id 用户扣费记录ID
     * @return 用户扣费记录信息
     */
    @Override
	public UserDeductions selectUserDeductionsById(Long id)
	{
	    return userDeductionsMapper.selectUserDeductionsById(id);
	}
	
	/**
     * 查询用户扣费记录列表
     * 
     * @param userDeductions 用户扣费记录信息
     * @return 用户扣费记录集合
     */
	@Override
	public List<UserDeductions> selectUserDeductionsList(UserDeductions userDeductions)
	{
	    return userDeductionsMapper.selectUserDeductionsList(userDeductions);
	}
	
    /**
     * 新增用户扣费记录
     * 
     * @param userDeductions 用户扣费记录信息
     * @return 结果
     */
	@Override
	public int insertUserDeductions(UserDeductions userDeductions)
	{
	    return userDeductionsMapper.insertUserDeductions(userDeductions);
	}
	
	/**
     * 修改用户扣费记录
     * 
     * @param userDeductions 用户扣费记录信息
     * @return 结果
     */
	@Override
	public int updateUserDeductions(UserDeductions userDeductions)
	{
	    return userDeductionsMapper.updateUserDeductions(userDeductions);
	}

	/**
     * 删除用户扣费记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteUserDeductionsByIds(String ids)
	{
		return userDeductionsMapper.deleteUserDeductionsByIds(Convert.toStrArray(ids));
	}
	
}
