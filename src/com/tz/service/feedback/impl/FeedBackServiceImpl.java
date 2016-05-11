/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.feedback.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.FeedBack;
import com.tz.bean.TzParams;
import com.tz.dao.feedback.IFeedBackMapper;
import com.tz.service.feedback.IFeedBackService;
import com.tz.util.TmStringUtils;

/**
 * 意见反馈serviceImpl
 * IFeedBackService
 * 创建人:Kirio 
 * 时间：2016年05月04日 10:24:21
 * @version 1.0.0
 * 
 */
@Service
public class FeedBackServiceImpl implements IFeedBackService{

	@Autowired
	private IFeedBackMapper feedbackMapper;
	
	@Override
	public List<FeedBack> findFeedBacks(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("createTime desc");
		return feedbackMapper.findFeedBacks(params);
	}
	
	@Override
	public int count(TzParams params){
		return feedbackMapper.count(params);
	}

	@Override
	public FeedBack get(Integer id) {
		return feedbackMapper.get(id);
	}

	@Override
	public int save(FeedBack feedback) {
		return feedbackMapper.save(feedback);
	}

	@Override
	public int update(FeedBack feedback) {
		return feedbackMapper.update(feedback);
	}

	@Override
	public int delete(TzParams params) {
		return feedbackMapper.delete(params);
	}
}
