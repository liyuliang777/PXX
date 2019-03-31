package org.hut.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.hut.dao.CustomerMapper;
import org.hut.pojo.Customer;
import org.hut.service.CustomerService;
import org.hut.util.APIUtil;
import org.hut.vo.Result;
import org.hut.vo.Verified;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Resource
	private CustomerMapper customerMapper;
	
	@Autowired
	private APIUtil phoneCodeImpl;
	
	/**
	 * 查询客户信息
	 */
	@Override
	public Customer findCustomer(Customer customer) {
		String IP = customer.getCusBeforeLoginIp();
		customer = customerMapper.selectCustomer(customer);
		//登录成功则更改登录时间和登录IP
		if(customer != null) {
			Customer customerUpdate = new Customer();
			customerUpdate.setId(customer.getId());//登录用户id
			customerUpdate.setCusBeforeLoginDate(new Date());//登录时间
			customerUpdate.setCusBeforeLoginIp(IP);//登录IP
			customerUpdate.setCusLoginNum(customer.getCusLoginNum()+1);//登录次数加一
			customerMapper.updateCustomer(customerUpdate);//修改登录信息
		}
		return customer;
	}
	
	/**
	 * 验证手机号是否被注册
	 */
	@Override
	public String findCusMobilePhone(String cusMobilePhone) {
		// TODO Auto-generated method stub
		return customerMapper.selectCusMobilePhone(cusMobilePhone);
	}

	/**
	 * 发送短信验证码
	 */
	@Override
	public String sendPhoneCode(String cusMobilePhone) {
		String code = Integer.toString((int) (Math.round(Math.random()*9000)+1000));
//		String content = "【创信】你的验证码是："+code+"，请尽快输入！！！";
//		AppMsg appMsg = new AppMsg();
//		appMsg.setHost(APIConfig.PHONE_HOST);
//		appMsg.setPath(APIConfig.PHONE_PATH);
//		appMsg.setMethod(APIConfig.PHONE_METHOD);
//		appMsg.setAppCode(APIConfig.PHONE_APPCODE);
//		phoneCodeImpl.sendPhoneCode(appMsg,content,cusMobilePhone);
		return code;
	}

	/**
	 * 保存客户信息
	 */
	@Override
	public Customer saveCustomer(Customer customer) {
		customer.setCusName("没有设置用户名");//用户名
		customer.setCusBeforeLoginDate(new Date());//登录时间
		customer.setCusRegisterDate(new Date());//注册时间
		customer.setCusType("冻结");//账户状态
		customer.setCusLoginNum(1);//登录次数
		customer.setCusRiskToleranceLevel("码蛆");//风险承受等级
		customer.setCusTotalMoney(0);//总资产
		int num = customerMapper.insertCustomer(customer);
		if(num == 1) {
			return customer;//添加成功返回当前用户信息
		}else {
			return null;//否则返回空
		}
	}

	/**
	 * 客户id查询客户
	 */
	@Override
	public Customer findCustomer(Integer id) {
		// TODO Auto-generated method stub
		return customerMapper.selectCustomerById(id);
	}
	
	
	/**
	 * 实名认证
		成功:
			{"error_code":0,"reason":"成功",
				"result":{"realname":"###","idcard":"###","isok":true,
					"IdCardInfor":{"area":"###","sex":"##","birthday":"####-##-##"}}}	
		失败:
			{"error_code":0,"reason":"成功",
				"result":{"realname":"###","idcard":"###","isok":false,
					"IdCardInfor":null}}
	 * @throws InterruptedException 
	 */
	@Override
	public boolean verifiedCustomer(Integer id, String cusName, String cusCardId) throws InterruptedException {
//		AppMsg appMsg = new AppMsg();
//		appMsg.setHost(APIConfig.VERIFIED_HOST);
//		appMsg.setPath(APIConfig.VERIFIED_PATH);
//		appMsg.setMethod(APIConfig.VERIFIED_METHOD);
//		appMsg.setAppCode(APIConfig.VERIFIED_APPCODE);
//		String verified = new APIUtil().verified(appMsg, cusCardId, cusName);
		//设置gson处理日期格式
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String verified = "{\"error_code\":0,\"reason\":\"成功\",\"result\":{\"realname\":\""+cusName+"\",\"idcard\":\""+cusCardId+"\",\"isok\":true,\"IdCardInfor\":{\"area\":\"湖北省黄冈市\",\"sex\":\"男\",\"birthday\":\"1994-11-27\"}}}";
		Verified fromJson = gson.fromJson(verified, Verified.class);
		//得到身份验证的结果
		Result result = fromJson.getResult();
		//验证通过,将实名认证获取的数据保存
		if(result.isIsok()) {
			//获取响应数据
			cusName = result.getRealname();
			cusCardId = result.getIdcard();
			String cusHAddr = result.getIdCardInfor().getArea();
			String cusSex = result.getIdCardInfor().getSex();
			Date cusBirth = result.getIdCardInfor().getBirthday(); 
			//添加到客户对象
			Customer customer = new Customer();
			customer.setId(id);
			customer.setCusName(cusName);;
			customer.setCusCardId(cusCardId);
			customer.setCusHAddr(cusHAddr);
			customer.setCusSex(cusSex);
			customer.setCusBirth(cusBirth);
			//保存信息
			int num = customerMapper.updateCustomer(customer);
//			Thread.sleep(2000);
			if(num == 1) {//保存成功
				return true;
			}
		}//保存失败
		return false;
	}

	/**
	 * 	完善客户信息
	 */
	@Override
	public boolean completeCustomer(Customer customer) {
		customer.setCusType("正常使用");
		return baseModify(customer);
	}

	
	/**
	 * 	修改用户信息
	 */
	@Override
	public boolean modifyCustomer(Customer customer) {
		return baseModify(customer);
	}

	/**
	 * 	修改密码
	 */
	@Override
	public boolean modifyCustomerPassword(Customer customer) {
		return baseModify(customer);
	}
	
	private boolean baseModify(Customer customer) {
		int num = customerMapper.updateCustomer(customer);
		if(num == 1) {
			return true;
		}
		return false;
	}

}
