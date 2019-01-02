package com.team.web.mapper;

import com.team.web.domain.Activity;
import java.util.List;
import java.util.Map;	

/**
 *  球队活动 数据层
 * 
 * @author ruoyi
 * @date 2018-10-29
 */
public interface ActivityMapper 
{
	/**
     * 查询 球队活动信息
     * 
     * @param id  球队活动ID
     * @return  球队活动信息
     */
	public Activity selectActivityById(Long id);
	
	/**
     * 查询 球队活动列表
     * 
     * @param activity  球队活动信息
     * @return  球队活动集合
     */
	public List<Activity> selectActivityList(Activity activity);
	
	/**
     * 查询 最近球队活动列表
     * 
     * @param activity  球队活动信息
     * @return  球队活动集合
     */
	public List<Activity> selectActivityListTop(Integer top);
	
	/**
     * 新增 球队活动
     * 
     * @param activity  球队活动信息
     * @return 结果
     */
	public int insertActivity(Activity activity);
	
	/**
     * 修改 球队活动
     * 
     * @param activity  球队活动信息
     * @return 结果
     */
	public int updateActivity(Activity activity);
	
	/**
     * 删除 球队活动
     * 
     * @param id  球队活动ID
     * @return 结果
     */
	public int deleteActivityById(Long id);
	
	/**
     * 批量删除 球队活动
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteActivityByIds(String[] ids);
	
	/**批量插入活动关联的用户
	 * 
	 * **/
	public int insertActivityUser(Map map);
	
	/**
	 * 删除活动关联的所有用户关系
	 * */
	public int deleteActivityUserByActivityid(Long activityid);
	
	/**
	 * 查询活动相关用户ID
	 * 
	 * */
	public List selectActivityUserIDByActivityid(Long activityid);
	
}