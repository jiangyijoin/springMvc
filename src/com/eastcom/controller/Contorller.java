package com.eastcom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.sql.CallableStatement;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.json.JSONObject;

@Controller
public class Contorller {
	
	@RequestMapping(value="/hello")
	public void hello(HttpSession session, HttpServletRequest request,
			HttpServletResponse response){
		ArrayList list  = getDate();
		try {
			response.setContentType("application/json;charset=UTF-8");////防止数据传递乱码
			PrintWriter out = response.getWriter();
			out.print(list);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/ok")
	public String ok(@RequestParam("userid") int id,Model model){
		System.out.println(id);
		model.addAttribute("name", id);
		return "ok";
	}
	
	@RequestMapping(value="/ok1")
	public String ok3(@RequestParam("userid") String name,Map<String, Object> map){
		map.put("name", name);
		return "ok";
	}
	
	
	public ArrayList getDate(){
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
