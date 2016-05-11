/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.model
 * Content.java
 * 创建人:luochenxi 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.goods.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.Goods;
import com.tz.bean.GoodsPrice;
import com.tz.bean.PriceElements;
import com.tz.bean.TzParams;
import com.tz.dao.goods.IGoodsMapper;
import com.tz.service.goods.IGoodsService;
import com.tz.util.TmStringUtils;

/**
 * 商品管理serviceImpl IGoodsService 创建人:落落 时间：2016年03月15日 17:15:31
 * 
 * @version 1.0.0
 * 
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

	@Autowired
	private IGoodsMapper goodsMapper;

	@Override
	public List<Goods> findGoodss(TzParams params) {
		if (TmStringUtils.isEmpty(params.getOrder()))
			params.setOrder("create_time desc");
		return goodsMapper.findGoodss(params);
	}

	@Override
	public int count(TzParams params) {
		return goodsMapper.count(params);
	}

	@Override
	public Goods get(Integer id) {
		return goodsMapper.get(id);
	}

	@Override
	public int save(Goods goods) {
		return goodsMapper.save(goods);
	}

	@Override
	public int update(Goods goods) {
		return goodsMapper.update(goods);
	}

	@Override
	public int delete(TzParams params) {
		return goodsMapper.delete(params);
	}

	/**
	 * 根据商品ID获取商品价格列表
	 */
	@Override
	public List<GoodsPrice> getGoodsPrice(Goods goods) {
		// TODO Auto-generated method stub
		return goodsMapper.getGoodsPrice(goods);
	}

	/**
	 * 获取商品尺寸列表
	 */
	@Override
	public List<PriceElements> getSizeList() {
		// TODO Auto-generated method stub
		return goodsMapper.getSizeList();
	}

	/**
	 * 获取商品颜色列表
	 */
	@Override
	public List<PriceElements> getColorList() {
		// TODO Auto-generated method stub
		return goodsMapper.getColorList();
	}

	/**
	 * 更新商品价格
	 */
	@Override
	public int updateGoodPrice(GoodsPrice gp) {
		// TODO Auto-generated method stub
		return goodsMapper.updateGoodPrice(gp);
	}

	/**
	 * 添加商品价格
	 */
	@Override
	public int addGoodPrice(GoodsPrice gp) {
		// TODO Auto-generated method stub
		return goodsMapper.addGoodPrice(gp);
	}
	
	
}
