package com.tz.web.Task.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tz.bean.Funds;
import com.tz.bean.TzParams;
import com.tz.service.job.JobService;
@Controller
public class Test {
	
		@Autowired
		private static  JobService jobService;
		
		public void DayIncome() throws Exception{
		
			Date date = new Date();
			String dateFormat = "YYYY-MM-dd";
			DateFormat dateFormat2 = new SimpleDateFormat(dateFormat);//年月日
			String time=  dateFormat2.format(date);
			TzParams params = new TzParams();
			params.setDate(time);
			List<Funds> datas = jobService.findDayInCome(params);
			for (Funds funds : datas) {
				System.out.println("========="+funds.getUserId()+"====="+funds.getIncome());
	//			Double inCome = funds.getIncome();
	//			String uid = funds.getUserId();
	//			Funds funds1 = new Funds();
	//			funds1.setUserId(uid);
	//			funds1.setIncome(inCome);
	//			int count = jobService.saveDayInCome(funds1);
	//			System.out.println(count<0?"成功":"失败");
			}
		}
		
		public static void main(String[] args) {
			
			Date date = new Date();
			String dateFormat = "YYYY-MM-dd";
			DateFormat dateFormat2 = new SimpleDateFormat(dateFormat);//年月日
			String time=  dateFormat2.format(date);
			TzParams params = new TzParams();
			params.setDate("2016-04-06");
			List<Funds> datas = jobService.findDayInCome(params);
			for (Funds funds : datas) {
				System.out.println("========="+funds.getUserId()+"====="+funds.getIncome());
	//			Double inCome = funds.getIncome();
	//			String uid = funds.getUserId();
	//			Funds funds1 = new Funds();
	//			funds1.setUserId(uid);
	//			funds1.setIncome(inCome);
	//			int count = jobService.saveDayInCome(funds1);
	//			System.out.println(count<0?"成功":"失败");
			}
		}
}
