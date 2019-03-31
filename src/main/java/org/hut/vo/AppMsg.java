package org.hut.vo;

public class AppMsg {
	
	private String host;//api,如：https://cxkjsms.market.alicloudapi.com
	private String path;//地址，如：/chuangxinsms/dxjk
	private String method = "GET";//请求方式，如：post
	private String appCode;//产品码，你自己的AppCode
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	
}
