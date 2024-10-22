package com.lin.lostandfound.model;

// Generated 2017-4-20 10:53:03 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * Expressthanks generated by hbm2java
 */
public class Expressthanks implements java.io.Serializable {

	private Long id;
	private String title;
	private String substance;
	private int status;
	private String userName;
	private Date leaveTime;

	public Expressthanks() {
	}

	public Expressthanks(String title, String substance, int status,
			String userName, Date leaveTime) {
		this.title = title;
		this.substance = substance;
		this.status = status;
		this.userName = userName;
		this.leaveTime = leaveTime;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubstance() {
		return this.substance;
	}

	public void setSubstance(String substance) {
		this.substance = substance;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getLeaveTime() {
		return this.leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

}
