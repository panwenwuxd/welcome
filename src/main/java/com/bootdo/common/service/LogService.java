package com.bootdo.common.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.bootdo.common.dao.LogDao;
import com.bootdo.common.domain.LogDO;
import com.bootdo.common.domain.PageDO;
import com.bootdo.common.service.LogService;
import com.bootdo.common.utils.Query;

@Service
public class LogService {
	@Autowired
	LogDao logMapper;

	@Async
	public void save(LogDO logDO) {
		 logMapper.save(logDO);
	}

	
	public PageDO<LogDO> queryList(Query query) {
		int total = logMapper.count(query);
		List<LogDO> logs = logMapper.list(query);
		PageDO<LogDO> page = new PageDO<>();
		page.setTotal(total);
		page.setRows(logs);
		return page;
	}

	
	public int remove(Long id) {
		int count = logMapper.remove(id);
		return count;
	}

	
	public int batchRemove(Long[] ids){
		return logMapper.batchRemove(ids);
	}
}
