package org.hut.service;

import java.util.List;

import org.hut.pojo.BankAccount;

public interface BankAccountService {
	/**
	 * 根据用户id查询所有名下银行卡
	 * @param custId
	 * @return
	 */
	public List<BankAccount> queryCardById(Integer customerId);
	
	/**
	 * 
	 * 删除，批量删除
	 * @param id
	 * @return
	 */
	public int deleteCard(String[] ids);
	/**
	 * 
	 * 增加银行卡
	 * @param bank
	 * @return
	 */
	public int insertCard(BankAccount bank);
	
	/**
	 * 
	 * 修改银行卡信息
	 * @param bank
	 * @return
	 */
	public int updateCard(BankAccount bank);


}
