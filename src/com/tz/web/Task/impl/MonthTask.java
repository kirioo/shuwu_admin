package com.tz.web.Task.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public class MonthTask implements Job{
	
	@Autowired
	private JobService jobService;
	
	@Override
	//把要执行的操作，写在execute方法中  
    public void execute(JobExecutionContext arg0) throws JobExecutionException{  
        System.out.println("测试Quartz"+new Date()); 
        System.out.println("嗨 你好  !!!定时器");  
        
		

       MonthTask monthTask = new MonthTask();
       monthTask.MonthIncome();
		

    	System.out.println("执行了压抑压抑==="); 
    }  
	
	/**
	 * 一周的收入
	 */
	public void MonthIncome(){
		Date dNow = new Date();   //当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(dNow);//把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
		dBefore = calendar.getTime();   //得到前一天的时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM"); //设置时间格式
		String defaultStartDate = sdf.format(dBefore);    //格式化前一天
		TzParams params = new TzParams();								
		params.setYearMonth(defaultStartDate);
		List<Funds> datas = jobService.findMonthInCome(params);
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
			int count = jobService.saveMonthInCome(funds1);
			System.out.println(count<0?"成功":"失败");
		}

	}
	
}
