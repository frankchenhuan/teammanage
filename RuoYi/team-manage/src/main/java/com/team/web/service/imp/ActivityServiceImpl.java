package com.team.web.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;
import com.team.web.domain.Activity;
import com.team.web.mapper.ActivityMapper;
import com.team.web.service.IActivityService;


/**
 *  球队活动 服务层实现
 * 
 * @author chenhuan
 * @date 2018-10-29
 */
@Service
public class ActivityServiceImpl implements IActivityService 
{
	@Autowired
	private ActivityMapper activityMapper;

	/**
     * 查询 球队活动信息
     * 
     * @param id  球队活动ID
     * @return  球队活动信息
     */
    @Override
	public Activity selectActivityById(Long id)
	{
	    return activityMapper.selectActivityById(id);
	}
	
	/**
     * 查询 球队活动列表
     * 
     * @param activity  球队活动信息
     * @return  球队活动集合
     */
	@Override
	public List<Activity> selectActivityList(Activity activity)
	{
	    return activityMapper.selectActivityList(activity);
	}
	
    /**
     * 新增 球队活动
     * 
     * @param activity  球队活动信息
     * @return 结果
     */
	@Override
	public int insertActivity(Activity activity)
	{
	    return activityMapper.insertActivity(activity);
	}
	
	/**
     * 修改 球队活动
     * 
     * @param activity  球队活动信息
     * @return 结果
     */
	@Override
	public int updateActivity(Activity activity)
	{
	    return activityMapper.updateActivity(activity);
	}

	/**
     * 删除 球队活动对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteActivityByIds(String ids)
	{
		return activityMapper.deleteActivityByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<Activity> selectActivityListTop(int top) {
		// TODO Auto-generated method stub
		return activityMapper.selectActivityListTop(top);
	}

	

	@Override
	public int deleteActivityUserByActivityid(Long activityid) {
		// TODO Auto-generated method stub
		return activityMapper.deleteActivityUserByActivityid(activityid);
	}

	@Override
	public int insertActivityUser(Map map) {
		// TODO Auto-generated method stub
		return activityMapper.insertActivityUser(map);
	}

	@Override
	public List selectActivityUserIDByActivityid(Long activityid) {
		// TODO Auto-generated method stub
		return activityMapper.selectActivityUserIDByActivityid(activityid);
	}
	
}
