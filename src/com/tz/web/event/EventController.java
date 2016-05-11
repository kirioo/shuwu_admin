/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.web.event;

import static com.tz.util.TzConstant.SESSION_USER_ID;
import static com.tz.util.TzConstant.SESSION_USER_USERNAME;

import java.util.HashMap;
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
import com.tz.bean.Event;
import com.tz.bean.TzParams;
import com.tz.service.event.IEventService;

/**
 * 活动管理web
 * EventController
 * 创建人:Kirio
 * 时间：2016年04月29日 16:26:10
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/event")
public class EventController {
	
	@Autowired
	private IEventService eventService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "event/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		params.setIsDelete(0);
		List<Event> events = eventService.findEvents(params);
		int count = eventService.count(params);
		modelAndView.setViewName("event/template");
		modelAndView.addObject("datas",events);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Event event){
		eventService.update(event);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(TzParams params){
		eventService.delete(params);
		return "success";
	}
	
	/*参加活动者详情*/
//	@RequestMapping(value="/child",method=RequestMethod.POST)
//	public ModelAndView child(TzParams params){
//		ModelAndView modelAndView = new ModelAndView();
//		List<Event> data = eventService.findEventUsers(params);
//		modelAndView.setViewName("event/template");
//		modelAndView.addObject("data",data);
//		return modelAndView;
//	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/child")
	public List<Event> child(TzParams params){
		List<Event> data = eventService.findEventUsers(params);
		return data;
	}
	
	/*活动添加*/
	@RequestMapping("/addlist")
	public String addList(TzParams params){
		return "event/addlist";
	}
	
	/*活动保存*/
	@ResponseBody
	@RequestMapping(value="/sava",method=RequestMethod.POST)
	public String save(HttpServletRequest request,Event event){
		String username = request.getParameter("name"); 
		String description = request.getParameter("description");
		String cover = request.getParameter("cover");
		String idStr = UUID.randomUUID().toString();
		String userId = (String) request.getSession().getAttribute(SESSION_USER_ID);
		String autor = (String) request.getSession().getAttribute(SESSION_USER_USERNAME);
		event.setId(idStr);
		event.setAutor(autor);
		event.setAutorId(Integer.parseInt(userId));
		event.setTitle(username);
		event.setContent(description);
		event.setImg(cover);
		event.setIsDelete(0);
		event.setStatus(1);
		int count = eventService.save(event);
		if(count<0){
			return "success";
		}else {
			return "fail";
		}
	}
}
