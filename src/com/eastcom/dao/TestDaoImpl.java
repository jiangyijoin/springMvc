package com.eastcom.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

/**
 * 
 * <p>Title: MobileEndToEndDaoImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: Eastcom</p>
 * @author liyn 
 * @date Mar 19, 2014 3:18:09 PM 
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
@Component
public class TestDaoImpl implements TestDao {
	
	public List queryDate(String type){
		String driver = "oracle.jdbc.driver.OracleDriver";  
        String url = "jdbc:Oracle:thin:@10.40.94.8:1521:INAS";  
        Statement stmt = null;  
        ResultSet res = null;  
        Connection conn = null;  
        CallableStatement proc = null;  
        String sql = " select T.TIME_ID, T.APP_TYPE_NAME,T.AREA_NAME,T.INDEX_VALUE from TEST_JIN_D t where t.TIME_ID=201608010000";  
          
        ArrayList list  = new ArrayList();
        try {  
            Class.forName(driver);  
            conn = DriverManager.getConnection(url, "IPMSDM", "IPMSDM$94#8");  
            stmt = conn.createStatement();  
            res = stmt.executeQuery(sql);  
            while(res.next())  
            {  
                String time_id = res.getString("TIME_ID");  
                String area_name = res.getString("AREA_NAME");  
                String app_type_name = res.getString("APP_TYPE_NAME");  
                String index_value = res.getString("INDEX_VALUE");  
                JSONObject json = new JSONObject();
                json.accumulate("time_id", time_id);
                json.accumulate("area_name", area_name);
                json.accumulate("app_type_name", app_type_name);
                json.accumulate("index_value", index_value);
                list.add(json);
            }  
            return list;
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }
		return list;  
	}
	
	
}
