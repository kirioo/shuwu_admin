/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.permission
 * IPermissionService.java
 * 创建人:柯柯 
 * 时间：2015年12月14日 22:25:50
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.permission;

import java.util.HashMap;

import com.tz.bean.Permission;
import com.tz.bean.TzParams;

/**
 * 
 * IPermissionService
 * 创建人:柯柯 
 * 时间：2015年12月14日 22:25:50
 * @version 1.0.0
 * 
 */
public interface IPermissionService {


	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * com.tz.service.permission 
	 * 方法名：findPermissions
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:14:18 
	 * @param params
	 * @return HashMap<String,Object>
	 * @exception 
	 * @since  1.0.0
	 */
	public HashMap<String,Object> findPermissions(TzParams params);
	
	/**
	 * 
	 * 求总数
	 * com.tz.service.permission 
	 * 方法名：count
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:14:26 
	 * @param params
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * com.tz.service.permission 
	 * 方法名：get
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:14:35 
	 * @param id
	 * @return Permission
	 * @exception 
	 * @since  1.0.0
	 */
	public Permission get(Integer id);
	
	/**
	 * 
	 * 保存权限管理
	 * com.tz.service.permission 
	 * 方法名：save
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:14:43 
	 * @param permission
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Permission permission);
	
	/**
	 * 
	 * 更新权限管理
	 * com.tz.service.permission 
	 * 方法名：update
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:14:52 
	 * @param permission
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Permission permission);
	
	/** 
	 * 删除权限管理
	 * com.tz.service.permission 
	 * 方法名：delete
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:15:03 
	 * @param params
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
}
