/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.model
 * Content.java
 * 创建人:luochenxi 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.web.goods;

import static com.tz.util.TzConstant.SESSION_USER_ID;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.Goods;
import com.tz.bean.GoodsPrice;
import com.tz.bean.PriceElements;
import com.tz.bean.TzParams;
import com.tz.service.goods.IGoodsService;

/**
 * 商品管理web GoodsController 创建人:落落 时间：2016年03月15日 17:15:31
 * 
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/goods")
public class GoodsController {

	@Autowired
	private IGoodsService goodsService;

	/* 列表查询 */
	@RequestMapping("/list")
	public String list(TzParams params) {
		return "goods/list";
	}

	/**
	 * 商品详情
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/detail/{id}")
	public ModelAndView details(HttpServletRequest request,
			@PathVariable("id") String id) {
		Goods goods = new Goods();
		goods.setId(id);
		List<GoodsPrice> gpList = goodsService.getGoodsPrice(goods);
		List<PriceElements> sizeList = goodsService.getSizeList();
		List<PriceElements> colorList = goodsService.getColorList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("goods/goodsPrice");
		mav.addObject("prices", gpList);
		mav.addObject("sizeList", sizeList);
		mav.addObject("colorList", colorList);
		return mav;
	}

	/* 模板页面 */
	@RequestMapping("/template")
	public ModelAndView template(HttpServletRequest request, TzParams params) {
		ModelAndView modelAndView = new ModelAndView();
		String userId = request.getSession().getAttribute(SESSION_USER_ID)
				.toString();
		params.setShopId(userId.toString());
		List<Goods> goodss = goodsService.findGoodss(params);
		int count = goodsService.count(params);
		modelAndView.setViewName("goods/template");
		modelAndView.addObject("datas", goodss);
		modelAndView.addObject("itemCount", count);
		return modelAndView;
	}

	@RequestMapping("/addGoodPrice")
	public void addGoodPrice(HttpServletRequest request,HttpServletResponse response){
		String referer = request.getHeader("referer");
		String[] refererStrings = referer.split("/");
		String goodsId = refererStrings[refererStrings.length-1];
		String stock = request.getParameter("stock").toString();//库存
		String price = request.getParameter("price").toString();//价格
		String size = request.getParameter("size").toString();//尺寸
		String color = request.getParameter("color").toString();//颜色
		GoodsPrice gp = new GoodsPrice();
		gp.setGoodsId(goodsId);
		gp.setStock(Integer.parseInt(stock));
		gp.setPrice(new BigDecimal(price));
		gp.setElement1(Integer.parseInt(size));
		gp.setElement2(Integer.parseInt(color));
		int effectCount = goodsService.addGoodPrice(gp);
		System.out.println(effectCount);
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		if(effectCount<0){
			pw.write("1");
		}else{
			pw.write("0");
		}
	}
	
	@RequestMapping("/updateGoodPrice")
	public void updateGoodPrice(HttpServletRequest request,HttpServletResponse response){
		String stock = request.getParameter("stock").toString();//库存
		String price = request.getParameter("price").toString();//价格
		String size = request.getParameter("size").toString();//尺寸
		String color = request.getParameter("color").toString();//颜色
		String id = request.getParameter("id").toString();
		
		GoodsPrice gp = new GoodsPrice();
		gp.setId(Integer.parseInt(id));
		gp.setStock(Integer.parseInt(stock));
		gp.setPrice(new BigDecimal(price));
		gp.setElement1(Integer.parseInt(size));
		gp.setElement2(Integer.parseInt(color));
		
		int effectCount = goodsService.updateGoodPrice(gp);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		if(effectCount<0){
			pw.write("1");
		}else{
			pw.write("0");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Goods goods){
		goodsService.update(goods);
		return "success";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(TzParams params){
		goodsService.delete(params);
		return "success";
	}
	
	/* 商品添加 */
	@RequestMapping("/addlist")
	public String addList(TzParams params) {
		return "goods/addlist";
	}

	@ResponseBody
	@RequestMapping(value = "/saveGoods")
	public String saveGoods(HttpServletRequest request) {
		try {
			String name = request.getParameter("name");
			String startAddress = request.getParameter("startAddress");
			String endAddress = request.getParameter("endAddress");
			String level = request.getParameter("level");
			String style = request.getParameter("style");
			String oldprice = request.getParameter("oldprice");
			String newprice = request.getParameter("newprice");
			String runprice = request.getParameter("runprice");
			String unit = request.getParameter("unit");
			String address = request.getParameter("address");
			String telephone = request.getParameter("telephone");
			String status = request.getParameter("status");
			String descript = request.getParameter("descript");
			String carousel1 = request.getParameter("carousel1");
			String carousel2 = request.getParameter("carousel2");
			String carousel3 = request.getParameter("carousel3");
			String cover = request.getParameter("cover");
			Goods goods = new Goods();
			String idStr = UUID.randomUUID().toString();
			String userId = request.getSession().getAttribute(SESSION_USER_ID)
					.toString();
			goods.setId(idStr);
			goods.setStartPosition(startAddress);
			goods.setEndPosition(endAddress);
			goods.setShopkeeperId(userId);
			goods.setTitle(name);
			goods.setOriginalPrice(Double.parseDouble(oldprice));
			goods.setDiscountedPrice(Double.parseDouble(newprice));
			goods.setExpressPrice(Double.parseDouble(runprice));
			goods.setStyle(Integer.parseInt(style));
			goods.setUnit(unit);
			goods.setState(Integer.parseInt(status));
			goods.setGoodsType(Integer.parseInt(level));
			goods.setCreateTime(new Date());
			goods.setPhotographyType(descript);
			goods.setCarousel1(carousel1);
			goods.setCarousel2(carousel2);
			goods.setCarousel3(carousel3);
			goods.setCover(cover);
			goods.setEditTime(new Date());
			goods.setIsRecommend(0);
			goods.setMaxPrice(0);
			goods.setMinPrice(0);
			int count = goodsService.save(goods);
			if (count < 0) {
				return "success";
			} else {
				return "fail";
			}
		} catch (Exception e) {
			return "error";		
		}
		
		// private String cover;// 封面图
		// private double maxPrice;// 最高价
		// private double minPrice;// 最低价
		// private String carousel1;// 轮播图1
		// private String carousel2;// 轮播图2
		// private String carousel3;// 轮播图3
	}
}
