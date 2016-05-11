/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.model
 * Content.java
 * 创建人:落落 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.shopfunds;

import java.util.HashMap;
import java.util.List;

import com.tz.bean.ShopFunds;
import com.tz.bean.TzParams;

/**
 * 
 * IShopFundsService
 * 创建人:落落 
 * 时间：2016年04月01日 11:49:09
 * @version 1.0.0
 * 
 */
public interface IShopFundsService {


	/**
	 * 
	 * com.tz.service.shopfunds 
	 * 方法名：findShopFundss
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年04月01日 11:49:09
	 * @param params
	 * @return 
	 * 返回类型：List<ShopFunds>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<ShopFunds> findShopFundss(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.shopfunds 
	 * 方法名：count
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年04月01日 11:49:09
	 * @param id
	 * @return 
	 * 返回类型：List<ShopFunds>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.service.shopfunds 
	 * 方法名：findShopFundss
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年04月01日 11:49:09
	 * @param params
	 * @return 
	 * 返回类型：List<ShopFunds>
	 * @exception 
	 * @since  1.0.0
	 */
	public ShopFunds get(Integer id);
	
	/**
	 * 保存商家资金管理
	 * com.tz.service.shopfunds 
	 * 方法名：save
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年04月01日 11:49:09 
	 * @param shopfunds
	 * @return 
	 * 返回类型：ShopFunds
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(ShopFunds shopfunds);
	
	/**
	 * 更新商家资金管理
	 * com.tz.service.shopfunds 
	 * 方法名：update
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年04月01日 11:49:09
	 * @param shopfunds
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(ShopFunds shopfunds);
	
	/**
	 * 删除商家资金管理
	 * com.tz.service.shopfunds 
	 * 方法名：delete
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年04月01日 11:49:09
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
	/**
	 * 
	 * 统计出某一天的总账
	 * com.tz.dao.funds 
	 * 方法名：groupFunds
	 * 创建人：luochenxi 
	 * 时间：2016年3月29日-下午3:10:51 
	 * @param params
	 * @return List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 * JDK 1.7
	 */
	public List<ShopFunds> groupFunds(TzParams params);
	
	/**
	 * 
	 * 统计出一周中某一天的总账
	 * com.tz.dao.funds 
	 * 方法名：groupFunds
	 * 创建人：luochenxi 
	 * 时间：2016年3月29日-下午3:10:51 
	 * @param params
	 * @return List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 * JDK 1.7
	 */
	public List<HashMap<String,Object>> groupWeeks(TzParams params); 
	
	
	/**
	 * 
	 * 统计出一年中某一月的总账
	 * com.tz.dao.funds 
	 * 方法名：groupFunds
	 * 创建人：luochenxi 
	 * 时间：2016年3月29日-下午3:10:51 
	 * @param params
	 * @return List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 * JDK 1.7
	 */
	public List<HashMap<String,Object>> groupMonths(TzParams params); 
}
