package com.tz.service.role;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tz.bean.AdminUser;
import com.tz.bean.Role;
import com.tz.bean.TzParams;

/**
 * 
 * IRoleService
 * 创建人:luochenxi 
 * 时间：2016年3月24日-上午10:35:29 
 * @version 1.0.0
 *
 */
public interface IRoleService {


	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * com.tz.dao.role 
	 * 方法名：findRoles
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:09:04 
	 * @param params
	 * @return List<Role>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Role> findRoles(TzParams params);
	
	/**
	 * 
	 * 求总数
	 * com.tz.dao.role 
	 * 方法名：count
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:08:54 
	 * @param params
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * com.tz.dao.role 
	 * 方法名：get
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:08:46 
	 * @param id
	 * @return Role
	 * @exception 
	 * @since  1.0.0
	 */
	public Role get(Integer id);
	
	/**
	 * 
	 * 保存角色管理
	 * com.tz.dao.role 
	 * 方法名：save
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:08:23 
	 * @param role
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Role role);
	
	/**
	 * 
	 * 更新角色管理
	 * com.tz.dao.role 
	 * 方法名：update
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:08:10 
	 * @param role
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Role role);
	
	/**
	 * 
	 * 删除角色管理
	 * com.tz.dao.role 
	 * 方法名：delete
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:07:56 
	 * @param params
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
	/**
	 * 
	 * 分配角色给用户
	 * com.tz.dao.role 
	 * 方法名：saveRoleUser
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:07:24 
	 * @param userId
	 * @param roleId
	 * @return int
	 * @exception 
	 * @since  1.0.0
	 */
	public int saveRoleUser(@Param("userId")String userId,@Param("roleId")Integer roleId);
	public int saveRolePermission(@Param("roleId")Integer roleId,@Param("permissionId")Integer permissionId);
	public int deleteRolePermission(@Param("roleId")Integer roleId);
	
	/**
	 * 过滤查询用户
	 * 
	 * com.tz.dao.role 
	 * 方法名：findFilterUsers
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:07:07 
	 * @param params
	 * @return List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<AdminUser> findFilterUsers(TzParams params);
	public int countFilterUsers(TzParams params);
	
	/**
	 * 过滤查询用户
	 * 
	 * com.tz.dao.role 
	 * 方法名：findFilterUsers
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:07:07 
	 * @param params
	 * @return List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String,Object>> findFilterAdminUsers(TzParams params);
	public int countFilterAdminUsers(TzParams params);
	
	/**
	 * 
	 * 根据用户查询对应的角色
	 * com.tz.dao.role 
	 * 方法名：findRolesByUserId
	 * 创建人：luochenxi 
	 * 时间：2016年3月22日-下午4:06:52 
	 * @param userId
	 * @return HashMap<String,Object>
	 * @exception 
	 * @since  1.0.0
	 */
	public HashMap<String, Object> findRolesByUserId(String userId);
}
