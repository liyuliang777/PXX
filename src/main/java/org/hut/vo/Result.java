package org.hut.vo;


public class Result {
	private String realname;
	private String idcard;
	private boolean isok;
	private IdCardInfor IdCardInfor;
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public boolean isIsok() {
		return isok;
	}
	public void setIsok(boolean isok) {
		this.isok = isok;
	}
	public IdCardInfor getIdCardInfor() {
		return IdCardInfor;
	}
	public void setIdCardInfor(IdCardInfor idCardInfor) {
		IdCardInfor = idCardInfor;
	}
	@Override
	public String toString() {
		return "Result [realname=" + realname + ", idcard=" + idcard + ", isok=" + isok + ", IdCardInfor=" + IdCardInfor
				+ "]";
	}
}
