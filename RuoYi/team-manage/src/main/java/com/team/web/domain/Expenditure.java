package com.team.web.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 球队支出表 tm_expenditure
 * 
 * @author chenhuan
 * @date 2018-10-26
 */
public class Expenditure extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 费用ID */
	private Long id;
	/** 费用名称 */
	private String costName;
	/** 费用类型ID */
	private Integer costTypeId;
	/** 费用类型名称 */
	private String costTypeName;
	/**  备注 */
	private String remarks;
	/** 费用金额 */
	private BigDecimal costAmount;
	/** 冲销金额 */
	private BigDecimal writeOffAmount;
	public String getCostTypeName() {
		return costTypeName;
	}

	public void setCostTypeName(String costTypeName) {
		this.costTypeName = costTypeName;
	}

	/** 是否冲销结束1是 0否 */
	private Integer isWriteOff;
	/**球队活动ID*/
	private BigInteger activityId;
	/**活动名称*/
	private String activityName;
	/**支出时间*/
	private String expenditureTime;

	public String getExpenditureTime() {
		return expenditureTime;
	}

	public void setExpenditureTime(String expenditureTime) {
		this.expenditureTime = expenditureTime;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public BigInteger getActivityId() {
		return activityId;
	}

	public void setActivityId(BigInteger activityId) {
		this.activityId = activityId;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setCostName(String costName) 
	{
		this.costName = costName;
	}

	public String getCostName() 
	{
		return costName;
	}
	public void setCostTypeId(Integer costTypeId) 
	{
		this.costTypeId = costTypeId;
	}

	public Integer getCostTypeId() 
	{
		return costTypeId;
	}
	public void setRemarks(String remarks) 
	{
		this.remarks = remarks;
	}

	public String getRemarks() 
	{
		return remarks;
	}
	public void setCostAmount(BigDecimal costAmount) 
	{
		this.costAmount = costAmount;
	}

	public BigDecimal getCostAmount() 
	{
		return costAmount;
	}
	public void setWriteOffAmount(BigDecimal writeOffAmount) 
	{
		this.writeOffAmount = writeOffAmount;
	}

	public BigDecimal getWriteOffAmount() 
	{
		return writeOffAmount;
	}
	public void setIsWriteOff(Integer isWriteOff) 
	{
		this.isWriteOff = isWriteOff;
	}

	public Integer getIsWriteOff() 
	{
		return isWriteOff;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("costName", getCostName())
            .append("costTypeId", getCostTypeId())
            .append("remarks", getRemarks())
            .append("costAmount", getCostAmount())
            .append("writeOffAmount", getWriteOffAmount())
            .append("isWriteOff", getIsWriteOff())
            .toString();
    }
}
