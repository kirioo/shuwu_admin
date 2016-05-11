/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.event;

import java.util.HashMap;
import java.util.List;

import com.tz.bean.Event;
import com.tz.bean.TzParams;

/**
 * 
 * IEventService
 * 创建人:Kirio 
 * 时间：2016年04月29日 16:26:10
 * @version 1.0.0
 * 
 */
public interface IEventService {


	/**
	 * 
	 * com.tz.service.event 
	 * 方法名：findEvents
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年04月29日 16:26:10
	 * @param params
	 * @return 
	 * 返回类型：List<Event>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Event> findEvents(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.event 
	 * 方法名：count
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年04月29日 16:26:10
	 * @param id
	 * @return 
	 * 返回类型：List<Event>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.service.event 
	 * 方法名：findEvents
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年04月29日 16:26:10
	 * @param params
	 * @return 
	 * 返回类型：List<Event>
	 * @exception 
	 * @since  1.0.0
	 */
	public Event get(Integer id);
	
	/**
	 * 保存活动管理
	 * com.tz.service.event 
	 * 方法名：save
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年04月29日 16:26:10 
	 * @param event
	 * @return 
	 * 返回类型：Event
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Event event);
	
	/**
	 * 更新活动管理
	 * com.tz.service.event 
	 * 方法名：update
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年04月29日 16:26:10
	 * @param event
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Event event);
	
	/**
	 * 删除活动管理
	 * com.tz.service.event 
	 * 方法名：delete
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年04月29日 16:26:10
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
	
	/**
	 * 参加活动人员详情
	 * com.tz.dao.event 
	 * 方法名：delete
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年04月29日 16:26:10 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Event> findEventUsers(TzParams params);
}
