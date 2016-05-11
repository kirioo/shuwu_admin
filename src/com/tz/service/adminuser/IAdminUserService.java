/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.model
 * Content.java
 * 创建人:落落 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.adminuser;

import java.util.List;

import com.tz.bean.AdminUser;
import com.tz.bean.TzParams;

/**
 * 
 * IAdminUserService
 * 创建人:落落 
 * 时间：2016年03月17日 14:37:12
 * @version 1.0.0
 * 
 */
public interface IAdminUserService {


	/**
	 * 
	 * com.tz.service.adminuser 
	 * 方法名：findAdminUsers
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 14:37:12
	 * @param params
	 * @return 
	 * 返回类型：List<AdminUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<AdminUser> findAdminUsers(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.adminuser 
	 * 方法名：count
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 14:37:12
	 * @param id
	 * @return 
	 * 返回类型：List<AdminUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.service.adminuser 
	 * 方法名：findAdminUsers
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 14:37:12
	 * @param params
	 * @return 
	 * 返回类型：List<AdminUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public AdminUser get(Integer id);
	
	/**
	 * 保存用户管理
	 * com.tz.service.adminuser 
	 * 方法名：save
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 14:37:12 
	 * @param adminuser
	 * @return 
	 * 返回类型：AdminUser
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(AdminUser adminuser);
	
	/**
	 * 更新用户管理
	 * com.tz.service.adminuser 
	 * 方法名：update
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 14:37:12
	 * @param adminuser
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(AdminUser adminuser);
	
	/**
	 * 删除用户管理
	 * com.tz.service.adminuser 
	 * 方法名：delete
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 14:37:12
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
	/**
	 * 修改密码
	 * com.tz.service.adminuser 
	 * 方法名：update
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 14:37:12
	 * @param adminuser
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int updatePassword(AdminUser adminUser);
	
	/**
	 * 根据邮箱查询用户
	 * com.tz.service.adminuser 
	 * 方法名：update
	 * 创建人：落落 
	 * 手机号码:15712837729
	 * 时间：2016年03月17日 14:37:12
	 * @param adminuser
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public List<AdminUser> findUpdateUsers(TzParams params);
}
