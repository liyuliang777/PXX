package org.hut.vo;

public class BankAccount {
//	respCode响应码:
//	0000	结果匹配	信息准确，四个元素信息一致
//	0001	开户名不能为空	开户名不能为空
//	0002	银行卡号格式错误	银行卡号格式错误
//	0003	身份证号格式错误	身份证号格式错误
//	0004	手机号不能为空	手机号不能为空
//	0005	手机号格式错误	手机号格式错误
//	0006	银行卡号不能为空	银行卡号不能为空
//	0007	身份证号不能为空	身份证号不能为空
//	0008	信息不匹配	信息不匹配
	private String name;//持卡人
	private String cardNo;//银行卡号
	private String idNo;//持卡人身份证号
	private String phoneNo;//手机号码
	private String respMessage;//提示消息
	private String respCode;//响应码
	private String bankName;//银行名称
	private String bankKind;//银行卡类型
	private String bankType;//类型：信用卡
	private String bankCode;//CMB
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getRespMessage() {
		return respMessage;
	}
	public void setRespMessage(String respMessage) {
		this.respMessage = respMessage;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankKind() {
		return bankKind;
	}
	public void setBankKind(String bankKind) {
		this.bankKind = bankKind;
	}
	public String getBankType() {
		return bankType;
	}
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
}
