package com.salmon.scommerce.persistence.domain;

import java.util.Date;

public class AdminUser {
	
	private int userId;
	
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	
	private Date created;
	private Date modified;
	private Date logdate;
	
	private int lognum;
	private int reloadAclFlag;
	private int isActive;
	
	private String extra;
	private String rpToken;
	private Date rpTokenCreatedAt;
	
	private int failuresNum;
	private Date firstFailure;
	private Date lockExpires;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getLogdate() {
		return logdate;
	}
	public void setLogdate(Date logdate) {
		this.logdate = logdate;
	}
	public int getLognum() {
		return lognum;
	}
	public void setLognum(int lognum) {
		this.lognum = lognum;
	}
	public int getReloadAclFlag() {
		return reloadAclFlag;
	}
	public void setReloadAclFlag(int reloadAclFlag) {
		this.reloadAclFlag = reloadAclFlag;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getRpToken() {
		return rpToken;
	}
	public void setRpToken(String rpToken) {
		this.rpToken = rpToken;
	}
	public Date getRpTokenCreatedAt() {
		return rpTokenCreatedAt;
	}
	public void setRpTokenCreatedAt(Date rpTokenCreatedAt) {
		this.rpTokenCreatedAt = rpTokenCreatedAt;
	}
	public int getFailuresNum() {
		return failuresNum;
	}
	public void setFailuresNum(int failuresNum) {
		this.failuresNum = failuresNum;
	}
	public Date getFirstFailure() {
		return firstFailure;
	}
	public void setFirstFailure(Date firstFailure) {
		this.firstFailure = firstFailure;
	}
	public Date getLockExpires() {
		return lockExpires;
	}
	public void setLockExpires(Date lockExpires) {
		this.lockExpires = lockExpires;
	}
	
}
