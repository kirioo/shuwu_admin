/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.vip;

import java.util.List;

import com.tz.bean.VIP;
import com.tz.bean.TzParams;

/**
 * 
 * IVIPService
 * 创建人:Kirio 
 * 时间：2016年05月05日 10:40:44
 * @version 1.0.0
 * 
 */
public interface IVIPService {


	/**
	 * 
	 * com.tz.service.vip 
	 * 方法名：findVIPs
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月05日 10:40:44
	 * @param params
	 * @return 
	 * 返回类型：List<VIP>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<VIP> findVIPs(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.vip 
	 * 方法名：count
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月05日 10:40:44
	 * @param id
	 * @return 
	 * 返回类型：List<VIP>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.service.vip 
	 * 方法名：findVIPs
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月05日 10:40:44
	 * @param params
	 * @return 
	 * 返回类型：List<VIP>
	 * @exception 
	 * @since  1.0.0
	 */
	public VIP get(Integer id);
	
	/**
	 * 保存会员管理
	 * com.tz.service.vip 
	 * 方法名：save
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月05日 10:40:44 
	 * @param vip
	 * @return 
	 * 返回类型：VIP
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(VIP vip);
	
	/**
	 * 更新会员管理
	 * com.tz.service.vip 
	 * 方法名：update
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月05日 10:40:44
	 * @param vip
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(VIP vip);
	
	/**
	 * 删除会员管理
	 * com.tz.service.vip 
	 * 方法名：delete
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月05日 10:40:44
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
}
