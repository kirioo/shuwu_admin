/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.recommend;

import java.util.List;

import com.tz.bean.Recommend;
import com.tz.bean.TzParams;

/**
 * 
 * IRecommendService
 * 创建人:Kirio 
 * 时间：2016年04月29日 10:57:23
 * @version 1.0.0
 * 
 */
public interface IRecommendService {


	/**
	 * 
	 * com.tz.service.recommend 
	 * 方法名：findRecommends
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年04月29日 10:57:23
	 * @param params
	 * @return 
	 * 返回类型：List<Recommend>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Recommend> findRecommends(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.recommend 
	 * 方法名：count
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年04月29日 10:57:23
	 * @param id
	 * @return 
	 * 返回类型：List<Recommend>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.service.recommend 
	 * 方法名：findRecommends
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年04月29日 10:57:23
	 * @param params
	 * @return 
	 * 返回类型：List<Recommend>
	 * @exception 
	 * @since  1.0.0
	 */
	public Recommend get(Integer id);
	
	/**
	 * 保存推荐管理
	 * com.tz.service.recommend 
	 * 方法名：save
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年04月29日 10:57:23 
	 * @param recommend
	 * @return 
	 * 返回类型：Recommend
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Recommend recommend);
	
	/**
	 * 更新推荐管理
	 * com.tz.service.recommend 
	 * 方法名：update
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年04月29日 10:57:23
	 * @param recommend
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Recommend recommend);
	
	/**
	 * 删除推荐管理
	 * com.tz.service.recommend 
	 * 方法名：delete
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年04月29日 10:57:23
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
}
