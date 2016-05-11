package com.tz.web.Task.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tz.bean.Funds;
import com.tz.bean.TzParams;
import com.tz.service.job.JobService;

@Component
public class WeekTask implements Job{
	
	@Autowired
	private JobService jobService;
	
	@Override
	//把要执行的操作，写在execute方法中  
    public void execute(JobExecutionContext arg0) throws JobExecutionException{  
        System.out.println("测试Quartz"+new Date()); 
        System.out.println("嗨 你好  !!!定时器");  
        
		

       WeekTask weekTask = new WeekTask();
       weekTask.WeekIncome();
		

    	System.out.println("执行了压抑压抑==="); 
    }  
	
	/**
	 * 一周的收入
	 */
	public void WeekIncome(){
		Date date = new Date();
		String dateFormat = "YYYY-MM-dd";
		DateFormat dateFormat2 = new SimpleDateFormat(dateFormat);//年月日
		String time=  dateFormat2.format(date);
		TzParams params = new TzParams();
		params.setDate(time);
		List<Funds> datas = jobService.findWeekInCome(params);
		for (Funds funds : datas) {
			System.out.println("========="+funds.getUserId()+"====="+funds.getIncome()+"====="+funds.getPayOut()+"====="+funds.getGl());
			Double inCome = funds.getIncome();
			Double payOut = funds.getPayOut();
			Double gl = funds.getGl();
			String uid = funds.getUserId();
			Funds funds1 = new Funds();
			funds1.setUserId(uid);
			funds1.setIncome(inCome);
			funds1.setPayOut(payOut);
			funds1.setGl(gl);
			int count = jobService.saveWeekInCome(funds1);
			System.out.println(count<0?"成功":"失败");
		}
	}
	
}
