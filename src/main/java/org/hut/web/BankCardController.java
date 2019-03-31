package org.hut.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hut.pojo.BankAccount;
import org.hut.pojo.Customer;
import org.hut.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class BankCardController {
	@Autowired
	private BankAccountService bankAccountService;
	@RequestMapping("/getcard")
	public String getCard(HttpSession session,Model model) {
		Customer customer=(Customer)session.getAttribute("customer");
		List<BankAccount> cardList=bankAccountService.queryCardById(customer.getCusId());
		
		model.addAttribute("cardList", cardList);
		
		return "/card";
	}
	
	/**
	 * 删除银行卡
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delcard")
	@ResponseBody
	public boolean delCard(@RequestParam("ids[]")String[] ids) {

		int num=0;
		if(ids!=null) {
			
			num=bankAccountService.deleteCard(ids);
		}
		
		if(num!=0) {
			 return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * 增加银行卡
	 */
	@RequestMapping("/addcardll")
	@ResponseBody
	public boolean addCard(BankAccount bankaccount){
		int num=bankAccountService.insertCard(bankaccount);
		System.out.println("lalala"+num);
		if(num!=0) {
			return true;

		}else {
			return false;

		}

	}

}
