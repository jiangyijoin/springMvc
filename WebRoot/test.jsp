<!doctype html>
<html>
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta charset="utf-8">
<title>测试</title>
<link href="style.css" rel="stylesheet" type="text/css"/>
<link href="common-all.css" rel="stylesheet" type="text/css"/>
<script src="jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
function initBody(){
	$.ajax({
		type : "POST",
		async : false,// 同步请求
		url : 'http://localhost:8080/spring_mvc/test/query',
		dataType : "json",
		data : {
			type : "day"
		},
		success : function(data) {
			var result = data;
			console.log(result);
			if (result.success == "true") {
				var data = result.data;
				if (data != null && data.length) {
					var obj = data[0];
					mainConfig.data_source = obj.value
				}
			}
		}
	});
/* 	$.ajax({
		type : "POST",
		async : false,// 同步请求
		url : 'http://localhost:8080/spring_mvc/hello',
		dataType : "json",
		success : function(data) {
			var result = data;
			console.log(result);
			if (result.success == "true") {
				var data = result.data;
				if (data != null && data.length) {
					var obj = data[0];
					mainConfig.data_source = obj.value
				}
			}
		}
	}); */
}; 
</script>
</head>

<body onload="initBody()">
	<div class="indicator_view">
    	<table cellpadding="0" cellspacing="0" border="0" width="100%">
        	<tr>
            	<td width="10%" valign="top"><b>全流程</b></td>
                <td>
                	<a href="#">附着成功率 <font class="value_green">96.18%</font></a>
                    <a href="#">附着时延 <font class="value_blue">102.76ms</font></a>
                    <a href="#">承载建立成功率 <font class="value_red">98.17%</font></a>
                    <a href="#">承载建立时延 <font class="value_green">102.76ms</font></a>
                    <a href="#">TAU成功率 <font class="value_green">96.18%</font></a>
                    <a href="#">附着成功率 <font class="value_green">96.18%</font></a>
                    <a href="#">附着成功率 <font class="value_green">96.18%</font></a>
                    <a href="#">附着成功率 <font class="value_green">96.18%</font></a>
                    <a href="#">附着成功率 <font class="value_green">96.18%</font></a>
                    <a href="#">附着成功率 <font class="value_green">96.18%</font></a>
                    <a href="#">附着成功率 <font class="value_green">96.18%</font></a>
                </td>
            </tr>
            <tr>
            	<td valign="top"><b>网页浏览</b></td>
                <td>
                	<a href="#">页面响应成功率 <font class="value_green">96.18%</font></a>
                    <a href="#">页面响应时延 <font class="value_blue">102.76ms</font></a>
                    <a href="#">页面显示成功率 <font class="value_red">98.17%</font></a>
                </td>
            </tr>
            <tr>
            	<td valign="top"><b>即时通信</b></td>
                <td>
                	<a href="#">业务登录成功率 <font class="value_green">96.18%</font></a>
                    <a href="#">大数据下载速率 <font class="value_blue">1392.23kbps</font></a>
                    <a href="#">承载建立成功率 <font class="value_red">98.17%</font></a>
                </td>
            </tr>
            <tr>
            	<td valign="top"><b>应用下载</b></td>
                <td>
                	<a href="#">应用下载成功率 <font class="value_green">96.18%</font></a>
                    <a href="#">应用下载速率 <font class="value_blue">1392.23kbps</font></a>
                    <a href="#">承载建立成功率 <font class="value_red">98.17%</font></a>
                </td>
            </tr>
            <tr>
            	<td valign="top"><b>视频</b></td>
                <td>
                	<a href="#">视频播放成功率 <font class="value_green">96.18%</font></a>
                    <a href="#">视频业务下载速率 <font class="value_blue">1392.23kbps</font></a>
                    <a href="#">承载建立成功率 <font class="value_red">98.17%</font></a>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
