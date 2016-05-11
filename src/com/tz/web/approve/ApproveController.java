/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.web.approve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.Approve;
import com.tz.bean.TzParams;
import com.tz.service.approve.IApproveService;

/**
 * 认证管理web
 * ApproveController
 * 创建人:Kirio
 * 时间：2016年05月04日 11:42:26
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/approve")
public class ApproveController {
	
	@Autowired
	private IApproveService approveService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "approve/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<Approve> approves = approveService.findApproves(params);
		int count = approveService.count(params);
		modelAndView.setViewName("approve/template");
		modelAndView.addObject("datas",approves);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	/*更改状态*/
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Approve approve){
		approveService.update(approve);
		return "success";
	}
	
	/*删除*/
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(TzParams params){
		approveService.delete(params);
		return "success";
	}
}
