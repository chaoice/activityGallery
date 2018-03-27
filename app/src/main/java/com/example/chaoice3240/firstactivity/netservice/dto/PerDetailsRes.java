package com.example.chaoice3240.firstactivity.netservice.dto;

import java.io.Serializable;

public class PerDetailsRes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 442663985175639713L;
	
	private String cifNo;			//客户号
	
	private String cifUserName;    //登录用户名
	
	private String cifTel;			//手机号
	
	private String cifIdType;       //证件类型
	
	private String cifIdNo;         //证件号码
	
	private String cifName;         //客户名称
	
	private String cifEmail;        //邮箱信息
	
	private String cifInfo;         //预留信息
	
	private String resType;         //居民/非居民标志
	
	private String recNo;			//推荐码
	
	private String cifSex;          //性别
	
	private String cifNation;       //国籍
	
	private String cifEname;        //英文名
	
	private String cifHometel;       //家庭电话
	
	private String cifHomeaddr;      //家庭住址
	
	private String cifCopname;       //单位名称
	
	private String cifCopTel;		 //单位电话
	
	private String cifCopaddr;       //单位地址
	
	private String headPhoto;        //头像

	public String getCifNo() {
		return cifNo;
	}

	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
	}

	public String getCifTel() {
		return cifTel;
	}

	public void setCifTel(String cifTel) {
		this.cifTel = cifTel;
	}

	public String getCifIdType() {
		return cifIdType;
	}

	public void setCifIdType(String cifIdType) {
		this.cifIdType = cifIdType;
	}

	public String getCifIdNo() {
		return cifIdNo;
	}

	public void setCifIdNo(String cifIdNo) {
		this.cifIdNo = cifIdNo;
	}

	public String getCifName() {
		return cifName;
	}

	public void setCifName(String cifName) {
		this.cifName = cifName;
	}

	public String getCifEmail() {
		return cifEmail;
	}

	public void setCifEmail(String cifEmail) {
		this.cifEmail = cifEmail;
	}

	public String getCifInfo() {
		return cifInfo;
	}

	public void setCifInfo(String cifInfo) {
		this.cifInfo = cifInfo;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public String getRecNo() {
		return recNo;
	}

	public void setRecNo(String recNo) {
		this.recNo = recNo;
	}

	public String getCifSex() {
		return cifSex;
	}

	public void setCifSex(String cifSex) {
		this.cifSex = cifSex;
	}

	public String getCifNation() {
		return cifNation;
	}

	public void setCifNation(String cifNation) {
		this.cifNation = cifNation;
	}

	public String getCifEname() {
		return cifEname;
	}

	public void setCifEname(String cifEname) {
		this.cifEname = cifEname;
	}

	public String getCifHomeaddr() {
		return cifHomeaddr;
	}

	public void setCifHomeaddr(String cifHomeaddr) {
		this.cifHomeaddr = cifHomeaddr;
	}

	public String getCifCopname() {
		return cifCopname;
	}

	public void setCifCopname(String cifCopname) {
		this.cifCopname = cifCopname;
	}

	public String getCifCopaddr() {
		return cifCopaddr;
	}

	public void setCifCopaddr(String cifCopaddr) {
		this.cifCopaddr = cifCopaddr;
	}

	public String getHeadPhoto() {
		return headPhoto;
	}

	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}

	public String getCifCopTel() {
		return cifCopTel;
	}

	public void setCifCopTel(String cifCopTel) {
		this.cifCopTel = cifCopTel;
	}

	public String getCifUserName() {
		return cifUserName;
	}

	public void setCifUserName(String cifUserName) {
		this.cifUserName = cifUserName;
	}

	public String getCifHometel() {
		return cifHometel;
	}

	public void setCifHometel(String cifHometel) {
		this.cifHometel = cifHometel;
	}
	

}
