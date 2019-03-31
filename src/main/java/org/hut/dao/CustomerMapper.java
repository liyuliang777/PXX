package org.hut.dao;

import org.hut.pojo.Customer;

public interface CustomerMapper {

	/**
	 * 查询数据
	 * @param customer
	 * @return
	 */
	Customer selectCustomer(Customer customer);

	/**
	 * 查询数据
	 * @param cusMobilePhone
	 * @return
	 */
	String selectCusMobilePhone(String cusMobilePhone);

	/**
	 * 插入数据
	 * @param customer
	 * @return
	 */
	int insertCustomer(Customer customer);
	
	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	Customer selectCustomerById(Integer id);

	/**
	 * 更新数据
	 * @param customer
	 * @return
	 */
	int updateCustomer(Customer customer);

}
