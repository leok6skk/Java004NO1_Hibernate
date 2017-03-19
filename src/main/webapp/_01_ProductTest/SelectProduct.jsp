<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tab_main.css"> --%>
<%-- <script src="${pageContext.request.contextPath}/js/product_new.js" type="text/JavaScript"></script> --%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<title>MVC</title>
<body>

	<CENTER>
	<Form Action="Javascript:%200" >
		<div>
			序號查詢:<input type="text" id="productId" name="productId" value="" size="20" placeholder="不輸入將搜尋全部"> 
					<input type="button" value="開始查詢" onclick="getQueryData('SelectProduct.do');">
			品名查詢:<input type="text" id="productName" name="productName" value="" size="20"> 
			<input type="button" value="開始查詢" onclick="getQueryData('SelectProduct.do');">
		</div>	
	</Form>
		<div id="selectResult"></div>
	</CENTER>

</body>
</html>