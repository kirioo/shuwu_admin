/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.service.order.impl
 * OrderServiceImpl.java
 * 创建人:落落 
 * 时间：2016年03月17日 15:52:15
 * 2016Nq公司-版权所有
 */
package com.tz.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.Order;
import com.tz.bean.TzParams;
import com.tz.dao.order.IOrderMapper;
import com.tz.service.order.IOrderService;
import com.tz.util.TmStringUtils;

/**
 * 订单管理serviceImpl
 * IOrderService
 * 创建人:落落 
 * 时间：2016年03月17日 15:52:15
 * @version 1.0.0
 * 
 */
@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	private IOrderMapper orderMapper;
	
	@Override
	public List<Order> findOrders(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return orderMapper.findOrders(params);
	}
	
	@Override
	public int count(TzParams params){
		return orderMapper.count(params);
	}

	@Override
	public Order get(Order order) {
		return orderMapper.get(order);
	}

	@Override
	public int save(Order order) {
		return orderMapper.save(order);
	}

	@Override
	public int update(Order order) {
		return orderMapper.update(order);
	}

	@Override
	public int delete(TzParams params) {
		return orderMapper.delete(params);
	}
}
