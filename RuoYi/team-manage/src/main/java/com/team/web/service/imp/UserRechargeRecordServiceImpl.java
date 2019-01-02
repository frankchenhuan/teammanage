package com.team.web.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;
import com.team.web.domain.UserRechargeRecord;
import com.team.web.mapper.UserRechargeRecordMapper;
import com.team.web.service.IUserRechargeRecordService;

/**
 * 用户充值记录 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-18
 */
@Service
public class UserRechargeRecordServiceImpl implements IUserRechargeRecordService 
{
	@Autowired
	private UserRechargeRecordMapper userRechargeRecordMapper;

	/**
     * 查询用户充值记录信息
     * 
     * @param id 用户充值记录ID
     * @return 用户充值记录信息
     */
    @Override
	public UserRechargeRecord selectUserRechargeRecordById(Long id)
	{
	    return userRechargeRecordMapper.selectUserRechargeRecordById(id);
	}
	
	/**
     * 查询用户充值记录列表
     * 
     * @param userRechargeRecord 用户充值记录信息
     * @return 用户充值记录集合
     */
	@Override
	public List<UserRechargeRecord> selectUserRechargeRecordList(UserRechargeRecord userRechargeRecord)
	{
	    return userRechargeRecordMapper.selectUserRechargeRecordList(userRechargeRecord);
	}
	
    /**
     * 新增用户充值记录
     * 
     * @param userRechargeRecord 用户充值记录信息
     * @return 结果
     */
	@Override
	public int insertUserRechargeRecord(UserRechargeRecord userRechargeRecord)
	{
	    return userRechargeRecordMapper.insertUserRechargeRecord(userRechargeRecord);
	}
	
	/**
     * 修改用户充值记录
     * 
     * @param userRechargeRecord 用户充值记录信息
     * @return 结果
     */
	@Override
	public int updateUserRechargeRecord(UserRechargeRecord userRechargeRecord)
	{
	    return userRechargeRecordMapper.updateUserRechargeRecord(userRechargeRecord);
	}

	/**
     * 删除用户充值记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteUserRechargeRecordByIds(String ids)
	{
		return userRechargeRecordMapper.deleteUserRechargeRecordByIds(Convert.toStrArray(ids));
	}
	
}
