package org.hut.vo;
/**
 * 短信验证码配置类
 * @author Administrator
 *
 */
public class APIConfig {
	//短信验证码
	public static final String PHONE_HOST = "https://exempt.market.alicloudapi.com";//api,如：https://cxkjsms.market.alicloudapi.com
	public static final String PHONE_PATH = "/exemptCode";//地址，如：/chuangxinsms/dxjk
	public static final String PHONE_METHOD = "GET";//请求方式，如：post
	public static final String PHONE_APPCODE = "94d30d95a73841269075793c37885ecf";//产品码，你自己的AppCode
	public static final String PHONE_MOBILE = "phone";//手机号码的 key
	public static final String PHONE_CONTENT = "content"; //短信内容的key
	
	//实名认证
	public static final String VERIFIED_HOST = "http://vipidcardcheck.haoservice.com";//api,如：https://cxkjsms.market.alicloudapi.com
	public static final String VERIFIED_PATH = "/idcard/VerifyIdcardv2";//地址，如：/chuangxinsms/dxjk
	public static final String VERIFIED_METHOD = "GET";//请求方式，如：post
	public static final String VERIFIED_APPCODE = "94d30d95a73841269075793c37885ecf";//产品码，你自己的AppCode
	public static final String VERIFIED_REALNAME = "realName"; //真实姓名的key
	public static final String VERIFIED_IDCARD = "cardNo";	//身份证号码的key
	
	//银行接口
	public static final String BANK_HOST = "https://yunyidata.market.alicloudapi.com";//api,如：https://cxkjsms.market.alicloudapi.com
	public static final String BANK_PATH = "/bankAuthenticate4";//地址，如：/chuangxinsms/dxjk
	public static final String BANK_METHOD = "POST";//请求方式，如：post
	public static final String BANK_APPCODE = "94d30d95a73841269075793c37885ecf";//产品码，你自己的AppCode
	public static final String BANK_RETURNBANKINFO = "ReturnBankInfo";	//是否返回卡信息
	public static final String BANK_CARDNO = "cardNo";	//银行卡号
	public static final String BANK_IDCARD = "idNo";
	public static final String BANK_OWERNAME = "name";
	public static final String BANK_PHONE = "phoneNo";
}
