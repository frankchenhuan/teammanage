package com.team.web.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 用户余额表 tm_user_balance
 * 
 * @author 陈焕
 * @date 2018-10-18
 */
public class UserBalance extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 用户id */
	private Long userId;
	/** 余额 */
	private BigDecimal balance;
	/** 用户名 **/
	private String userName;
	/**充值类型*/
	private String rechargeType;
	/** 充值总额*/
	private BigDecimal amount;
	/**总活动次数*/
	private Integer activityCount1;
	/**最近活动次数*/
	private Integer activityCount2;
	

	public Integer getActivityCount1() {
		return activityCount1;
	}

	public void setActivityCount1(Integer activityCount1) {
		this.activityCount1 = activityCount1;
	}

	public Integer getActivityCount2() {
		return activityCount2;
	}

	public void setActivityCount2(Integer activityCount2) {
		this.activityCount2 = activityCount2;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setBalance(BigDecimal balance) 
	{
		this.balance = balance;
	}

	public BigDecimal getBalance() 
	{
		return balance;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("balance", getBalance())
            .toString();
    }
}
