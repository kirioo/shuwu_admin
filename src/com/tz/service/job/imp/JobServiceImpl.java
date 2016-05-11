package com.tz.service.job.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.Funds;
import com.tz.bean.TzParams;
import com.tz.dao.job.IJobMapper;
import com.tz.service.job.JobService;

@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	private IJobMapper jobMapper;
	
	@Override
	public List<Funds> findDayInCome(TzParams params) {
		return jobMapper.findDayInCome(params);
	}

	@Override
	public List<Funds> findDayPayOut(TzParams params) {
		return jobMapper.findDayPayOut(params);
	}

	@Override
	public List<Funds> findWeekInCome(TzParams params) {
		return jobMapper.findWeekInCome(params);
	}

	@Override
	public List<Funds> findWeekPayOut(TzParams params) {
		return jobMapper.findWeekPayOut(params);
	}

	@Override
	public List<Funds> findMonthInCome(TzParams params) {
		return jobMapper.findMonthInCome(params);
	}

	@Override
	public List<Funds> findMonthPayOut(TzParams params) {
		return jobMapper.findMonthPayOut(params);
	}

	@Override
	public int saveDayInCome(Funds funds) {
		return jobMapper.saveDayInCome(funds);
	}
	
	@Override
	public int saveDayPayOut(Funds funds) {
		return jobMapper.saveDayPayOut(funds);
	}

	@Override
	public int saveWeekInCome(Funds funds) {
		return jobMapper.saveWeekInCome(funds);
	}
	
	@Override
	public int saveWeekPayOut(Funds funds) {
		return jobMapper.saveWeekPayOut(funds);
	}

	@Override
	public int saveMonthInCome(Funds funds) {
		return jobMapper.saveMonthInCome(funds);
	}
	
	@Override
	public int saveMonthPayOut(Funds funds) {
		return jobMapper.saveMonthPayOut(funds);
	}
}
