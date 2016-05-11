package com.tz.web.Task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.json.JSONException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.tz.bean.Funds;
import com.tz.bean.TzParams;
import com.tz.service.job.JobService;
import com.tz.service.job.imp.JobServiceImpl;

@Component
public class DayTask implements Job{
	

	private  JobService jobService;
	
	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	@Override
	//把要执行的操作，写在execute方法中  
    public void execute(JobExecutionContext arg0) throws JobExecutionException{  
        System.out.println("测试Quartz"+new Date()); 
        System.out.println("嗨 你好  !!!定时器");  

        DayTask dayTask = new DayTask();

			try {
				dayTask.DayIncome();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
       
//    		
//    		Date date = new Date();
//    		String dateFormat = "YYYY-MM-dd";
//    		DateFormat dateFormat2 = new SimpleDateFormat(dateFormat);//年月日
//    		String time=  dateFormat2.format(date);
//    		TzParams params = new TzParams();
//    		params.setDate("2016-04-06");
//    		List<Funds> datas = jobService.findDayInCome(params);
//    		for (Funds funds : datas) {
//    			System.out.println("========="+funds.getUserId()+"====="+funds.getIncome());
//    			Double inCome = funds.getIncome();
//    			String uid = funds.getUserId();
//    			Funds funds1 = new Funds();
//    			funds1.setUserId(uid);
//    			funds1.setIncome(inCome);
//    			int count = jobService.saveDayInCome(funds1);
//    			System.out.println(count<0?"成功":"失败");
//    		}
        
        
        
		
//    	try {
//			dayTask.DayPayOut();
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	System.out.println("执行了压抑压抑==="); 
    }  
	
	/**
	 * 一天的收入
	 */	
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
	
   	/**
	 * 一天的支出
	 * @throws JSONException
	 */
	public void DayPayOut() throws JSONException{
		
		Date date = new Date();
		String dateFormat = "YYYY-MM-dd";
		DateFormat dateFormat2 = new SimpleDateFormat(dateFormat);//年月日
		String time=  dateFormat2.format(date);
		TzParams params = new TzParams();
		params.setDate(time);
		List<Funds> datas = jobService.findDayPayOut(params);
		for (Funds funds : datas) {
			Double payOut = funds.getPayOut();
			String uid = funds.getUserId();
			Funds funds2 = new Funds();
			funds2.setUserId(uid);
			funds2.setPayOut(payOut);
			int count = jobService.saveDayPayOut(funds2);
			System.out.println(count<0?"成功":"失败");
		}
	}
	
}
