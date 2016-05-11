/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.dao.feedback;

import java.util.List;

import com.tz.bean.FeedBack;
import com.tz.bean.TzParams;

/**
 * 意见反馈Mapper
 * IFeedBackMapper
 * 创建人:Kirio 
 * 时间：2016年05月04日 10:24:21
 * @version 1.0.0
 * 
 */
public interface IFeedBackMapper {

	/**
	 * 
	 * com.tz.dao.feedback 
	 * 方法名：findFeedBacks
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月04日 10:24:21
	 * @param params
	 * @return 
	 * 返回类型：List<FeedBack>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<FeedBack> findFeedBacks(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.feedback 
	 * 方法名：count
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月04日 10:24:21
	 * @param id
	 * @return 
	 * 返回类型：List<FeedBack>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.dao.feedback 
	 * 方法名：getFeedBack
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月04日 10:24:21
	 * @param id
	 * @return 
	 * 返回类型：List<FeedBack>
	 * @exception 
	 * @since  1.0.0
	 */
	public FeedBack get(Integer id);
	
	/**
	 * 保存意见反馈
	 * com.tz.dao.feedback 
	 * 方法名：save
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月04日 10:24:21
	 * @param feedback
	 * @return 
	 * 返回类型：FeedBack
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(FeedBack feedback);
	
	/**
	 * 更新意见反馈
	 * com.tz.dao.feedback 
	 * 方法名：update
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月04日 10:24:21
	 * @param feedback
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(FeedBack feedback);
	
	/**
	 * 删除意见反馈
	 * com.tz.dao.feedback 
	 * 方法名：delete
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月04日 10:24:21 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
}
