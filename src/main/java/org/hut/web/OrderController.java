/**
 * 
 */
package org.hut.web;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hut.pojo.Customer;
import org.hut.pojo.OrderTable;
import org.hut.service.orderService;
import org.hut.util.PageBean;
import org.hut.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author Administrator
 *
 */
@Controller
public class OrderController {
	@Autowired
	private orderService os;
	/*
	 *页面跳转
	 */
	@RequestMapping("/myProduct")
	public String order() {
		return "myProduct";
	}
	/**
	 * 分页展现订单信息
	 * @param pb
	 * @param page
	 * @param mav
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllOrder")
	public PageBean<Query, OrderTable> getAllOrder(PageBean<Query, OrderTable> pb,String page, HttpSession session,Query query) {
		Customer customer= (Customer) session.getAttribute("customer");
		query.setQcustomerId(customer.getCusId());
		PageBean<Query, OrderTable> pageBean= os.findAllOrderByCondtion(pb, page,customer,query);
		System.out.println(pageBean);
		return pageBean;
	}
	/**
	 * 通过id找到订单
	 * @param id
	 * @return
	 */
	@RequestMapping("/updateOrderById")
	public ModelAndView updateOrderById(OrderTable order) {
		ModelAndView mav=new ModelAndView();
		os.updateOrderTableById(order);
		mav.setViewName("/myProduct");
		return mav;
	}
	/**
	 * 通过id查询订单信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/getOrderTableById")
	public ModelAndView getOrderTableById(Integer id){
		ModelAndView mav=new ModelAndView();
		OrderTable orderTable= os.findOrderById(id);
		mav.addObject("orders", orderTable);
		mav.setViewName("orderdetail");
		return mav;
	}
	/**
	 * 预约产品生成订单
	 * @param order
	 * @return
	 */
	@RequestMapping("/addOrderTable")
	@ResponseBody
	public boolean addOrderTable(OrderTable order,HttpSession session){
		//ModelAndView mav=new ModelAndView();
		Customer customer= (Customer) session.getAttribute("customer");
		order.setOrdCustomerId(customer.getCusId());
		os.addOrderTable(order);
		return true;
	}
}
