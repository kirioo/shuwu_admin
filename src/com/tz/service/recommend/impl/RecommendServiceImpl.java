/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.recommend.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.Recommend;
import com.tz.bean.TzParams;
import com.tz.dao.recommend.IRecommendMapper;
import com.tz.service.recommend.IRecommendService;
import com.tz.util.TmStringUtils;

/**
 * 推荐管理serviceImpl
 * IRecommendService
 * 创建人:Kirio 
 * 时间：2016年04月29日 10:57:23
 * @version 1.0.0
 * 
 */
@Service
public class RecommendServiceImpl implements IRecommendService{

	@Autowired
	private IRecommendMapper recommendMapper;
	
	@Override
	public List<Recommend> findRecommends(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("createTime desc");
		return recommendMapper.findRecommends(params);
	}
	
	@Override
	public int count(TzParams params){
		return recommendMapper.count(params);
	}

	@Override
	public Recommend get(Integer id) {
		return recommendMapper.get(id);
	}

	@Override
	public int save(Recommend recommend) {
		return recommendMapper.save(recommend);
	}

	@Override
	public int update(Recommend recommend) {
		return recommendMapper.update(recommend);
	}

	@Override
	public int delete(TzParams params) {
		return recommendMapper.delete(params);
	}
}
