<%@page contentType="text/html; charset=UTF-8" %>

<html>
<head>
	<title>保存客户信息</title>
</head>
<body>
	<!-- <form action="/crm/save"> 其中/crm可以动态获取-->
	<form action="<%=request.getContextPath() %>/save" method="post"> 
	
		客户名字：
			<input type="text" name="realname">
			<br>
			<br>
		生日：
			<input type="text" name="birth">   <!-- 这里长度为10已经固定，不让用户自己写，使用日期插件 -->
			<br>
			<br>
		性别：
			<input type="radio" name="sex" value="m">男
			<input type="radio" name="sex" value="f">女
			<br>
			<br>
		联系电话：
			<input type="text" name="tel" >
			<br>
			<br>
		<input type="submit" value="保存">
			
	</form>

</body>



</html>










