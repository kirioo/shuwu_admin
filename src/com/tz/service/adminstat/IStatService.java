
package com.tz.service.adminstat;

import java.util.HashMap;
import java.util.List;

import com.tz.bean.TzParams;


public interface IStatService {

	
	public List<HashMap<String, Object>> groupContent(TzParams params);

}
