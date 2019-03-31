package org.hut.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderTable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id ;
	private String ordNum ; //订单编号
	private Apply proApply ;  //产品信息
	private Integer ordCustomerId ;//客户id
	private Integer ordBookingQuota ;//预约额度(万)
	private String ordSfCheckType ;//身份审核状态
	private String ordCwCheckType;//财务审核状态
	private String ordType ;//订单状态
	@DateTimeFormat(pattern="yyyy/MM/dd")
    private Date ordDate ;//订单生成时间
    private String ordSfCheckPeople ;//身份审核人
    private String ordCwCheckPeople ;//财务审核人
    private Integer ordContractId;//合同编号
    private Integer ordQypzId ;//权益凭证编号
    private BankAccount ordCusCard ;//客户银行卡
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrdNum() {
		return ordNum;
	}
	public void setOrdNum(String ordNum) {
		this.ordNum = ordNum;
	}
	public Apply getProApply() {
		return proApply;
	}
	public void setProApply(Apply proApply) {
		this.proApply = proApply;
	}
	public Integer getOrdCustomerId() {
		return ordCustomerId;
	}
	public void setOrdCustomerId(Integer ordCustomerId) {
		this.ordCustomerId = ordCustomerId;
	}
	public Integer getOrdBookingQuota() {
		return ordBookingQuota;
	}
	public void setOrdBookingQuota(Integer ordBookingQuota) {
		this.ordBookingQuota = ordBookingQuota;
	}
	public String getOrdSfCheckType() {
		return ordSfCheckType;
	}
	public void setOrdSfCheckType(String ordSfCheckType) {
		this.ordSfCheckType = ordSfCheckType;
	}
	public String getOrdCwCheckType() {
		return ordCwCheckType;
	}
	public void setOrdCwCheckType(String ordCwCheckType) {
		this.ordCwCheckType = ordCwCheckType;
	}
	public String getOrdType() {
		return ordType;
	}
	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}
	public Date getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}
	public String getOrdSfCheckPeople() {
		return ordSfCheckPeople;
	}
	public void setOrdSfCheckPeople(String ordSfCheckPeople) {
		this.ordSfCheckPeople = ordSfCheckPeople;
	}
	public String getOrdCwCheckPeople() {
		return ordCwCheckPeople;
	}
	public void setOrdCwCheckPeople(String ordCwCheckPeople) {
		this.ordCwCheckPeople = ordCwCheckPeople;
	}
	public Integer getOrdContractId() {
		return ordContractId;
	}
	public void setOrdContractId(Integer ordContractId) {
		this.ordContractId = ordContractId;
	}
	public Integer getOrdQypzId() {
		return ordQypzId;
	}
	public void setOrdQypzId(Integer ordQypzId) {
		this.ordQypzId = ordQypzId;
	}
	public BankAccount getOrdCusCard() {
		return ordCusCard;
	}
	public void setOrdCusCard(BankAccount ordCusCard) {
		this.ordCusCard = ordCusCard;
	}
	@Override
	public String toString() {
		return "OrderTable [id=" + id + ", ordNum=" + ordNum + ", proApply=" + proApply + ", ordCustomerId="
				+ ordCustomerId + ", ordBookingQuota=" + ordBookingQuota + ", ordSfCheckType=" + ordSfCheckType
				+ ", ordCwCheckType=" + ordCwCheckType + ", ordType=" + ordType + ", ordDate=" + ordDate
				+ ", ordSfCheckPeople=" + ordSfCheckPeople + ", ordCwCheckPeople=" + ordCwCheckPeople
				+ ", ordContractId=" + ordContractId + ", ordQypzId=" + ordQypzId + ", ordCusCard=" + ordCusCard + "]";
	}
}
