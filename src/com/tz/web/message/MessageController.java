/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.web.message
 * MessageController.java
 * 创建人:落落 
 * 时间：2016年03月21日 11:18:21
 * 2016Nq公司-版权所有
 */
package com.tz.web.message;

import static com.tz.util.TzConstant.SESSION_USER_USERNAME;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.AdminUser;
import com.tz.bean.Event;
import com.tz.bean.Message;
import com.tz.bean.TzParams;
import com.tz.service.message.IMessageService;
import com.tz.service.role.IRoleService;
import com.tz.util.JPushPackage;

/**
 * 消息管理web
 * MessageController
 * 创建人:落落
 * 时间：2016年03月21日 11:18:21
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/message")
public class MessageController {
	
	@Autowired
	private IMessageService messageService;
	
	@Autowired
	private IRoleService roleService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "message/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<Message> messages = messageService.findMessages(params);
		int count = messageService.count(params);
		modelAndView.setViewName("message/template");
		modelAndView.addObject("datas",messages);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(HttpServletRequest request){	
		try {
			String text = request.getParameter("text");
			String userId = request.getParameter("userId");
			String StringDom = userId;
			String[] strArray = null;   
	        strArray = StringDom.split(","); //拆分字符为"," ,然后把结果交给数组strArray 
	        Map<String, String> message = new HashMap();
	        message.put("text", text);
	        for(int i=0;i<strArray.length;i++){
	        	JPushPackage.sendToIOS("您有一条新的消息！", message, strArray[i]);//这里需要 pushTake
	        }
	        return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}
	}	
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/user")
	public List<AdminUser> child(TzParams params){
		List<AdminUser> data = roleService.findFilterUsers(params);
		return data;
	}

}
