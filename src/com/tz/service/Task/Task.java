package com.tz.service.Task;

import com.tz.bean.TzParams;
import com.tz.service.Task.impl.TaskImpl;

public class Task {
	
	public void saveDay(){
		TzParams params = new TzParams();
		params.setDate("2016-04-05");//定时任务的时间
		TaskImpl taskImpl = new TaskImpl();
		taskImpl.saveDayInCome(params);
		taskImpl.saveDayPayOut(params);
	}
	
	public static void main(String[] args) {
		Task task = new Task();
		task.saveDay();
	}
}
