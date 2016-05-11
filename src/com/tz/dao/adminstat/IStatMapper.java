
package com.tz.dao.adminstat;

import java.util.HashMap;
import java.util.List;

import com.tz.bean.TzParams;


public interface IStatMapper {

	
	public List<HashMap<String, Object>> groupContent(TzParams params);

}
