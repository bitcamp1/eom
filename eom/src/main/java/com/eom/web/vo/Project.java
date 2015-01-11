package com.eom.web.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class Project implements Serializable{
	private static final long serialVersionUID = 1L;
	
	static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	protected Integer	no;
	protected String		title;
	protected String		description;
	protected Date		startDate;
	protected Date		endDate;
	protected Collection<Member> members;
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public Collection<Member> getMembers() {
		return members;
	}
	public void setMembers(Collection<Member> members) {
		this.members = members;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public String getStartDateString() {
		return df.format(startDate);
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public String getEndDateString() {
		return df.format(endDate);
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

}
