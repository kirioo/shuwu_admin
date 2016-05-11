/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.web.feedback;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.Event;
import com.tz.bean.FeedBack;
import com.tz.bean.TzParams;
import com.tz.service.feedback.IFeedBackService;

/**
 * 意见反馈web
 * FeedBackController
 * 创建人:Kirio
 * 时间：2016年05月04日 10:24:21
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/feedback")
public class FeedBackController {
	
	@Autowired
	private IFeedBackService feedbackService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "feedback/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		params.setIsDelete(0);
		List<FeedBack> feedbacks = feedbackService.findFeedBacks(params);
		int count = feedbackService.count(params);
		modelAndView.setViewName("feedback/template");
		modelAndView.addObject("datas",feedbacks);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(FeedBack feedBack){
		feedbackService.update(feedBack);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(TzParams params){
		feedbackService.delete(params);
		return "success";
	}
}
