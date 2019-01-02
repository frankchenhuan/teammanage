package com.team.web.service;

import java.util.List;

import com.team.web.domain.TeamInfo;

/**
 * 球队资金  服务层
 * 
 * @author ruoyi
 * @date 2018-10-26
 */
public interface ITeamInfoService 
{
	/**
     * 查询球队资金 信息
     * 
     * @param id 球队资金 ID
     * @return 球队资金 信息
     */
	public TeamInfo selectTeamInfoById(Integer id);
	
	/**
     * 查询球队资金 列表
     * 
     * @param teamInfo 球队资金 信息
     * @return 球队资金 集合
     */
	public List<TeamInfo> selectTeamInfoList(TeamInfo teamInfo);
	
	/**
     * 新增球队资金 
     * 
     * @param teamInfo 球队资金 信息
     * @return 结果
     */
	public int insertTeamInfo(TeamInfo teamInfo);
	
	/**
     * 修改球队资金 
     * 
     * @param teamInfo 球队资金 信息
     * @return 结果
     */
	public int updateTeamInfo(TeamInfo teamInfo);
		
	/**
     * 删除球队资金 信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeamInfoByIds(String ids);
	
}
