package org.hut.service.impl;

import java.util.List;

import org.hut.dao.BankAccountMapper;
import org.hut.pojo.BankAccount;
import org.hut.service.BankAccountService;
import org.hut.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
@Service
public class BankAccountServiceImpl implements BankAccountService{
	@Autowired
	private BankAccountMapper bankAccountMapper;
	@Autowired
	private RedisService rs;
	@Override
	public List<BankAccount> queryCardById(Integer customerId) {
//		List<BankAccount> cardList=null;
//		Jedis jedis=rs.getResource();
//		cardList=(List<BankAccount>)JSON.parse(jedis.get("cardList")); 
//		if(cardList==null) {
		List<BankAccount> cardList=bankAccountMapper.queryCardById(customerId);
//			jedis.set("cardList", JSON.toJSONString(cardList));
//			
//		}
//		rs.returnResource(jedis);
		return cardList;
	}
	@Override
	public int deleteCard(String[] ids) {
		int num=0;
		for(String id:ids) {
			num=bankAccountMapper.deleteCard(new Integer(id));
		}
		
		return num;
	}
	@Override
	public int insertCard(BankAccount bank) {
		return bankAccountMapper.insertCard(bank) ;
	}
	@Override
	public int updateCard(BankAccount bank) {
		// TODO Auto-generated method stub
		return bankAccountMapper.updateCard(bank);
	}

}
