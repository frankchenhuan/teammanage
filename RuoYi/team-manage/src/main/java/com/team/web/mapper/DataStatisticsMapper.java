package com.team.web.mapper;

import java.util.List;
import java.util.Map;

public interface DataStatisticsMapper {

	/**查询球队支出比例**/
	public List<Map> selectExpenditureRatio();
	
	/**球队出勤最多的成员*/
	public List<Map> selectUserAttendance(Map map);
	
	/**最近出勤最多的成员*/
	public List<Map> selectUserLatelyAttendance(Map map);
	
	/**查询球队活跃度数据*/
	public List<Map> selectActivityLevel(Map map);
	
	/**查询用户活跃度数据*/
	public List<Map> selectUserActivityLevel(Map map);
	
	/**查询用户年度支出*/
	public List<Map> selectUserYearExpenditure(Map map);
	
	/**查询用户支出比例**/
	public List<Map> selectUserExpenditureRatio(Map map);
	
	/**查询球队年度支出*/
	public List<Map> selectYearExpenditure(Map map);
	
	
}
