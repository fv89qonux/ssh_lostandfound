package com.lin.lostandfound.domain;

// Generated 2016-12-5 10:18:18 by Hibernate Tools 4.0.0

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Lostthings generated by hbm2java
 */
public class LostThings implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String thingsName;
	private String lostPlace;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lostTime;
	private String thingsType;
	private String thingsNo;
	private String thingsImg;
	private String thingsDes;
	private Date publishTime;
	private int status;
	private String userName;
	private long uid;

	public LostThings() {
	}

	public LostThings(String thingsName, String lostPlace, Date lostTime,
			String thingsType, String thingsDes, Date publishTime, int status,
			String userName, long uid) {
		this.thingsName = thingsName;
		this.lostPlace = lostPlace;
		this.lostTime = lostTime;
		this.thingsType = thingsType;
		this.thingsDes = thingsDes;
		this.publishTime = publishTime;
		this.status = status;
		this.userName = userName;
		this.uid = uid;
	}

	public LostThings(String thingsName, String lostPlace, Date lostTime,
			String thingsType, String thingsNo, String thingsImg,
			String thingsDes, Date publishTime, int status, String userName, long uid) {
		this.thingsName = thingsName;
		this.lostPlace = lostPlace;
		this.lostTime = lostTime;
		this.thingsType = thingsType;
		this.thingsNo = thingsNo;
		this.thingsImg = thingsImg;
		this.thingsDes = thingsDes;
		this.publishTime = publishTime;
		this.status = status;
		this.userName = userName;
		this.uid = uid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getThingsName() {
		return this.thingsName;
	}

	public void setThingsName(String thingsName) {
		this.thingsName = thingsName;
	}

	public String getLostPlace() {
		return this.lostPlace;
	}

	public void setLostPlace(String lostPlace) {
		this.lostPlace = lostPlace;
	}

	public Date getLostTime() {
		return this.lostTime;
	}

	public void setLostTime(Date lostTime) {
		this.lostTime = lostTime;
	}

	public String getThingsType() {
		return this.thingsType;
	}

	public void setThingsType(String thingsType) {
		this.thingsType = thingsType;
	}

	public String getThingsNo() {
		return this.thingsNo;
	}

	public void setThingsNo(String thingsNo) {
		this.thingsNo = thingsNo;
	}

	public String getThingsImg() {
		return this.thingsImg;
	}

	public void setThingsImg(String thingsImg) {
		this.thingsImg = thingsImg;
	}

	public String getThingsDes() {
		return this.thingsDes;
	}

	public void setThingsDes(String thingsDes) {
		this.thingsDes = thingsDes;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
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

	public long getUid() {
		return this.uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "LostThings [id=" + id + ", thingsName=" + thingsName
				+ ", lostPlace=" + lostPlace + ", lostTime=" + lostTime
				+ ", thingsType=" + thingsType + ", thingsNo=" + thingsNo
				+ ", thingsImg=" + thingsImg + ", thingsDes=" + thingsDes
				+ ", publishTime=" + publishTime + ", status=" + status
				+ ", userName=" + userName + ", uid=" + uid + "]";
	}

}
