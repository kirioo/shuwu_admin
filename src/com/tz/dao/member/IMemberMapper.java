/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.dao.member;

import java.util.List;

import com.tz.bean.Member;
import com.tz.bean.TzParams;

/**
 * 用户会员管理Mapper
 * IMemberMapper
 * 创建人:Kirio 
 * 时间：2016年05月06日 10:12:59
 * @version 1.0.0
 * 
 */
public interface IMemberMapper {

	/**
	 * 
	 * com.tz.dao.member 
	 * 方法名：findMembers
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月06日 10:12:59
	 * @param params
	 * @return 
	 * 返回类型：List<Member>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Member> findMembers(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.member 
	 * 方法名：count
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月06日 10:12:59
	 * @param id
	 * @return 
	 * 返回类型：List<Member>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.dao.member 
	 * 方法名：getMember
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月06日 10:12:59
	 * @param id
	 * @return 
	 * 返回类型：List<Member>
	 * @exception 
	 * @since  1.0.0
	 */
	public Member get(Integer id);
	
	/**
	 * 保存用户会员管理
	 * com.tz.dao.member 
	 * 方法名：save
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月06日 10:12:59
	 * @param member
	 * @return 
	 * 返回类型：Member
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Member member);
	
	/**
	 * 更新用户会员管理
	 * com.tz.dao.member 
	 * 方法名：update
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月06日 10:12:59
	 * @param member
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Member member);
	
	/**
	 * 删除用户会员管理
	 * com.tz.dao.member 
	 * 方法名：delete
	 * 创建人：Kirio 
	 * 手机号码:15712897729
	 * 时间：2016年05月06日 10:12:59 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
}
