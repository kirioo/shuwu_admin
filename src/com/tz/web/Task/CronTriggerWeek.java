package com.tz.web.Task;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import com.tz.web.Task.impl.WeekTask;

public class CronTriggerWeek {
	
	/**
	 * 每周的调度
	 */
	public void weeKCron() {  
	     
	     //通过schedulerFactory获取一个调度器  
	       SchedulerFactory schedulerfactory=new StdSchedulerFactory();  
	       Scheduler scheduler=null;  
	       try{  
//	      通过schedulerFactory获取一个调度器  
	           scheduler=schedulerfactory.getScheduler();  
	             
//	       创建jobDetail实例，绑定Job实现类  
//	       指明job的名称，所在组的名称，以及绑定job类  
	           JobDetail jobDetail=new JobDetail("job2", "jgroup2", WeekTask.class);  
	             
//	       定义调度触发规则，每天上午10：15执行  
	           CronTrigger cornTrigger=new CronTrigger("cronTrigger","triggerGroup");  
//	       执行规则表达式  
	           cornTrigger.setCronExpression("0 58 23 ? * SAT");  
	         //  cornTrigger.setCronExpression("*/5 * * * * ?");
//	       把作业和触发器注册到任务调度中  
	           scheduler.scheduleJob(jobDetail, cornTrigger);  
	             
//	       启动调度  
	           scheduler.start();  
	             
	             
	       }catch(Exception e){  
	           e.printStackTrace();  
	       }  
	         
	}  
	
}
