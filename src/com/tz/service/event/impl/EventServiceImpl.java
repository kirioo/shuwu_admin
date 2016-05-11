/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.event.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.Event;
import com.tz.bean.TzParams;
import com.tz.dao.event.IEventMapper;
import com.tz.service.event.IEventService;
import com.tz.util.TmStringUtils;

/**
 * 活动管理serviceImpl
 * IEventService
 * 创建人:Kirio 
 * 时间：2016年04月29日 16:26:10
 * @version 1.0.0
 * 
 */
@Service
public class EventServiceImpl implements IEventService{

	@Autowired
	private IEventMapper eventMapper;
	
	@Override
	public List<Event> findEvents(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("createTime desc");
		return eventMapper.findEvents(params);
	}
	
	@Override
	public int count(TzParams params){
		return eventMapper.count(params);
	}

	@Override
	public Event get(Integer id) {
		return eventMapper.get(id);
	}

	@Override
	public int save(Event event) {
		return eventMapper.save(event);
	}

	@Override
	public int update(Event event) {
		return eventMapper.update(event);
	}

	@Override
	public int delete(TzParams params) {
		return eventMapper.delete(params);
	}
	
	@Override
	public List<Event> findEventUsers(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("createTime desc");
		return eventMapper.findEventUsers(params);
	}
}
