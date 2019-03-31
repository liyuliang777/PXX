package org.hut.pojo;

public class Query {
	/*
	 * 期限、收益率、类型、产品名称,产品状态
	 */
	private String qQiXian;//用abcd分表示一年以内,1年-3年,3年-5年,5年以上
	
	private String qShouYiLv;//用abcd分别表示3%~5%,5%~7%,7%~9%,9%以上
		
	private Integer qType;//根据产品类型id查找
	
	private String qProName;
	
	private String qProState;
	
       

	public Integer getqType() {
		return qType;
	}
	public void setqType(Integer qType) {
		this.qType = qType;
	}
	public String getqProName() {
		return qProName;
	}
	public void setqProName(String qProName) {
		this.qProName = qProName;
	}
	public String getqProState() {
		return qProState;
	}
	public void setqProState(String qProState) {
		this.qProState = qProState;
	}

	public String getqQiXian() {
		return qQiXian;
	}
	public void setqQiXian(String qQiXian) {
		this.qQiXian = qQiXian;
	}
	public String getqShouYiLv() {
		return qShouYiLv;
	}
	public void setqShouYiLv(String qShouYiLv) {
		this.qShouYiLv = qShouYiLv;
	}
	

}
