/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.web.vip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.VIP;
import com.tz.bean.TzParams;
import com.tz.service.vip.IVIPService;

/**
 * 会员管理web
 * VIPController
 * 创建人:Kirio
 * 时间：2016年05月05日 10:40:44
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/vip")
public class VIPController {
	
	@Autowired
	private IVIPService vipService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "vip/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<VIP> vips = vipService.findVIPs(params);
		int count = vipService.count(params);
		modelAndView.setViewName("vip/template");
		modelAndView.addObject("datas",vips);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	/*更改状态*/
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(VIP vip){
		vipService.update(vip);
		return "success";
	}
	
	/*删除*/
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(TzParams params){
		vipService.delete(params);
		return "success";
	}
}
