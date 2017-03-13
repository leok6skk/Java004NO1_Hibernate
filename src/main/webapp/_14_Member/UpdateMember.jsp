<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- <link rel='stylesheet' href='${pageContext.request.contextPath}/css/member.css'  type="text/css" /> --%>
<!-- <script src ="../js/member/update.js"></script> -->
<!-- <script src ="../js/member/member.js"></script> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<!-- <Form Action="Select" method="POST"> -->
<!-- <Form Action="Javascript:%200" onsubmit="getQueryData('Select');return false;"> -->
<Form Action="Javascript:%200" id="update">
<center>
          	  查詢要修改的帳號:
             <input type="text" name="Username" id="UpdateUsername"  value="helloSnoopy" size="20" />
<!--              <input type="submit" value="開始查詢" onclick="getQueryData('Select','resultIndex');"/> -->    
             <button  onclick ="getUpdateData('UpdateUsername','SeleteToUpdate','Update','update','result');" style="position:fixed;top:4em;right:15.625em;">
				查詢
			</button>
</center>
</Form>
<div id="result">
	<br>
</div>

</body>

</html>