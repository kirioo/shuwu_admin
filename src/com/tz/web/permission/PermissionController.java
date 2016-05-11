/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.web.permission
 * PermissionController.java
 * 创建人:luochenxi
 * 时间：2015年12月14日 22:25:50
 * 2015潭州教育公司-版权所有
 */
package com.tz.web.permission;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tz.bean.TzParams;
import com.tz.service.permission.IPermissionService;

/**
 * 权限管理web
 * PermissionController
 * 创建人:luochenxi
 * 时间：2015年12月14日 22:25:50
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/permission")
public class PermissionController {
	
	@Autowired
	private IPermissionService permissionService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "permission/list";
	}
	
	
	/*列表查询*/
	@ResponseBody
	@RequestMapping("/root")
	public HashMap<String, Object> root(TzParams params){
		return permissionService.findPermissions(params);
	}
}
