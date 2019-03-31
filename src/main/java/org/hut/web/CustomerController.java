package org.hut.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hut.pojo.Customer;
import org.hut.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 客户控制
 * @author Administrator
 *
 */
@Controller
public class CustomerController {
	
	@Resource
	private CustomerService customerService;
	
	@RequestMapping("/getcus")
	public String  getCustomerById(Model model,HttpSession session,@RequestParam(value="status") Integer status) {
		Customer cus=(Customer)session.getAttribute("customer");
		String back="";
		Customer customer=customerService.findCustomer(cus.getId());
		model.addAttribute("cus",customer);
		if(status!=null) {
			if(status==1) {
				back="updateProfile";
			}else {
				back="myProfile";
			}
		}
		return back;
	}
	
	
	@RequestMapping("/updatepwd")
	@ResponseBody
	public boolean updatePwd(Customer customer){
		 return customerService.modifyCustomerPassword(customer);
	}
	
	
	@RequestMapping("/updatecustomer")
	@ResponseBody
	public Map<String,Object> updateCustomer(Customer customer) {
		Map<String,Object> map=new HashMap<>();
		boolean flag=customerService.modifyCustomer(customer);
		if(flag) {
			map.put("flag",true);
		}else {
			map.put("flag",false);
		}
		return map;
}
	/**
	 * 客户登录
	 * @param customer
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/customerLogin")
	public Customer customerLogin(String telphone,String password,Customer customer,HttpSession session,HttpServletRequest req) {
		String IP = req.getRemoteAddr();//获取ip
		customer.setCusMobilePhone(telphone);
		customer.setCusPwd(password);
		customer.setCusBeforeLoginIp(IP);
		customer = customerService.findCustomer(customer);
		session.setAttribute("customer", customer);
		return customer;
	}
	
	/**
	 * 验证手机号码是否已经被注册
	 * @param cusMobilePhone
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/checkCusMobilePhone")
	public boolean checkCusMobilePhone(String cusMobilePhone) {
		cusMobilePhone = customerService.findCusMobilePhone(cusMobilePhone);
		if(cusMobilePhone == null) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 发送短信验证码
	 * @param cusMobilePhone
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/phoneCode")
	public String phoneCode(String cusMobilePhone) {
		return customerService.sendPhoneCode(cusMobilePhone);
	}
	/**
	 * 客户注册
	 * @param customer
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/customerRegister")
	public Customer customerRegister(Customer customer,HttpSession session,HttpServletRequest req) {
		String IP = req.getRemoteAddr();
		customer.setCusBeforeLoginIp(IP);//获取当前IP
		customer = customerService.saveCustomer(customer);
		if(customer != null) {
			session.setAttribute("customer", customer);
		}
		return customer;
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping("/removeCustomer")
	public String removeCustomer(HttpSession session) {
		session.removeAttribute("customer");
		return "index";
	}
	
	/**
	 * 获取当前登录用户
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/sessionCustomer")
	public Customer findCustomer(HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		if(customer == null) {
			return new Customer();
		}
		return customer;
	}
	
	/**
	 * 个人主页
	 * @return
	 */
	@RequestMapping("/customerIndex")
	public String customerIndex() {
		return "userIndex";
	}
	
	/**
	 * id查询客户信息
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping("/findCustomer")
	public String findCustomer(Map<String, Customer> map,HttpSession session) {
		return "verified";
	}
	
	/**
	 * 用户实名认证
	 * @param session
	 * @param cusName
	 * @param cusCardId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/verifiedCustomer")
	public boolean verifiedCustomer(HttpSession session,String cusName,String cusCardId) {
		Integer id = ((Customer) session.getAttribute("customer")).getId();
		try {
			boolean flag = customerService.verifiedCustomer(id,cusName,cusCardId);
			Customer customer = customerService.findCustomer(id);
			session.setAttribute("customer", customer);
			return flag;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 完善信息
	 * @param customer
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/modifyCustomer")
	public boolean modifyCustomer(Customer customer,HttpSession session) {
		Integer id = ((Customer)session.getAttribute("customer")).getId();
		customer.setId(id);
		return customerService.modifyCustomer(customer);
	}
}
