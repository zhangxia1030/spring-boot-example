<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'el.ftl' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <font color="red">姓名: </font>${name!''} <br>
     <font color="red">年龄: </font>${age!'10'} <br>
     
     <#if age lt 12>  
	    <font color="red">姓名: ${name!''} </font>不是一个初中生  
	 <#elseif age lt 15>  
	    <font color="red">姓名: ${name!''} </font>不是一个高中生  
	 <#elseif age lt 18>  
	    <font color="red">姓名: ${name!''} </font>不是一个大学生  
	 <#else>  
	    <font color="red">姓名: ${name!''} </font>是一个大学生  
	 </#if>
  </body>
</html>
