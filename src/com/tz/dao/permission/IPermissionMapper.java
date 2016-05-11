package com.tz.dao.permission;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tz.bean.Permission;
import com.tz.bean.TzParams;

/**
 * 权限管理Mapper
 * IPermissionMapper
 * 创建人:luochenxi
 * 时间：2015年12月14日 22:25:50
 * @version 1.0.0
 * 
 */
public interface IPermissionMapper {

	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * com.tz.dao.permission 
	 * 方法名：findPermissionRoot
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:11:06 
	 * @param params
	 * @return List<Permission>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Permission> findPermissionRoot(TzParams params);
	public List<Permission> findPermissionChildren(@Param("id")Integer parentId);
	
	/**
	 * 求总数
	 * 
	 * com.tz.dao.permission 
	 * 方法名：count
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:11:15 
	 * @param params
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * com.tz.dao.permission 
	 * 方法名：get
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:11:26 
	 * @param id
	 * @return Permission
	 * @exception 
	 * @since  1.0.0
	 */
	public Permission get(Integer id);
	
	/**
	 * 
	 * 保存权限管理
	 * com.tz.dao.permission 
	 * 方法名：save
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:11:39 
	 * @param permission
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Permission permission);
	
	/**
	 * 
	 * 更新权限管理
	 * com.tz.dao.permission 
	 * 方法名：update
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:12:33 
	 * @param permission
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Permission permission);
	
	/**
	 * 
	 * 删除权限管理
	 * com.tz.dao.permission 
	 * 方法名：delete
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:12:48 
	 * @param params
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
}
