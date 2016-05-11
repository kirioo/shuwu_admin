/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.content
 * IContentService.java
 * 创建人:xuchengfei 
 * 时间：2015年11月28日-下午11:05:21 
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.Content;
import com.tz.bean.TzParams;
import com.tz.dao.content.IContentMapper;
import com.tz.service.content.IContentService;
import com.tz.util.TmStringUtils;

/**
 * 
 * IContentService
 * 创建人:xuchengfei 
 * 时间：2015年11月28日-下午11:05:21 
 * @version 1.0.0
 * 
 */
@Service
public class ContentServiceImpl implements IContentService{

	@Autowired
	private IContentMapper contentMapper;
	
	@Override
	public List<Content> findContents(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return contentMapper.findContents(params);
	}

	@Override
	public Content getContent(Integer id) {
		return contentMapper.get(id);
	}

	@Override
	public int save(Content content) {
		return contentMapper.save(content);
	}

	@Override
	public int update(Content content) {
		return contentMapper.update(content);
	}

	@Override
	public int delete(TzParams params) {
		return contentMapper.delete(params);
	}

	@Override
	public int count(TzParams params) {
		return contentMapper.count(params);
	}
}
