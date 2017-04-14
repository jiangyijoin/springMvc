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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eastcom.dao.TestDao;
import com.eastcom.service.TestService;

import net.sf.json.JSONObject;

@Controller
public class Test {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value="/test/query")
	public void hello(HttpSession session, HttpServletRequest request,
			HttpServletResponse response){
		String type = request.getParameter("type");
		System.err.println(type);
		List list  = testService.queryDate(type);
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
	
}
