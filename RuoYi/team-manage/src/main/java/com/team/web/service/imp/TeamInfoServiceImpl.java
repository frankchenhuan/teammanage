package com.team.web.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;
import com.team.web.domain.TeamInfo;
import com.team.web.mapper.TeamInfoMapper;
import com.team.web.service.ITeamInfoService;

/**
 * 球队资金  服务层实现
 * 
 * @author 陈焕
 * @date 2018-10-26
 */
@Service
public class TeamInfoServiceImpl implements ITeamInfoService 
{
	@Autowired
	private TeamInfoMapper teamInfoMapper;

	/**
     * 查询球队资金 信息
     * 
     * @param id 球队资金 ID
     * @return 球队资金 信息
     */
    @Override
	public TeamInfo selectTeamInfoById(Integer id)
	{
	    return teamInfoMapper.selectTeamInfoById(id);
	}
	
	/**
     * 查询球队资金 列表
     * 
     * @param teamInfo 球队资金 信息
     * @return 球队资金 集合
     */
	@Override
	public List<TeamInfo> selectTeamInfoList(TeamInfo teamInfo)
	{
	    return teamInfoMapper.selectTeamInfoList(teamInfo);
	}
	
    /**
     * 新增球队资金 
     * 
     * @param teamInfo 球队资金 信息
     * @return 结果
     */
	@Override
	public int insertTeamInfo(TeamInfo teamInfo)
	{
	    return teamInfoMapper.insertTeamInfo(teamInfo);
	}
	
	/**
     * 修改球队资金 
     * 
     * @param teamInfo 球队资金 信息
     * @return 结果
     */
	@Override
	public int updateTeamInfo(TeamInfo teamInfo)
	{
	    return teamInfoMapper.updateTeamInfo(teamInfo);
	}

	/**
     * 删除球队资金 对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeamInfoByIds(String ids)
	{
		return teamInfoMapper.deleteTeamInfoByIds(Convert.toStrArray(ids));
	}
	
}
