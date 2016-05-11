/**
 * 树屋系统平台
 * Kirio
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.service.vip.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.VIP;
import com.tz.bean.TzParams;
import com.tz.dao.vip.IVIPMapper;
import com.tz.service.vip.IVIPService;
import com.tz.util.TmStringUtils;

/**
 * 会员管理serviceImpl
 * IVIPService
 * 创建人:Kirio 
 * 时间：2016年05月05日 10:40:44
 * @version 1.0.0
 * 
 */
@Service
public class VIPServiceImpl implements IVIPService{

	@Autowired
	private IVIPMapper vipMapper;
	
	@Override
	public List<VIP> findVIPs(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("createTime desc");
		return vipMapper.findVIPs(params);
	}
	
	@Override
	public int count(TzParams params){
		return vipMapper.count(params);
	}

	@Override
	public VIP get(Integer id) {
		return vipMapper.get(id);
	}

	@Override
	public int save(VIP vip) {
		return vipMapper.save(vip);
	}

	@Override
	public int update(VIP vip) {
		return vipMapper.update(vip);
	}

	@Override
	public int delete(TzParams params) {
		return vipMapper.delete(params);
	}
}
