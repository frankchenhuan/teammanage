package com.team.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 *  球队活动表 tm_activity
 * 
 * @author chenhuan
 * @date 2018-10-29
 */
public class Activity extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 活动ID */
	private Long id;
	/** 活动名称 */
	private String activityName;
	/** 活动日期 */
	private String activityDate;
	/** 人数 */
	private Integer peopleNumber;
	/** 备注 */
	private String remark;
	/** 活动地点 */
	private String activitySite;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setActivityName(String activityName) 
	{
		this.activityName = activityName;
	}

	public String getActivityName() 
	{
		return activityName;
	}
	public String getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}

	public void setPeopleNumber(Integer peopleNumber) 
	{
		this.peopleNumber = peopleNumber;
	}

	public Integer getPeopleNumber() 
	{
		return peopleNumber;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setActivitySite(String activitySite) 
	{
		this.activitySite = activitySite;
	}

	public String getActivitySite() 
	{
		return activitySite;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("activityName", getActivityName())
            .append("activityDate", getActivityDate())
            .append("peopleNumber", getPeopleNumber())
            .append("remark", getRemark())
            .append("activitySite", getActivitySite())
            .toString();
    }
}
