package com.team.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * 用户扣费记录表 tm_user_deductions
 * 
 * @author chenhuan
 * @date 2018-10-26
 */
public class UserDeductions extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 扣除金额 */
	private BigDecimal deductionsAmount;
	/** 备注 */
	private String remarks;
	/** 扣费时间 */
	private Date deductionsTime;
	/** 用户名*/
	private String userName;
	/** 用户id */
	private Long userId;
	/**球队支出ID*/
	private Long expenditureId;
	/** 费用类型ID */
	private Integer costTypeId;
	/** 费用名称 */
	private String costName;
	/**支出日期**/
	private String expenditureDate;

	public String getExpenditureDate() {
		return expenditureDate;
	}

	public void setExpenditureDate(String expenditureDate) {
		this.expenditureDate = expenditureDate;
	}

	public String getCostName() {
		return costName;
	}

	public void setCostName(String costName) {
		this.costName = costName;
	}

	public Integer getCostTypeId() {
		return costTypeId;
	}

	public void setCostTypeId(Integer costTypeId) {
		this.costTypeId = costTypeId;
	}

	public Long getExpenditureId() {
		return expenditureId;
	}

	public void setExpenditureId(Long expenditureId) {
		this.expenditureId = expenditureId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setDeductionsAmount(BigDecimal deductionsAmount) 
	{
		this.deductionsAmount = deductionsAmount;
	}

	public BigDecimal getDeductionsAmount() 
	{
		return deductionsAmount;
	}
	public void setRemarks(String remarks) 
	{
		this.remarks = remarks;
	}

	public String getRemarks() 
	{
		return remarks;
	}
	public void setDeductionsTime(Date deductionsTime) 
	{
		this.deductionsTime = deductionsTime;
	}

	public Date getDeductionsTime() 
	{
		return deductionsTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deductionsAmount", getDeductionsAmount())
            .append("remarks", getRemarks())
            .append("deductionsTime", getDeductionsTime())
            .toString();
    }
}
