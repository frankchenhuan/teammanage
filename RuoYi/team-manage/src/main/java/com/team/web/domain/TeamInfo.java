package com.team.web.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 用户余额表 tm_team_info
 * 
 * @author 陈焕
 * @date 2018-10-25
 */
public class TeamInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 球队ID */
	private Integer id;
	/** 收入资金 */
	private BigDecimal income;
	/** 球队名称 **/
	private String name;
	/**球队介绍*/
	private String introduce;
	/**支出*/
	private BigDecimal expenditure;
	/** 活动次数**/
	private Integer activityCount;


	public Integer getActivityCount() {
		return activityCount;
	}


	public void setActivityCount(Integer activityCount) {
		this.activityCount = activityCount;
	}


	public String getIntroduce() {
		return introduce;
	}


	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}


	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("teamId", this.getId())
            .append("teamName",this.getName())
            .toString();
    }


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public BigDecimal getIncome() {
		return income;
	}


	public void setIncome(BigDecimal income) {
		this.income = income;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getExpenditure() {
		return expenditure;
	}


	public void setExpenditure(BigDecimal expenditure) {
		this.expenditure = expenditure;
	}
}
