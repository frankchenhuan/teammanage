package com.team.web.service;

import java.util.List;
import java.util.Map;

import com.team.web.domain.UserBalance;

/**
 * 用户余额 服务层
 * 
 * @author ruoyi
 * @date 2018-10-18
 */
public interface IUserBalanceService 
{
	/**
     * 查询用户余额信息
     * 
     * @param userId 用户余额ID
     * @return 用户余额信息
     */
	public UserBalance selectUserBalanceById(Long userId);
	
	/**
     * 查询用户余额列表
     * 
     * @param userBalance 用户余额信息
     * @return 用户余额集合
     */
	public List<UserBalance> selectUserBalanceList(UserBalance userBalance);
	
	/**
     * 新增用户余额
     * 
     * @param userBalance 用户余额信息
     * @return 结果
     */
	public int insertUserBalance(UserBalance userBalance);
	
	/**
     * 修改用户余额
     * 
     * @param userBalance 用户余额信息
     * @return 结果
     */
	public int updateUserBalance(UserBalance userBalance);
		
	/**
     * 删除用户余额信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserBalanceByIds(String ids);
	
	/**
	 * 冲销用户余额
	 * */
	public int writeOffUserBalance(Map map);
	
	/**更新用户排序*/
	public int updateUserBalanceActivityCount1(Map map);
	
	/**更新用户排序1*/
	public int updateUserBalanceActivityCount2();
	
	/**查询充值用户*/
	public List<Map> selectRechargeUserList(Map map);
	
	
	
}
