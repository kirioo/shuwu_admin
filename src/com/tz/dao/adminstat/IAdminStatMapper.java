package com.tz.dao.adminstat;

import java.util.HashMap;
import java.util.List;

import com.tz.bean.AdminStat;
import com.tz.bean.TzParams;


public interface IAdminStatMapper {


	public List<AdminStat> findAdminStats(TzParams params);
	

	public int count(TzParams params);
	

	public AdminStat get(Integer id);

	public int save(AdminStat adminstat);
	

	public int update(AdminStat adminstat);
	

	public int delete(TzParams params);
	

	public List<HashMap<String,Object>> groupContents(TzParams params);
	

	public List<HashMap<String,Object>> groupUsers(TzParams params);
	
}
