/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.web.order
 * OrderController.java
 * 创建人:落落 
 * 时间：2016年03月17日 15:52:15
 * 2016Nq公司-版权所有
 */
package com.tz.web.order;

import static com.tz.util.TzConstant.SESSION_USER_ID;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.Order;
import com.tz.bean.TzParams;
import com.tz.service.order.IOrderService;

/**
 * 订单管理web
 * OrderController
 * 创建人:落落
 * 时间：2016年03月17日 15:52:15
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "order/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(HttpServletRequest request,TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		String userId =(String)request.getSession().getAttribute(SESSION_USER_ID);
		params.setShopId(userId);
		List<Order> orders = orderService.findOrders(params);
		int count = orderService.count(params);
		modelAndView.setViewName("order/template");
		modelAndView.addObject("datas",orders);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/status",method=RequestMethod.POST)
	public String status(HttpServletRequest request,Order order){
		String sid = request.getParameter("id");
		String sel = request.getParameter("sel");
		order.setState(Integer.parseInt(sel));
		order.setId(sid);
		orderService.update(order);
		return "success";
	}
}
