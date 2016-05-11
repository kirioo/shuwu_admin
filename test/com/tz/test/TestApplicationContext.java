/**
 * tzdesk系统平台
 * springmvc2
 * com.tz.test
 * TestApplicationContext.java
 * 创建人:luochenxi 
 * 时间：2015年11月18日-上午11:35:24 
 * 2015潭州教育公司-版权所有
 */
package com.tz.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tz.bean.AdminUser;
import com.tz.bean.Approve;
import com.tz.bean.Content;
import com.tz.bean.Event;
import com.tz.bean.Funds;
import com.tz.bean.Goods;
import com.tz.bean.TzParams;
import com.tz.dao.adminstat.IAdminStatMapper;
import com.tz.dao.goods.IGoodsMapper;
import com.tz.service.adminstat.IStatService;
import com.tz.service.approve.IApproveService;
import com.tz.service.content.IContentService;
import com.tz.service.event.IEventService;
import com.tz.service.goods.impl.GoodsServiceImpl;
import com.tz.service.job.JobService;
import com.tz.service.order.IOrderService;
import com.tz.service.role.IRoleService;
import com.tz.service.user.IUserService;
import com.tz.util.TmStringUtils;

/**
 * 
 * TestApplicationContext
 * 创建人:luochenxi
 * 时间：2015年11月18日-上午11:35:24 
 * @version 1.0.0
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestApplicationContext {
	
	@Autowired
	IUserService  userService;
	
	@Autowired
	private IContentService contentService;
	
	@Autowired
	private IStatService statService;
	
	@Autowired
	private IAdminStatMapper adminStatMapper;
	
	@Autowired
	private IGoodsMapper goodsMapper;
	
	@Autowired
	private GoodsServiceImpl goodsService;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IEventService eventService;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private IApproveService approveService;
	
	@Test
	public void handler() throws JSONException{
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
//		DruidDataSource dataSource = context.getBean(DruidDataSource.class);
//		System.out.println("============"+dataSource);
//		IUserMapper mapper = context.getBean(IUserMapper.class);
//		System.out.println(mapper);
		TzParams params = new TzParams();
		params.setAccount("965080907@qq.com");
		params.setPassword("4QrcOUm6Wau+VuBX8g+IPg==");
		AdminUser user = userService.getLogin(params);
		System.out.println("============="+user.getUsername());
	}
	
	@Test
	public void handler9() throws JSONException{
		Goods goods = new Goods();
		goods.setId("284524");
		goods.setCover("520");
		goods.setStartPosition("上海");
		goods.setEndPosition("西藏");
		goods.setShopkeeperId("5215");
		goods.setTitle("西藏1111之行");
		goods.setOriginalPrice(523.26);
		goods.setDiscountedPrice(6323.2);
		goods.setExpressPrice(10);
		goods.setStyle(1);
		goods.setUnit("件");
		goods.setState(2);
		goods.setGoodsType(3);
		goods.setIsRecommend(0);
		goods.setMaxPrice(256);
		goods.setMinPrice(5632);
		goods.setCreateTime(new Date());
		goods.setPhotographyType("soidjflkw");
		goods.setEditTime(new Date());
		goods.setCarousel1("5121");
		goods.setCarousel2("5121");
		goods.setCarousel3("5121");
		int count= goodsService.save(goods);
		System.out.println("============="+count);
		System.out.println(count<0?"成功":"失败");

	}

	@Test
	public void handler2() throws JSONException{
		TzParams params = new TzParams();
		List<Content> contents = contentService.findContents(params);
		for (Content content : contents) {
			System.out.println("=======>"+content.getTitle());
		}
	}
	
	@Test
	public void handler10() throws JSONException{
		TzParams params = new TzParams();
		
		params.setShopId("2");
		List<Goods> goodss = goodsService.findGoodss(params);
		for (Goods goods : goodss) {
			System.out.println("================"+goods.getTitle());
		}
	}
	
	
	@Test
	public void handler3() throws JSONException{
		List<AdminUser> adminUsers = new ArrayList<>();
		AdminUser adminUser = new AdminUser();
		//keke
		adminUser.setUsername("keke");
		adminUser.setPassword(TmStringUtils.md5Base64("keke_keke"));
		adminUsers.add(adminUser);
		
		//小明
		adminUser = new AdminUser();
		adminUser.setUsername("小明");
		adminUser.setPassword(TmStringUtils.md5Base64("keke"));
		adminUsers.add(adminUser);
		
		int count = userService.saveBatch(adminUsers);
//		int count = userService.batchUpdate(adminUsers);
		System.out.println("==============>"+count);
	}
	
	

	
	/**
	 * 一天的收入 
	 * @throws JSONException
	 */
	@Test
	public void handler8() throws JSONException{
		Date date = new Date();
		String dateFormat = "YYYY-MM-dd";
		DateFormat dateFormat2 = new SimpleDateFormat(dateFormat);//年月日
		String time=  dateFormat2.format(date);
		TzParams params = new TzParams();
		params.setDate("2016-04-06");
		List<Funds> datas = jobService.findDayInCome(params);
		for (Funds funds : datas) {
			System.out.println("========="+funds.getUserId()+"====="+funds.getIncome());
//			Double inCome = funds.getIncome();
//			String uid = funds.getUserId();
//			Funds funds1 = new Funds();
//			funds1.setUserId(uid);
//			funds1.setIncome(inCome);
//			int count = jobService.saveDayInCome(funds1);
//			System.out.println(count<0?"成功":"失败");
		}
	}
	
	
	/**
	 * 一天的支出
	 * @throws JSONException
	 * @throws ParseException 
	 */
	@Test
	public void handler91() throws JSONException, ParseException{

		
		Date dNow = new Date();   //当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(dNow);//把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
		dBefore = calendar.getTime();   //得到前一天的时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM"); //设置时间格式
		String defaultStartDate = sdf.format(dBefore);    //格式化前一天
		TzParams params = new TzParams();								
		params.setDate(defaultStartDate);
		List<Funds> datas = jobService.findDayPayOut(params);
		for (Funds funds : datas) {
			System.out.println("========="+funds.getUserId()+"====="+funds.getPayOut());
			Double payOut = funds.getPayOut();
			String uid = funds.getUserId();
			Funds funds2 = new Funds();
			funds2.setUserId(uid);
			funds2.setPayOut(payOut);
			int count = jobService.saveDayPayOut(funds2);
			System.out.println(count<0?"成功":"失败");
		}
	}
	
	/**
	 * 一周的收入 
	 * @throws JSONException
	 */
	@Test
	public void handler15() throws JSONException{
		TzParams params = new TzParams();
		params.setDate("2016-04-05");
		List<Funds> datas = jobService.findWeekInCome(params);
		for (Funds funds : datas) {
			System.out.println("========="+funds.getUserId()+"====="+funds.getIncome()+"====="+funds.getPayOut()+"====="+funds.getGl());
			Double inCome = funds.getIncome();
			Double payOut = funds.getPayOut();
			Double gl = funds.getGl();
			String uid = funds.getUserId();
			Funds funds1 = new Funds();
			funds1.setUserId(uid);
			funds1.setIncome(inCome);
			funds1.setPayOut(payOut);
			funds1.setGl(gl);
			int count = jobService.saveWeekInCome(funds1);
			System.out.println(count<0?"成功":"失败");
		}
		
	}
	
	
	@Test
	public void handler26() throws JSONException{
		TzParams params = new TzParams();
		List<Approve> approves = approveService.findApproves(params);
		for (Approve approve : approves) {
			System.out.println("============="+approve.getIdCard());
		}
	}
	
	
	
	
	/**
	 * 每月的收入 
	 * @throws JSONException
	 */
	@Test
	public void handler18() throws JSONException{
		Date dNow = new Date();   //当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(dNow);//把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
		dBefore = calendar.getTime();   //得到前一天的时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM"); //设置时间格式
		String defaultStartDate = sdf.format(dBefore);    //格式化前一天
		TzParams params = new TzParams();								
		params.setYearMonth(defaultStartDate);
		List<Funds> datas = jobService.findMonthInCome(params);
		for (Funds funds : datas) {
			System.out.println("========="+funds.getUserId()+"====="+funds.getIncome()+"====="+funds.getPayOut()+"====="+funds.getGl());
//			Double inCome = funds.getIncome();
//			Double payOut = funds.getPayOut();
//			Double gl = funds.getGl();
//			String uid = funds.getUserId();
//			Funds funds1 = new Funds();
//			funds1.setUserId(uid);
//			funds1.setIncome(inCome);
//			funds1.setPayOut(payOut);
//			funds1.setGl(gl);
//			int count = jobService.saveMonthInCome(funds1);
//			System.out.println(count<0?"成功":"失败");
		}
	}
	
	@Test
	public void handler27() throws JSONException{
		TzParams params = new TzParams();
		params.setId("3");
		List<Event> events = eventService.findEventUsers(params);
		for (Event event : events) {
			System.out.println(event.getCreateTime()+"=================="+event.getUserName()+"============="+event.getId()+"===="+event.getAge()+"==="+event.getMale());
		}
	}
	
	@Test
	public void handler28() throws JSONException{
		TzParams params = new TzParams();
		params.setIsDelete(1);
		params.setPageSize(30);
		List<AdminUser> adminUsers = roleService.findFilterUsers(params);
		for (AdminUser adminUser : adminUsers) {		
			System.out.println("========="+adminUser.getId()+"======"+adminUser.getUsername());
		}
	}
	
	@Test
	public void handler29() throws JSONException{
		TzParams params = new TzParams();
		params.setRoleId(1);
		List<HashMap<String, Object>> adminUsers = roleService.findFilterAdminUsers(params);
		System.out.println(adminUsers);
		for (int i = 0; i < adminUsers.size(); i++) {
		//	adminUsers[i].id;
			System.out.println("========666666666====="+adminUsers.get(i));
		}
	}
	
	
	

	
	
	
	
}
