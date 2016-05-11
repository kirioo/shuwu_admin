/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.web.content
 * ContentController.java
 * 创建人:luochenxi
 * 时间：2015年11月28日-下午11:10:17 
 * 2015潭州教育公司-版权所有
 */
package com.tz.web.content;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.Content;
import com.tz.bean.TzParams;
import com.tz.service.content.IContentService;

/**
 * 
 * ContentController
 * 创建人:luochenxi
 * 时间：2015年11月28日-下午11:10:17 
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/content")
public class ContentController {
	
	@Autowired
	private IContentService contentService;
	
	@RequestMapping("/list")
	public String list(TzParams params){
		return "content/list";
	}
	
	
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		params.setIsDelete(1);
		List<Content> contents = contentService.findContents(params);
		int count = contentService.count(params);
		modelAndView.setViewName("content/template");
		modelAndView.addObject("datas",contents);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Content content){
		contentService.update(content);
		return "success";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest request,TzParams params){
		contentService.delete(params);
		return "success";
	}
}
