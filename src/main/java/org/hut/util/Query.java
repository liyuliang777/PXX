/**
 * 
 */
package org.hut.util;


import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 */
@Component
@Scope("prototype")
public class Query {
	private String productName; //产品名称
	private String qproReceipts;  //预期收益率
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date startordDate;    //订单生成时间的开始范围
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date endordDate;    //订单生成时间的结束范围
	private Integer startordBookingQuota; //预约金额的初始值
	private Integer endordBookingQuota; //预约金额的最后值
	private Integer qcustomerId;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQproReceipts() {
		return qproReceipts;
	}
	public void setQproReceipts(String qproReceipts) {
		this.qproReceipts = qproReceipts;
	}
	public Date getStartordDate() {
		return startordDate;
	}
	public void setStartordDate(Date startordDate) {
		this.startordDate = startordDate;
	}
	public Date getEndordDate() {
		return endordDate;
	}
	public void setEndordDate(Date endordDate) {
		this.endordDate = endordDate;
	}
	public Integer getStartordBookingQuota() {
		return startordBookingQuota;
	}
	public void setStartordBookingQuota(Integer startordBookingQuota) {
		this.startordBookingQuota = startordBookingQuota;
	}
	public Integer getEndordBookingQuota() {
		return endordBookingQuota;
	}
	public void setEndordBookingQuota(Integer endordBookingQuota) {
		this.endordBookingQuota = endordBookingQuota;
	}
	public Integer getQcustomerId() {
		return qcustomerId;
	}
	public void setQcustomerId(Integer qcustomerId) {
		this.qcustomerId = qcustomerId;
	}	
}
