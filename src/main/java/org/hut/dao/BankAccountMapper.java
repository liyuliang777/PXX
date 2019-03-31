package org.hut.dao;

import java.util.List;

import org.hut.pojo.BankAccount;

public interface BankAccountMapper {
	public List<BankAccount> queryCardById(Integer custId);
	
	public int deleteCard(Integer id);
	
	public int insertCard(BankAccount bank);
	
	public int updateCard(BankAccount bank);
	
	
	
}
