<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tab_main.css"> --%>
<%-- <script src="${pageContext.request.contextPath}/jQuery/jquery-1.12.4.min.js" type="text/JavaScript"></script> --%>
<%-- <script src="${pageContext.request.contextPath}/js/product_new.js" type="text/JavaScript"></script> --%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<title>MVC</title>
<body>
<CENTER>
	<form  id="form1" name="form1" method="post" action=".do"  enctype="multipart/form-data" >
			<input type="file" name="importProduct" id="importProduct">
			<input type="submit" name="importBtn" id="importBtn" disabled>
				<div id="importResult"></div>
	</form>
	
</CENTER>
</body>
</html>