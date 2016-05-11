/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.content
 * IContentService.java
 * 创建人:xuchengfei 
 * 时间：2015年11月28日-下午11:05:21 
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.content;

import java.util.List;

import com.tz.bean.Content;
import com.tz.bean.TzParams;

/**
 * 
 * IContentService
 * 创建人:xuchengfei 
 * 时间：2015年11月28日-下午11:05:21 
 * @version 1.0.0
 * 
 */
public interface IContentService {


	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * com.tz.dao.content 
	 * 方法名：findContents
	 * 创建人：luochenxi 
	 * 时间：2016年3月14日-下午1:55:27 
	 * @param params
	 * @return List<Content>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Content> findContents(TzParams params);
	
	/**
	 * 
	 * 求总数
	 * com.tz.dao.content 
	 * 方法名：count
	 * 创建人：luochenxi 
	 * 时间：2016年3月14日-下午1:55:41 
	 * @param params
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * com.tz.dao.content 
	 * 方法名：get
	 * 创建人：luochenxi 
	 * 时间：2016年3月14日-下午1:55:52 
	 * @param id
	 * @return Content
	 * @exception 
	 * @since  1.0.0
	 */
	public Content getContent(Integer id);
	
	
	/**
	 * 
	 * 保存内容
	 * com.tz.dao.content 
	 * 方法名：save
	 * 创建人：luochenxi 
	 * 时间：2016年3月14日-下午1:56:07 
	 * @param content
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Content content);
	
	/**
	 * 
	 * 更新内容
	 * com.tz.dao.content 
	 * 方法名：update
	 * 创建人：luochenxi 
	 * 时间：2016年3月14日-下午1:56:31 
	 * @param content
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Content content);
	
	/**
	 * 
	 * 删除内容
	 * com.tz.dao.content 
	 * 方法名：delete
	 * 创建人：luochenxi 
	 * 时间：2016年3月14日-下午1:56:51 
	 * @param params
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
}
