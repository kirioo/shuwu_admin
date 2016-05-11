/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.role
 * IRoleService.java
 * 创建人:柯柯 
 * 时间：2015年12月18日 20:59:39
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.role.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.AdminUser;
import com.tz.bean.Role;
import com.tz.bean.TzParams;
import com.tz.dao.role.IRoleMapper;
import com.tz.service.role.IRoleService;
import com.tz.util.TmStringUtils;

/**
 * 角色管理serviceImpl
 * IRoleService
 * 创建人:柯柯 
 * 时间：2015年12月18日 20:59:39
 * @version 1.0.0
 * 
 */
@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private IRoleMapper roleMapper;
	
	@Override
	public List<Role> findRoles(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return roleMapper.findRoles(params);
	}
	
	@Override
	public int count(TzParams params){
		return roleMapper.count(params);
	}

	@Override
	public Role get(Integer id) {
		return roleMapper.get(id);
	}

	@Override
	public int save(Role role) {
		return roleMapper.save(role);
	}

	@Override
	public int update(Role role) {
		return roleMapper.update(role);
	}

	@Override
	public int delete(TzParams params) {
		return roleMapper.delete(params);
	}

	@Override
	public int saveRoleUser(String userId, Integer roleId) {
		return roleMapper.saveRoleUser(userId, roleId);
	}

	@Override
	public List<AdminUser> findFilterUsers(TzParams params) {
		return roleMapper.findFilterUsers(params);
	}

	
	@Override
	public int countFilterUsers(TzParams params) {
		return roleMapper.countFilterUsers(params);
	}
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
	@Override
	public List<HashMap<String,Object>> findFilterAdminUsers(TzParams params) {
		return roleMapper.findFilterAdminUsers(params);
	}

	
	@Override
	public int countFilterAdminUsers(TzParams params) {
		return roleMapper.countFilterAdminUsers(params);
	}


	@Override
	public int saveRolePermission(Integer roleId, Integer permissionId) {
		return roleMapper.saveRolePermission(roleId, permissionId);
	}
	
	@Override
	public int deleteRolePermission(Integer roleId) {
		return roleMapper.deleteRolePermission(roleId);
	}

	@Override
	public HashMap<String, Object> findRolesByUserId(String userId) {
		return roleMapper.findRolesByUserId(userId);
	}
}
