<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- <link rel="stylesheet" href="../css/member/member2.css?v524" -->
<!-- 	type="text/css"> -->
<script src="../js/member/insert.js"></script>
<script src="../js/member/member.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body>
<!-- 	<button style="position: absolute ;left: 35em;top: 5em;"  onclick="toggle_visible('formInsert');toggle_visible('resultInsert');"> -->
<!-- 				新增縮放 -->
<!-- 			</button> -->
<!-- 			<button style="position: absolute ;right: 45em;top: 5em;"  onclick="toggle_visible('resultIndex');"> -->
<!-- 				搜尋縮放 -->
<!-- 			</button> -->
	<Form Action="Javascript:%200" id="formInsert" >
	
			<table id="insertTable">
		
			<TR>
				<TD colspan="2">新增會員</TD>
			
			</TR>
			<TR>
				<TD>會員帳號</TD>
				<TD align="center"><input type="email" name="Username"
					id="Username" value="leo@yahoo.com.tw"></TD>
			</TR>
			<TR>
				<TD align="center">會員密碼</TD>
				<TD align="center"><input type="password" name="Password"
					value="abc123"></TD>
			</TR>
			<TR>
				<TD align="center">密碼確認</TD>
				<TD align="center"><input type="password" name="Password2"
					value="abc123"></TD>
			</TR>
			<TR>
				<TD align="center">會員姓名</TD>
				<TD align="center"><input type="text" name="Name" value="史努比"></TD>
			</TR>
			<TR>
				<TD align="center">會員手機</TD>
				<TD align="center"><input type="text" name="Cellphone"
					value="0999-000-999"></TD>
			</TR>
			<TR>
				<TD align="center">會員生日</TD>
				<TD align="center"><input type="text" name="Birthday"
					value="2000-01-01"></TD>
			</TR>
			<TR>
				<TD colspan="2"> <br></TD>
			</TR>

			<TR>
				<TD colspan="1">
					<button onclick="IndexMember.jsp">						
						<font color="red">
						取消新增
						</font>
					</button>
				</TD>
				<TD colspan="1">
					<Button id="submitinsert" onclick="setInsertData('Username','Insert','resultInsert'); getQueryData('M_Username','Select','resultIndex','result','M_Username');">
						<font color="#018bbd">
						確認新增
						</font>
					</Button>
				</TD>
			</TR>

		</table>

	</Form>
<!-- 	<div id="resultIndex"></div> -->
	<div id="resultInsert" style="bgcolor:white;position:fixed;"></div>
		

</body>

</html>
