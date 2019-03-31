package org.hut.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id ;//主键
	private Integer cusId ;//客户id
    private String cusName ;//名字
    private String cusPwd  ;//密码
    private String cusMobilePhone ;//电话
    private String cusPhone ;//座机
    private String cusSex ;//性别
    private Date cusBirth;//生日
    private String cusHAddr ;//户籍所在地
    private String cusAddr ;//现居地
    private String cusWorkspace ;//工作单位
    private String cusEducation ;//学历
    private Integer cusYearInput ;//年收入(万)
    private String cusBeforeLoginIp ;//上一次登陆ip
    private Date cusBeforeLoginDate ;//上一次登陆时间
    private Date cusRegisterDate;//注册时间
    private String cusType ;//状态(禁用,冻结,正常使用)
    private String cusEmail ;//邮箱
    private Integer cusLoginNum ;//登陆次数
    private String cusRiskToleranceLevel ;//风险承受等级
    private Integer cusTotalMoney;//总资产(单位:元)
    private String cusCardId;//身份证号
    private List<BankAccount> bankAccounts;//银行卡信息
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCusId() {
		return cusId;
	}
	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusPwd() {
		return cusPwd;
	}
	public void setCusPwd(String cusPwd) {
		this.cusPwd = cusPwd;
	}
	public String getCusMobilePhone() {
		return cusMobilePhone;
	}
	public void setCusMobilePhone(String cusMobilePhone) {
		this.cusMobilePhone = cusMobilePhone;
	}
	public String getCusPhone() {
		return cusPhone;
	}
	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}
	public String getCusSex() {
		return cusSex;
	}
	public void setCusSex(String cusSex) {
		this.cusSex = cusSex;
	}
	public Date getCusBirth() {
		return cusBirth;
	}
	public void setCusBirth(Date cusBirth) {
		this.cusBirth = cusBirth;
	}
	public String getCusHAddr() {
		return cusHAddr;
	}
	public void setCusHAddr(String cusHAddr) {
		this.cusHAddr = cusHAddr;
	}
	public String getCusAddr() {
		return cusAddr;
	}
	public void setCusAddr(String cusAddr) {
		this.cusAddr = cusAddr;
	}
	public String getCusWorkspace() {
		return cusWorkspace;
	}
	public void setCusWorkspace(String cusWorkspace) {
		this.cusWorkspace = cusWorkspace;
	}
	public String getCusEducation() {
		return cusEducation;
	}
	public void setCusEducation(String cusEducation) {
		this.cusEducation = cusEducation;
	}
	public Integer getCusYearInput() {
		return cusYearInput;
	}
	public void setCusYearInput(Integer cusYearInput) {
		this.cusYearInput = cusYearInput;
	}
	public String getCusBeforeLoginIp() {
		return cusBeforeLoginIp;
	}
	public void setCusBeforeLoginIp(String cusBeforeLoginIp) {
		this.cusBeforeLoginIp = cusBeforeLoginIp;
	}
	public Date getCusBeforeLoginDate() {
		return cusBeforeLoginDate;
	}
	public void setCusBeforeLoginDate(Date cusBeforeLoginDate) {
		this.cusBeforeLoginDate = cusBeforeLoginDate;
	}
	public Date getCusRegisterDate() {
		return cusRegisterDate;
	}
	public void setCusRegisterDate(Date cusRegisterDate) {
		this.cusRegisterDate = cusRegisterDate;
	}
	public String getCusType() {
		return cusType;
	}
	public void setCusType(String cusType) {
		this.cusType = cusType;
	}
	public String getCusEmail() {
		return cusEmail;
	}
	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}
	public Integer getCusLoginNum() {
		return cusLoginNum;
	}
	public void setCusLoginNum(Integer cusLoginNum) {
		this.cusLoginNum = cusLoginNum;
	}
	public String getCusRiskToleranceLevel() {
		return cusRiskToleranceLevel;
	}
	public void setCusRiskToleranceLevel(String cusRiskToleranceLevel) {
		this.cusRiskToleranceLevel = cusRiskToleranceLevel;
	}
	public Integer getCusTotalMoney() {
		return cusTotalMoney;
	}
	public void setCusTotalMoney(Integer cusTotalMoney) {
		this.cusTotalMoney = cusTotalMoney;
	}
	public String getCusCardId() {
		return cusCardId;
	}
	public void setCusCardId(String cusCardId) {
		this.cusCardId = cusCardId;
	}
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
