package org.hut.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProDetail implements Serializable {
    private Long proId;

    private Apply apply;

    private String proTrustMeasure;//增信措施

    private String proRentSource;//还款来源

    private String proRiskMeasure;//风控措施

    private String proAdvt;//产品亮点

    private String proRaiseState;//募集状态

    private String proDirect;//项目方向

    private String proPaymentMeasure;//付息方式

    private Long proStartMoney;//起投金额

    private String proRistLevel;//风险评级

    private String proRegion;//项目地区

    private BigDecimal proRemain;//剩余规模

  

    private static final long serialVersionUID = 1L;

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }



    public String getProTrustMeasure() {
        return proTrustMeasure;
    }

    public void setProTrustMeasure(String proTrustMeasure) {
        this.proTrustMeasure = proTrustMeasure == null ? null : proTrustMeasure.trim();
    }

    public String getProRentSource() {
        return proRentSource;
    }

    public void setProRentSource(String proRentSource) {
        this.proRentSource = proRentSource == null ? null : proRentSource.trim();
    }

    public String getProRiskMeasure() {
        return proRiskMeasure;
    }

    public void setProRiskMeasure(String proRiskMeasure) {
        this.proRiskMeasure = proRiskMeasure == null ? null : proRiskMeasure.trim();
    }

    public String getProAdvt() {
        return proAdvt;
    }

    public void setProAdvt(String proAdvt) {
        this.proAdvt = proAdvt == null ? null : proAdvt.trim();
    }

    public String getProRaiseState() {
        return proRaiseState;
    }

    public void setProRaiseState(String proRaiseState) {
        this.proRaiseState = proRaiseState == null ? null : proRaiseState.trim();
    }

    public String getProDirect() {
        return proDirect;
    }

    public void setProDirect(String proDirect) {
        this.proDirect = proDirect == null ? null : proDirect.trim();
    }

    public String getProPaymentMeasure() {
        return proPaymentMeasure;
    }

    public void setProPaymentMeasure(String proPaymentMeasure) {
        this.proPaymentMeasure = proPaymentMeasure == null ? null : proPaymentMeasure.trim();
    }


    public Long getProStartMoney() {
        return proStartMoney;
    }

    public void setProStartMoney(Long proStartMoney) {
        this.proStartMoney = proStartMoney;
    }

    public String getProRistLevel() {
        return proRistLevel;
    }

    public void setProRistLevel(String proRistLevel) {
        this.proRistLevel = proRistLevel == null ? null : proRistLevel.trim();
    }



    public String getProRegion() {
        return proRegion;
    }

    public void setProRegion(String proRegion) {
        this.proRegion = proRegion == null ? null : proRegion.trim();
    }

    public BigDecimal getProRemain() {
        return proRemain;
    }

    public void setProRemain(BigDecimal proRemain) {
        this.proRemain = proRemain;
    }

	public Apply getApply() {
		return apply;
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}



}