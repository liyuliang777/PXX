/**
 * 
 */
package org.hut.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hut.dao.OrderMapper;
import org.hut.pojo.Customer;
import org.hut.pojo.OrderTable;
import org.hut.service.orderService;
import org.hut.util.PageBean;
import org.hut.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 *
 */
@Service
public class OrderServiceImpl implements orderService {
	@Autowired
	private OrderMapper or;
	@Override
	public PageBean<Query, OrderTable> findAllOrderByCondtion(PageBean<Query, OrderTable> pb, String page,Customer customer,Query query) {
	//public List<OrderTable> findAllOrderByCondtion(PageBean<Query, OrderTable> pb, String page,Customer customer,Query query) {
		if(page ==null) {
			pb.setCurrentPage(1);
		}else {
			pb.setCurrentPage(new Integer(page));
		}
		// query.setQcustomerId(customer.getCusId());	
		 pb.setQuery(query);
		 pb.setCountPageSize(findOrderCount(pb.getQuery()));
		 List<OrderTable> list= or.selectOrderTableByPageBean(pb);
	      pb.setList(list); 
	      return pb; 
	}	
	@Override
	public int findOrderCount(Query query) {
		return or.selectOrderCount(query);
	}
	@Override
	public OrderTable findOrderById(Integer id) {
		return or.selectOrderById(id);
	}
	@Override
	public int updateOrderTableById(OrderTable order) {
		order.setOrdType("已取消");
		return or.upDataOrderTableById(order);
	}
	@Override
	public int addOrderTable(OrderTable order) {
		//身份状态
		order.setOrdSfCheckType("审核中");
		//财务状态
		order.setOrdCwCheckType("审核中");
		//订单状态
		order.setOrdType("预约中");
		//权益凭证编号的产生
		int num=(int) ((Math.random()*9000)+1000);
		order.setOrdQypzId(num);
		//合同编号的产生
		int orderConId =(int) ((Math.random()*90000000)+10000000);
		order.setOrdContractId(orderConId);
		//订单编号的产生
		int ordernum=(int) ((Math.random()*900000)+100000);
		order.setOrdNum(Integer.toString(ordernum));
		return or.addOrderTable(order);
	}
   
}
