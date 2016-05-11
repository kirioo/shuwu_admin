/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.approve;

import java.util.List;

import com.tz.bean.Approve;
import com.tz.bean.TzParams;

/**
 * 
 * IApproveService
 * 创建人:Kirio 
 * 时间：2016年05月04日 11:42:26
 * @version 1.0.0
 * 
 */
public interface IApproveService {


	/**
	 * 
	 * com.tz.service.approve 
	 * 方法名：findApproves
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月04日 11:42:26
	 * @param params
	 * @return 
	 * 返回类型：List<Approve>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Approve> findApproves(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.approve 
	 * 方法名：count
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月04日 11:42:26
	 * @param id
	 * @return 
	 * 返回类型：List<Approve>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.service.approve 
	 * 方法名：findApproves
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月04日 11:42:26
	 * @param params
	 * @return 
	 * 返回类型：List<Approve>
	 * @exception 
	 * @since  1.0.0
	 */
	public Approve get(Integer id);
	
	/**
	 * 保存认证管理
	 * com.tz.service.approve 
	 * 方法名：save
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月04日 11:42:26 
	 * @param approve
	 * @return 
	 * 返回类型：Approve
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Approve approve);
	
	/**
	 * 更新认证管理
	 * com.tz.service.approve 
	 * 方法名：update
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月04日 11:42:26
	 * @param approve
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Approve approve);
	
	/**
	 * 删除认证管理
	 * com.tz.service.approve 
	 * 方法名：delete
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月04日 11:42:26
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
}
