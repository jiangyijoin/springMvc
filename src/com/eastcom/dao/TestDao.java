package com.eastcom.dao;

import java.util.List;

import net.sf.json.JSONObject;

/**
 * 
 * <p>Title: MobileEndToEndDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: Eastcom</p>
 * @author jiangyi 
 * @date Mar 19, 2014 3:18:17 PM 
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public interface TestDao{
	
	/**
	 *查询数据
	 */
	List queryDate(String type);
	
}
