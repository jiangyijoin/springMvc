package com.eastcom.service;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eastcom.dao.TestDao;

/**
 * 端到端指标阀值信息查询
 * @author whm
 *
 */
@Component
@Transactional(readOnly = true)
public class TestService{
	@Autowired
	private TestDao testDao;
	
	/**
	 * 查询业务KQI指标信息
	 * @param NETWORK_TYPE
	 * @return
	 */
	public List<JSONObject> queryDate(String type){
		return testDao.queryDate(type);
	}

}
