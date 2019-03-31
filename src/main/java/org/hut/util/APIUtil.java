package org.hut.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.hut.vo.AppMsg;
import org.hut.vo.APIConfig;
import org.springframework.stereotype.Component;

@Component
public class APIUtil {
	
	/**
	 * 公共方法
	 * @param appMsg 产品信息
	 * @param querys	查询数据
	 * @param bodys 不知有什么用
	 * @return
	 */
	public String baseAPIMethod(AppMsg appMsg, Map<String, String> querys,Map<String, String> bodys) {
		String host = appMsg.getHost();
		String path = appMsg.getPath();
		String method = appMsg.getMethod();
		String appCode = appMsg.getAppCode();
		
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appCode);
		HttpResponse response = null;
	    String msg = null;
	    try {
	    	if(bodys == null) 
		    	{
		    		response = HttpUtils.doGet(host, path, method, headers, querys);
		    	}else 
		    	{
		    		response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
		    	}
	    	System.out.println(response.toString());
	    	//获取response的body
	    	msg = EntityUtils.toString(response.getEntity());
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return msg;
	}
	
	/**
	 * 银行卡信息验证
	 * @param appMsg 接口调用信息
	 * @param ReturnBankInfo 是否返回银行卡信息
	 * @param cardNo	银行卡号
	 * @param idCard	身份证号
	 * @param name	持卡人
	 * @param phoneNo	手机号
	 * @return
	 */
	public String bankAccount(AppMsg appMsg,String ReturnBankInfo,String cardNo,String idCard,String name,String phoneNo) {
		
		Map<String, String> querys = new HashMap<String, String>();
		Map<String, String> bodys = null;
		if(appMsg.getMethod().equals("POST")) {
			bodys = new HashMap<String, String>();
		}
	    bodys.put(APIConfig.BANK_RETURNBANKINFO, ReturnBankInfo);
	    bodys.put(APIConfig.BANK_CARDNO, cardNo);
	    bodys.put(APIConfig.BANK_IDCARD, idCard);
	    bodys.put(APIConfig.BANK_OWERNAME, name);
	    bodys.put(APIConfig.BANK_PHONE, phoneNo);
	    return baseAPIMethod(appMsg, querys,bodys);
	}
	
	/**
	 * 实名认证
	 * @param appMsg	
	 * @param idCard 身份证号
	 * @param name	姓名
	 * @return status：01 通过	、02不通过
	 */
	public String verified(AppMsg appMsg,String idCard,String name) {
	    //身份信息
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put(APIConfig.VERIFIED_IDCARD, idCard);
	    querys.put(APIConfig.VERIFIED_REALNAME, name);
	    Map<String, String> bodys = null;
	    if(appMsg.getMethod().equals("POST")) {
	    	bodys = new HashMap<String, String>();
	    }
	    return baseAPIMethod(appMsg, querys, bodys);
	}
	
	/**
	 * 发送短信验证码
	 * @param appMsg
	 * @param idCard
	 * @param name
	 * @return
	 */
	public String sendPhoneCode(AppMsg appMsg,String idCard,String name) {
	    //身份信息
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put(APIConfig.VERIFIED_IDCARD, idCard);
	    querys.put(APIConfig.VERIFIED_REALNAME, name);
	    Map<String, String> bodys = null;
	    if(appMsg.getMethod().equals("POST")) {
	    	bodys = new HashMap<String, String>();
	    }
	    return baseAPIMethod(appMsg, querys, bodys);
	}
	
	
	public static void main(String[] args) {
		AppMsg appMsg = new AppMsg();
//		实名认证
//		appMsg.setHost(APIConfig.PHONE_HOST);
//		appMsg.setPath(APIConfig.PHONE_PATH);
//		appMsg.setMethod(APIConfig.PHONE_METHOD);
//		appMsg.setAppCode(APIConfig.PHONE_APPCODE);
//		String verified = new APIUtil().verified(appMsg, "513023199605087134", "甄道文");
//		System.out.println(verified);
		
		//短信验证码
		appMsg.setHost(APIConfig.VERIFIED_HOST);
		appMsg.setPath(APIConfig.VERIFIED_PATH);
		appMsg.setMethod(APIConfig.VERIFIED_METHOD);
		appMsg.setAppCode(APIConfig.VERIFIED_APPCODE);
		String code = Integer.toString((int) (Math.round(Math.random()*9000)+1000));
		String content = "【拼夕夕】您的验证码是：{"+code+"}，请在5分钟内使用。请勿泄露。";
		String phoneCode = new APIUtil().sendPhoneCode(appMsg, content, "13145828230");
		System.out.println(phoneCode);
	}
}
