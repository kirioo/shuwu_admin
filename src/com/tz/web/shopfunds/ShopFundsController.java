/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.model
 * Content.java
 * 创建人:xuchengfei 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.web.shopfunds;

import static com.tz.util.TzConstant.SESSION_USER_ID;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.ShopFunds;
import com.tz.bean.TzParams;
import com.tz.service.shopfunds.IShopFundsService;

/**
 * 商家资金管理web
 * ShopFundsController
 * 创建人:落落
 * 时间：2016年04月01日 11:49:09
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/shopfunds")
public class ShopFundsController {
	
	@Autowired
	private IShopFundsService shopfundsService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "shopfunds/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<ShopFunds> shopfundss = shopfundsService.findShopFundss(params);
		int count = shopfundsService.count(params);
		modelAndView.setViewName("shopfunds/template");
		modelAndView.addObject("datas",shopfundss);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	/*列表查询*/
	@RequestMapping("/weeklist")
	public String shopList(TzParams params){
		return "shopfunds/weeklist";
	}
	
	/*列表查询*/
	@RequestMapping("/daylist")
	public String dayList(TzParams params){
		return "shopfunds/daylist";
	}
	
	/*列表查询*/
	@RequestMapping("/monthlist")
	public String monthList(TzParams params){
		return "shopfunds/monthlist";
	}
	
	@ResponseBody
	@RequestMapping(value="/groupFunds")
	public List<ShopFunds> groupFunds(HttpServletRequest request, TzParams params){
		String userId =(String)request.getSession().getAttribute(SESSION_USER_ID);
		params.setShopId(userId);
		List<ShopFunds> datas = shopfundsService.groupFunds(params);
		return datas;
	}
	
	@ResponseBody
	@RequestMapping(value="/groupWeeks")
	public List<HashMap<String, Object>> groupWeeks(HttpServletRequest request,TzParams params){
		String userId =(String)request.getSession().getAttribute(SESSION_USER_ID);
		params.setShopId(userId);
		List<HashMap<String, Object>> datas = shopfundsService.groupWeeks(params);
		return datas;
	}
	
	@ResponseBody
	@RequestMapping(value="/groupMonths")
	public List<HashMap<String, Object>> groupMonths(HttpServletRequest request,TzParams params){
		String userId =(String)request.getSession().getAttribute(SESSION_USER_ID);
		params.setShopId(userId);
		List<HashMap<String, Object>> datas = shopfundsService.groupMonths(params);
		return datas;
	}
}
