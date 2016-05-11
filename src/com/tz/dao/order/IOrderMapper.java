/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.dao.order
 * IOrderMapper.java
 * 创建人:落落 
 * 时间：2016年03月17日 15:52:15
 * 2016Nq公司-版权所有
 */
package com.tz.dao.order;

import java.util.List;

import com.tz.bean.Order;
import com.tz.bean.TzParams;

/**
 * 订单管理Mapper
 * IOrderMapper
 * 创建人:落落 
 * 时间：2016年03月17日 15:52:15
 * @version 1.0.0
 * 
 */
public interface IOrderMapper {

	/**
	 * 
	 * com.tz.dao.order 
	 * 方法名：findOrders
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 15:52:15
	 * @param params
	 * @return 
	 * 返回类型：List<Order>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Order> findOrders(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.order 
	 * 方法名：count
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 15:52:15
	 * @param id
	 * @return 
	 * 返回类型：List<Order>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.dao.order 
	 * 方法名：getOrder
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 15:52:15
	 * @param id
	 * @return 
	 * 返回类型：List<Order>
	 * @exception 
	 * @since  1.0.0
	 */
	public Order get(Order order);
	
	/**
	 * 保存订单管理
	 * com.tz.dao.order 
	 * 方法名：save
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 15:52:15
	 * @param order
	 * @return 
	 * 返回类型：Order
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Order order);
	
	/**
	 * 更新订单管理
	 * com.tz.dao.order 
	 * 方法名：update
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 15:52:15
	 * @param order
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Order order);
	
	/**
	 * 删除订单管理
	 * com.tz.dao.order 
	 * 方法名：delete
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 15:52:15 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
			
}
