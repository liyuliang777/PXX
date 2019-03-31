package org.hut.pojo;

import java.io.Serializable;

public class Apply implements Serializable {
	private Integer proId;  //主键Id；
	private String proNo;   //产品编号；
	private String proName;  //产品名称；
	private Integer proScale;  //产品规模；
	private Integer proDateline;  //产品融资期限；
	private double proReceipts;  //预期收益；
	private String proDept;  //登记备案机构：部门
	private String proInvest;  //资金用途
	private Integer proSubstate;  //提交状态
	private String proDetailId;  //产品详情编号
	private ProductType productType;  //产品类型（字典表主键）
	public Apply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public String getProNo() {
		return proNo;
	}
	public void setProNo(String proNo) {
		this.proNo = proNo;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Integer getProScale() {
		return proScale;
	}
	public void setProScale(Integer proScale) {
		this.proScale = proScale;
	}
	public Integer getProDateline() {
		return proDateline;
	}
	public void setProDateline(Integer proDateline) {
		this.proDateline = proDateline;
	}
	public Double getProReceipts() {
		return proReceipts;
	}
	public void setProReceipts(Double proReceipts) {
		this.proReceipts = proReceipts;
	}
	public String getProDept() {
		return proDept;
	}
	public void setProDept(String proDept) {
		this.proDept = proDept;
	}
	public String getProInvest() {
		return proInvest;
	}
	public void setProInvest(String proInvest) {
		this.proInvest = proInvest;
	}
	public Integer getProSubstate() {
		return proSubstate;
	}
	public void setProSubstate(Integer proSubstate) {
		this.proSubstate = proSubstate;
	}
	public String getProDetailId() {
		return proDetailId;
	}
	public void setProDetailId(String proDetailId) {
		this.proDetailId = proDetailId;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	
	
}