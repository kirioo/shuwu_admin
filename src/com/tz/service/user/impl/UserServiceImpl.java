/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.user
 * UserService.java
 * 创建人:xuchengfei 
 * 时间：2015年11月24日-上午1:01:27 
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.AdminUser;
import com.tz.bean.TzParams;
import com.tz.dao.user.IUserMapper;
import com.tz.service.user.IUserService;

/**
 * 
 * UserService
 * 创建人:luochenxi 
 * 时间：2015年11月24日-上午1:01:27 
 * @version 1.0.0
 * 
 */
@Service
public class UserServiceImpl  implements IUserService{


	@Autowired
	private IUserMapper userMapper;
	
	@Override
	public AdminUser getLogin(TzParams params) {
		return userMapper.getLogin(params);	
	}

	/* (non-Javadoc)
	 * @see com.tz.service.user.IUserService#saveBatch(java.util.List)
	 */
	@Override
	public int saveBatch(List<AdminUser> adminUsers) {
		return userMapper.saveBatch(adminUsers);
	}
	
	@Override
	public int batchUpdate(List<AdminUser> adminUsers) {
		return userMapper.batchUpdate(adminUsers);
	}
}
