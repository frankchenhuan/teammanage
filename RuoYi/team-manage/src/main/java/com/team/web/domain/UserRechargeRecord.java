package com.team.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户充值记录表 tm_user_recharge_record
 * 
 * @author chenhuan
 * @date 2018-10-18
 */
public class UserRechargeRecord extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private Long id;
	/** 用户id */
	private Long userId;
	/** 充值金额 */
	private BigDecimal rechargeAmount;
	/** 充值时间 */
	private Date rechargeTime;
	/** 用户名*/
	private String userName;
	/**充值类型*/
	private String rechargeType;



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

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setRechargeAmount(BigDecimal rechargeAmount) 
	{
		this.rechargeAmount = rechargeAmount;
	}

	public BigDecimal getRechargeAmount() 
	{
		return rechargeAmount;
	}
	public void setRechargeTime(Date rechargeTime) 
	{
		this.rechargeTime = rechargeTime;
	}

	public Date getRechargeTime() 
	{
		return rechargeTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("rechargeAmount", getRechargeAmount())
            .append("rechargeTime", getRechargeTime())
            .toString();
    }
}
