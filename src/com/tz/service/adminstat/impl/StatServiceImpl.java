
package com.tz.service.adminstat.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.TzParams;
import com.tz.dao.adminstat.IStatMapper;
import com.tz.service.adminstat.IStatService;


@Service
public class StatServiceImpl implements IStatService{

	@Autowired
	private IStatMapper statMapper;

	@Override
	public List<HashMap<String, Object>> groupContent(TzParams params) {
		return statMapper.groupContent(params);
	}
	
	
}
