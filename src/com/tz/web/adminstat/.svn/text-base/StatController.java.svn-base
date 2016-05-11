/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.web.adminstat
 * AdminStatController.java
 * 创建人:柯柯
 * 时间：2015年12月05日 00:07:45
 * 2015潭州教育公司-版权所有
 */
package com.tz.web.adminstat;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tz.bean.TzParams;
import com.tz.service.adminstat.IStatService;

/**
 * 日记管理web
 * AdminStatController
 * 创建人:柯柯
 * 时间：2015年12月05日 00:07:45
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/stat")
public class StatController {
	
	@Autowired
	private IStatService statService;
	
	/*列表查询*/
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public List<HashMap<String, Object>> list(TzParams params){
		List<HashMap<String, Object>> datas = statService.groupContent(params);
		return datas;
	}
	

	
}
