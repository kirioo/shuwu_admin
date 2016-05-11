/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.model
 * Content.java
 * 创建人:落落 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.shopfunds.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.ShopFunds;
import com.tz.bean.TzParams;
import com.tz.dao.shopfunds.IShopFundsMapper;
import com.tz.service.shopfunds.IShopFundsService;
import com.tz.util.TmStringUtils;

/**
 * 商家资金管理serviceImpl
 * IShopFundsService
 * 创建人:落落 
 * 时间：2016年04月01日 11:49:09
 * @version 1.0.0
 * 
 */
@Service
public class ShopFundsServiceImpl implements IShopFundsService{

	@Autowired
	private IShopFundsMapper shopfundsMapper;
	
	@Override
	public List<ShopFunds> findShopFundss(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return shopfundsMapper.findShopFundss(params);
	}
	
	@Override
	public int count(TzParams params){
		return shopfundsMapper.count(params);
	}

	@Override
	public ShopFunds get(Integer id) {
		return shopfundsMapper.get(id);
	}

	@Override
	public int save(ShopFunds shopfunds) {
		return shopfundsMapper.save(shopfunds);
	}

	@Override
	public int update(ShopFunds shopfunds) {
		return shopfundsMapper.update(shopfunds);
	}

	@Override
	public int delete(TzParams params) {
		return shopfundsMapper.delete(params);
	}
	
	@Override
	public List<ShopFunds> groupFunds(TzParams params){
		return shopfundsMapper.groupFunds(params);
	} 
	
	@Override
	public List<HashMap<String,Object>> groupWeeks(TzParams params){
		return shopfundsMapper.groupWeeks(params);
	}; 
	
	@Override
	public List<HashMap<String,Object>> groupMonths(TzParams params){
		return shopfundsMapper.groupMonths(params);
	}; 
	
}
