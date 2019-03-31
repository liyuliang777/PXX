/**
 * 
 */
package org.hut.service;

import java.util.List;

import org.hut.pojo.Customer;
import org.hut.pojo.OrderTable;
import org.hut.util.PageBean;
import org.hut.util.Query;

/**
 * @author Administrator
 *
 */
public interface orderService {
	/**
	 * 分页展现订单信息
	 * @param 
	 */
	public PageBean<Query, OrderTable> findAllOrderByCondtion(PageBean<Query, OrderTable> pb, String page,Customer customer,Query query);
//	public List<OrderTable> findAllOrderByCondtion(PageBean<Query, OrderTable> pb, String page,Customer customer,Query query);
	
	/**
	 * 查询订单总记录数
	 * @param query 查询条件
	 */
	public int findOrderCount(Query query);
	
	/**
	 * 通过id查询订单信息
	 * @param id 订单id
	 */
	public OrderTable findOrderById(Integer id);
	/**
	 * 通过id修改订单状态
	 * @param id
	 * @return
	 */
	public int updateOrderTableById(OrderTable order);
	/**
	 * 根据产品产生订单
	 * @param order
	 * @return
	 */
	public int addOrderTable (OrderTable order);
}
