package com.tz.service.Task.impl;

import java.util.List;

import org.apache.struts2.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

import com.tz.bean.Funds;
import com.tz.bean.TzParams;
import com.tz.service.job.JobService;

public class TaskImpl {
	
	@Autowired
	private JobService jobService;
	
	public void saveDayInCome(TzParams params){
		List<Funds> datas = jobService.findDayInCome(params);
		for (Funds funds : datas) {
			Double inCome = funds.getIncome();
			String uid = funds.getUserId();
			Funds funds1 = new Funds();
			funds.setUserId(uid);
			funds.setIncome(inCome);
			int count = jobService.saveDayInCome(funds);
			System.out.println(count<0?"成功":"失败");
		}
	}
		
	/**
	 * 一天的支出
	 * @throws JSONException
	 */

	public void saveDayPayOut (TzParams params){
		List<Funds> datas = jobService.findDayPayOut(params);
		for (Funds funds : datas) {
			Double payOut = funds.getPayOut();
			String uid = funds.getUserId();
			Funds funds1 = new Funds();
			funds1.setUserId(uid);
			funds1.setPayOut(payOut);
			int count = jobService.saveDayPayOut(funds1);
			System.out.println(count<0?"成功":"失败");
		}
	}
	
	
}
