package com.team.web.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;
import com.team.web.domain.Expenditure;
import com.team.web.mapper.ExpenditureMapper;
import com.team.web.service.IExpenditureService;

/**
 * 球队支出 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-26
 */
@Service
public class ExpenditureServiceImpl implements IExpenditureService 
{
	@Autowired
	private ExpenditureMapper expenditureMapper;

	/**
     * 查询球队支出信息
     * 
     * @param id 球队支出ID
     * @return 球队支出信息
     */
    @Override
	public Expenditure selectExpenditureById(Long id)
	{
	    return expenditureMapper.selectExpenditureById(id);
	}
	
	/**
     * 查询球队支出列表
     * 
     * @param expenditure 球队支出信息
     * @return 球队支出集合
     */
	@Override
	public List<Expenditure> selectExpenditureList(Expenditure expenditure)
	{
	    return expenditureMapper.selectExpenditureList(expenditure);
	}
	
    /**
     * 新增球队支出
     * 
     * @param expenditure 球队支出信息
     * @return 结果
     */
	@Override
	public int insertExpenditure(Expenditure expenditure)
	{
	    return expenditureMapper.insertExpenditure(expenditure);
	}
	
	/**
     * 修改球队支出
     * 
     * @param expenditure 球队支出信息
     * @return 结果
     */
	@Override
	public int updateExpenditure(Expenditure expenditure)
	{
	    return expenditureMapper.updateExpenditure(expenditure);
	}

	/**
     * 删除球队支出对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExpenditureByIds(String ids)
	{
		return expenditureMapper.deleteExpenditureByIds(Convert.toStrArray(ids));
	}
	
	/**支出冲销*/
	@Override
	public int updateExpenditureWriteOffAmount(Expenditure expenditure) {
		
		return expenditureMapper.updateExpenditureWriteOffAmount(expenditure);
	}
	
}
