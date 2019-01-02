package com.team.web.service;

import java.util.List;

import com.team.web.domain.UserRechargeRecord;

/**
 * 用户充值记录 服务层
 * 
 * @author ruoyi
 * @date 2018-10-18
 */
public interface IUserRechargeRecordService 
{
	/**
     * 查询用户充值记录信息
     * 
     * @param id 用户充值记录ID
     * @return 用户充值记录信息
     */
	public UserRechargeRecord selectUserRechargeRecordById(Long id);
	
	/**
     * 查询用户充值记录列表
     * 
     * @param userRechargeRecord 用户充值记录信息
     * @return 用户充值记录集合
     */
	public List<UserRechargeRecord> selectUserRechargeRecordList(UserRechargeRecord userRechargeRecord);
	
	/**
     * 新增用户充值记录
     * 
     * @param userRechargeRecord 用户充值记录信息
     * @return 结果
     */
	public int insertUserRechargeRecord(UserRechargeRecord userRechargeRecord);
	
	/**
     * 修改用户充值记录
     * 
     * @param userRechargeRecord 用户充值记录信息
     * @return 结果
     */
	public int updateUserRechargeRecord(UserRechargeRecord userRechargeRecord);
		
	/**
     * 删除用户充值记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserRechargeRecordByIds(String ids);
	
}
