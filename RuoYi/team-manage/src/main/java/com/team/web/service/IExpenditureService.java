package com.team.web.service;

import java.util.List;

import com.team.web.domain.Expenditure;

/**
 * 球队支出 服务层
 * 
 * @author ruoyi
 * @date 2018-10-26
 */
public interface IExpenditureService 
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
     * 删除球队支出信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteExpenditureByIds(String ids);
	
	
	/**
	 * 支出冲销
	 * @param expenditure 球队支出信息
	 * **/
	public int updateExpenditureWriteOffAmount(Expenditure expenditure);
}
