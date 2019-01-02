package com.team.web.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.web.mapper.DataStatisticsMapper;
import com.team.web.service.IDataStatisticsService;
@Service
public class DataStatisticsServiceImpl implements IDataStatisticsService {

	@Autowired
	private DataStatisticsMapper dataStatisticsMapper;
	
	@Override
	public List<Map> selectExpenditureRatio() {
		return this.dataStatisticsMapper.selectExpenditureRatio();
	}

	@Override
	public List<Map> selectUserAttendance(Map map) {
		return this.dataStatisticsMapper.selectUserAttendance(map);
	}

	@Override
	public List<Map> selectUserLatelyAttendance(Map map) {
		// TODO Auto-generated method stub
		return this.dataStatisticsMapper.selectUserLatelyAttendance(map);
	}

	@Override
	public List<Map> selectActivityLevel(Map map) {
		// TODO Auto-generated method stub
		return this.dataStatisticsMapper.selectActivityLevel(map);
	}
	
	@Override
	public List<Map> selectUserActivityLevel(Map map)
	{
		return this.dataStatisticsMapper.selectUserActivityLevel(map);
	}

	@Override
	public List<Map> selectUserYearExpenditure(Map map) {
		// TODO Auto-generated method stub
		return this.dataStatisticsMapper.selectUserYearExpenditure(map);
	}

	@Override
	public List<Map> selectUserExpenditureRatio(Map map) {
		// TODO Auto-generated method stub
		return this.dataStatisticsMapper.selectUserExpenditureRatio(map);
	}

	@Override
	public List<Map> selectYearExpenditure(Map map) {
		// TODO Auto-generated method stub
		return this.dataStatisticsMapper.selectYearExpenditure(map);
	}

}
