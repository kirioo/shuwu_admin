/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.Member;
import com.tz.bean.TzParams;
import com.tz.dao.member.IMemberMapper;
import com.tz.service.member.IMemberService;
import com.tz.util.TmStringUtils;

/**
 * 用户会员管理serviceImpl
 * IMemberService
 * 创建人:Kirio 
 * 时间：2016年05月06日 10:12:59
 * @version 1.0.0
 * 
 */
@Service
public class MemberServiceImpl implements IMemberService{

	@Autowired
	private IMemberMapper memberMapper;
	
	@Override
	public List<Member> findMembers(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("createTime desc");
		return memberMapper.findMembers(params);
	}
	
	@Override
	public int count(TzParams params){
		return memberMapper.count(params);
	}

	@Override
	public Member get(Integer id) {
		return memberMapper.get(id);
	}

	@Override
	public int save(Member member) {
		return memberMapper.save(member);
	}

	@Override
	public int update(Member member) {
		return memberMapper.update(member);
	}

	@Override
	public int delete(TzParams params) {
		return memberMapper.delete(params);
	}
}
