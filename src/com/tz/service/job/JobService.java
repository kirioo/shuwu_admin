package com.tz.service.job;

import java.util.List;

import com.tz.bean.Funds;
import com.tz.bean.TzParams;

public interface JobService {
	
	/**
	 * 
	 *一天的收入 
	 * 方法名：findOrders
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 15:52:15
	 * @param params
	 * @return 
	 * 返回类型：List<Order>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Funds> findDayInCome(TzParams params);
	
	/**
	 * 一天的支出
	 * @param params
	 * @return
	 */
	public List<Funds> findDayPayOut(TzParams params);
	
	
	/**
	 * 
	 * com.tz.dao.Funds 
	 * 方法名：findFundss
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 15:52:15
	 * @param params
	 * @return 
	 * 返回类型：List<Funds>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Funds> findWeekInCome(TzParams params);
	
	public List<Funds> findWeekPayOut(TzParams params);
	
	
	/**
	 * 
	 * com.tz.dao.Funds 
	 * 方法名：findFundss
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 15:52:15
	 * @param params
	 * @return 
	 * 返回类型：List<Funds>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Funds> findMonthInCome(TzParams params);
	
	public List<Funds> findMonthPayOut(TzParams params);
	
	
	/**
	 * 保存商品管理 com.tz.dao.goods 方法名：save 创建人：落落 手机号码:15712837729 时间：2016年03月15日
	 * 17:15:31
	 * 
	 * @param goods
	 * @return 返回类型：Goods
	 * @exception
	 * @since 1.0.0
	 */
	public int saveDayInCome(Funds funds);
	
	public int saveDayPayOut(Funds funds);
	
	/**
	 * 保存商品管理 com.tz.dao.goods 方法名：save 创建人：落落 手机号码:15712837729 时间：2016年03月15日
	 * 17:15:31
	 * 
	 * @param goods
	 * @return 返回类型：Goods
	 * @exception
	 * @since 1.0.0
	 */
	public int saveWeekInCome(Funds funds);
	
	public int saveWeekPayOut(Funds funds);
	
	/**
	 * 保存商品管理 com.tz.dao.goods 方法名：save 创建人：落落 手机号码:15712837729 时间：2016年03月15日
	 * 17:15:31
	 * 
	 * @param goods
	 * @return 返回类型：Goods
	 * @exception
	 * @since 1.0.0
	 */
	public int saveMonthInCome(Funds funds);
	
	public int saveMonthPayOut(Funds funds);
}
