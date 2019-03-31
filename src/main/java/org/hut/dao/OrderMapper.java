/**
 * 
 */
package org.hut.dao;

import java.util.List;

import org.hut.pojo.OrderTable;
import org.hut.util.PageBean;
import org.hut.util.Query;

/**
 * @author Administrator
 *
 */
public interface OrderMapper {
	/**
	 * 分页展现订单
	 */
	public  List<OrderTable> selectOrderTableByPageBean(PageBean<Query, OrderTable> pb);
	
	/**
	 * 查询订单总记录数
	 */
	public int selectOrderCount(Query query);
	/**
	 * 通过id查询订单详情
	 * @param id 订单id
	 */
	public OrderTable selectOrderById(Integer id);	
	/**
	 * @param order 订单
	 * 跟据id取消订单
	 */
	public int upDataOrderTableById(OrderTable order);
	/**
	 * 根据产品预约订单
	 * @param order
	 * @return
	 */
	public int addOrderTable(OrderTable order);
}
