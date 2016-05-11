/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.web.adminuser
 * AdminUserController.java
 * 创建人:luochenxi
 * 时间：2015年12月14日 21:21:17
 * 
 */
package com.tz.web.adminuser;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.AdminUser;
import com.tz.bean.TzParams;
import com.tz.service.adminuser.IAdminUserService;
import com.tz.util.TmStringUtils;

/**
 * 日记管理web
 * AdminUserController
 * 创建人:luochenxi
 * 时间：2015年12月14日 21:21:17
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/adminuser")
public class AdminUserController {
	
	@Autowired
	private IAdminUserService adminuserService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "adminuser/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		params.setIsDelete(0);
		params.setOrder("create_time desc");
		List<AdminUser> adminusers = adminuserService.findAdminUsers(params);
		int count = adminuserService.count(params);
		modelAndView.setViewName("adminuser/template");
		modelAndView.addObject("datas",adminusers);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(AdminUser adminuser){
		adminuserService.update(adminuser);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(TzParams params){
		adminuserService.delete(params);
		return "success";
	}

	
	/*密码修改*/
	@RequestMapping("/addlist")
	public String addList(TzParams params){
		return "adminuser/addlist";
	}
	
	/*用户添加*/
	@RequestMapping("/adduser")
	public String addUser(TzParams params){
		return "adminuser/adduser";
	}
	
	/*用户保存*/
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(HttpServletRequest request,AdminUser adminUser){
		String username = request.getParameter("name"); 
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("telphone");
		String idStr = UUID.randomUUID().toString(); 
		adminUser.setId(idStr);
		adminUser.setUsername(username);
		adminUser.setPassword(TmStringUtils.md5Base64(password));
		adminUser.setForbiden(1);
		adminUser.setIsDelete(0);
		adminUser.setEmail(email);
		adminUser.setPhone(phone);
		int count = adminuserService.save(adminUser);
		if(count<0){
			return "success";
		}else {
			return "fail";
		}
	}
	
	/*修改密码*/
	@ResponseBody
	@RequestMapping(value="/updatePassword",method=RequestMethod.POST)
	public String updatePassword(HttpServletRequest request,AdminUser adminUser){
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		adminUser.setEmail(email);
		adminUser.setPassword(TmStringUtils.md5Base64(password));
		int count = adminuserService.updatePassword(adminUser);
		if(count<0){
			return "success";
		}else {
			return "fail";
		}
	}
}
