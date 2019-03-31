package org.hut.service;

import org.hut.pojo.Customer;

public interface CustomerService {
	
	/**
	 * 查询客户信息
	 * @param customer
	 * @return
	 */
	Customer findCustomer(Customer customer);

	/**
	 * 验证手机号是否被注册
	 * @param cusMobilePhone
	 * @return
	 */
	String findCusMobilePhone(String cusMobilePhone);

	/**
	 * 发送短信验证码
	 * @param cusMobilePhone
	 * @return
	 */
	String sendPhoneCode(String cusMobilePhone);
	
	/**
	 * 保存客户信息
	 * @param customer
	 * @return
	 */
	Customer saveCustomer(Customer customer);

	/**
	 * 客户id查询客户信息
	 * @param id
	 * @return
	 */
	Customer findCustomer(Integer id);

	/**
	 * 实名认证
	 * @param id
	 * @param cusName
	 * @param cusCardId
	 * @return
	 */
	boolean verifiedCustomer(Integer id, String cusName, String cusCardId) throws InterruptedException ;

	/**
	 * 完善客户信息
	 * @param customer
	 * @return
	 */
	boolean completeCustomer(Customer customer);
	
	/**
	 * 完善客户信息
	 * @param customer
	 * @return
	 */
	boolean modifyCustomer(Customer customer);
	
	/**
	 *  修改密码
	 * @param customer
	 * @return
	 */
	boolean modifyCustomerPassword(Customer customer);

}
