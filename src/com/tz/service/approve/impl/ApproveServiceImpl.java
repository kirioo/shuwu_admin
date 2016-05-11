/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.approve.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.Approve;
import com.tz.bean.TzParams;
import com.tz.dao.approve.IApproveMapper;
import com.tz.service.approve.IApproveService;
import com.tz.util.TmStringUtils;

/**
 * 认证管理serviceImpl
 * IApproveService
 * 创建人:Kirio 
 * 时间：2016年05月04日 11:42:26
 * @version 1.0.0
 * 
 */
@Service
public class ApproveServiceImpl implements IApproveService{

	@Autowired
	private IApproveMapper approveMapper;
	
	@Override
	public List<Approve> findApproves(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("createTime desc");
		return approveMapper.findApproves(params);
	}
	
	@Override
	public int count(TzParams params){
		return approveMapper.count(params);
	}

	@Override
	public Approve get(Integer id) {
		return approveMapper.get(id);
	}

	@Override
	public int save(Approve approve) {
		return approveMapper.save(approve);
	}

	@Override
	public int update(Approve approve) {
		return approveMapper.update(approve);
	}

	@Override
	public int delete(TzParams params) {
		return approveMapper.delete(params);
	}
}
