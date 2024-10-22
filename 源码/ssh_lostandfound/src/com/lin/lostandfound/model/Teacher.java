package com.lin.lostandfound.model;

// Generated 2017-4-20 10:53:03 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * Teacher generated by hbm2java
 */
public class Teacher implements java.io.Serializable {

	private String teacherNo;
	private String teacherName;
	private String sex;
	private Date birth;
	private String idCard;
	private String telPhone;

	public Teacher() {
	}

	public Teacher(String teacherNo, String teacherName, String sex,
			Date birth, String idCard, String telPhone) {
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.sex = sex;
		this.birth = birth;
		this.idCard = idCard;
		this.telPhone = telPhone;
	}

	public String getTeacherNo() {
		return this.teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getTelPhone() {
		return this.telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

}
