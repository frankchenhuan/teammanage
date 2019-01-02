package com.team.web.service;

import java.util.List;

import com.team.web.domain.UserDeductions;

/**
 * 用户扣费记录 服务层
 * 
 * @author chenhuan
 * @date 2018-10-26
 */
public interface IUserDeductionsService 
{
	/**
     * 查询用户扣费记录信息
     * 
     * @param id 用户扣费记录ID
     * @return 用户扣费记录信息
     */
	public UserDeductions selectUserDeductionsById(Long id);
	
	/**
     * 查询用户扣费记录列表
     * 
     * @param userDeductions 用户扣费记录信息
     * @return 用户扣费记录集合
     */
	public List<UserDeductions> selectUserDeductionsList(UserDeductions userDeductions);
	
	/**
     * 新增用户扣费记录
     * 
     * @param userDeductions 用户扣费记录信息
     * @return 结果
     */
	public int insertUserDeductions(UserDeductions userDeductions);
	
	/**
     * 修改用户扣费记录
     * 
     * @param userDeductions 用户扣费记录信息
     * @return 结果
     */
	public int updateUserDeductions(UserDeductions userDeductions);
		
	/**
     * 删除用户扣费记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserDeductionsByIds(String ids);
	
}
