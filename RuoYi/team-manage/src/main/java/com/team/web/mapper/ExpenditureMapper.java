package com.team.web.mapper;

import com.team.web.domain.Expenditure;
import java.util.List;	

/**
 * 球队支出 数据层
 * 
 * @author chenhuan
 * @date 2018-10-26
 */
public interface ExpenditureMapper 
{
	/**
     * 查询球队支出信息
     * 
     * @param id 球队支出ID
     * @return 球队支出信息
     */
	public Expenditure selectExpenditureById(Long id);
	
	/**
     * 查询球队支出列表
     * 
     * @param expenditure 球队支出信息
     * @return 球队支出集合
     */
	public List<Expenditure> selectExpenditureList(Expenditure expenditure);
	
	/**
     * 新增球队支出
     * 
     * @param expenditure 球队支出信息
     * @return 结果
     */
	public int insertExpenditure(Expenditure expenditure);
	
	/**
     * 修改球队支出
     * 
     * @param expenditure 球队支出信息
     * @return 结果
     */
	public int updateExpenditure(Expenditure expenditure);
	
	/**
     * 删除球队支出
     * 
     * @param id 球队支出ID
     * @return 结果
     */
	public int deleteExpenditureById(Long id);
	
	/**
     * 批量删除球队支出
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExpenditureByIds(String[] ids);
	
	/**
	 * 支出冲销
	 * @param expenditure 球队支出信息
	 * **/
	public int updateExpenditureWriteOffAmount(Expenditure expenditure);
	
}