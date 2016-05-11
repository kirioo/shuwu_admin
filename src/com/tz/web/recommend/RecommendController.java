/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.web.recommend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.AdminUser;
import com.tz.bean.Recommend;
import com.tz.bean.TzParams;
import com.tz.service.recommend.IRecommendService;

/**
 * 推荐管理web
 * RecommendController
 * 创建人:Kirio
 * 时间：2016年04月29日 10:57:23
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/recommend")
public class RecommendController {
	
	@Autowired
	private IRecommendService recommendService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "recommend/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<Recommend> recommends = recommendService.findRecommends(params);
		int count = recommendService.count(params);
		modelAndView.setViewName("recommend/template");
		modelAndView.addObject("datas",recommends);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Recommend recommend){
		recommendService.update(recommend);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(TzParams params){
		recommendService.delete(params);
		return "success";
	}

}
