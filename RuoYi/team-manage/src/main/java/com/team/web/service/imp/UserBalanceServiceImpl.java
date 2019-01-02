package com.team.web.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;
import com.team.web.domain.UserBalance;
import com.team.web.mapper.UserBalanceMapper;
import com.team.web.service.IUserBalanceService;

/**
 * 用户余额 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-18
 */
@Service
public class UserBalanceServiceImpl implements IUserBalanceService 
{
	@Autowired
	private UserBalanceMapper userBalanceMapper;

	/**
     * 查询用户余额信息
     * 
     * @param userId 用户余额ID
     * @return 用户余额信息
     */
    @Override
	public UserBalance selectUserBalanceById(Long userId)
	{
	    return userBalanceMapper.selectUserBalanceById(userId);
	}
	
	/**
     * 查询用户余额列表
     * 
     * @param userBalance 用户余额信息
     * @return 用户余额集合
     */
	@Override
	public List<UserBalance> selectUserBalanceList(UserBalance userBalance)
	{
	    return userBalanceMapper.selectUserBalanceList(userBalance);
	}
	
    /**
     * 新增用户余额
     * 
     * @param userBalance 用户余额信息
     * @return 结果
     */
	@Override
	public int insertUserBalance(UserBalance userBalance)
	{
	    return userBalanceMapper.insertUserBalance(userBalance);
	}
	
	/**
     * 修改用户余额
     * 
     * @param userBalance 用户余额信息
     * @return 结果
     */
	@Override
	public int updateUserBalance(UserBalance userBalance)
	{
	    return userBalanceMapper.updateUserBalance(userBalance);
	}

	/**
     * 删除用户余额对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteUserBalanceByIds(String ids)
	{
		return userBalanceMapper.deleteUserBalanceByIds(Convert.toStrArray(ids));
	}

	@Override
	public int writeOffUserBalance(Map map) {
		return userBalanceMapper.writeOffUserBalance(map);
	}

	@Override
	public List<Map> selectRechargeUserList(Map map) {
		// TODO Auto-generated method stub
		return userBalanceMapper.selectRechargeUserList(map);
	}


	@Override
	public int updateUserBalanceActivityCount1(Map map) {
		// TODO Auto-generated method stub
		return userBalanceMapper.updateUserBalanceActivityCount1(map);
	}

	@Override
	public int updateUserBalanceActivityCount2() {
		// TODO Auto-generated method stub
		return userBalanceMapper.updateUserBalanceActivityCount2();
	}
	
}
