/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.model
 * Content.java
 * 创建人:落落 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.adminuser.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.AdminUser;
import com.tz.bean.TzParams;
import com.tz.dao.adminuser.IAdminUserMapper;
import com.tz.service.adminuser.IAdminUserService;
import com.tz.util.TmStringUtils;

/**
 * 用户管理serviceImpl
 * IAdminUserService
 * 创建人:落落 
 * 时间：2016年03月17日 14:37:12
 * @version 1.0.0
 * 
 */
@Service
public class AdminUserServiceImpl implements IAdminUserService{

	@Autowired
	private IAdminUserMapper adminuserMapper;
	
	@Override
	public List<AdminUser> findAdminUsers(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return adminuserMapper.findAdminUsers(params);
	}
	
	@Override
	public int count(TzParams params){
		return adminuserMapper.count(params);
	}

	@Override
	public AdminUser get(Integer id) {
		return adminuserMapper.get(id);
	}

	@Override
	public int save(AdminUser adminuser) {
		return adminuserMapper.save(adminuser);
	}

	@Override
	public int update(AdminUser adminuser) {
		return adminuserMapper.update(adminuser);
	}

	@Override
	public int delete(TzParams params) {
		return adminuserMapper.delete(params);
	}
	
	@Override
	public int updatePassword(AdminUser adminUser) {
		return adminuserMapper.updatePassword(adminUser);
	}
	
	@Override
	public List<AdminUser> findUpdateUsers(TzParams params){
		return adminuserMapper.findUpdateUsers(params);
	}
}
