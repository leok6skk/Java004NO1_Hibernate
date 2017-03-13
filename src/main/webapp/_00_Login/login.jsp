<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../asset/css/bootstrap.min.css">
<link rel="stylesheet" href="../asset/css/bootstrap-theme.min.css">
<title>登錄</title>
</head>
<body style="background-color: #444444;">


	<div class="col-md-8" style="position: absolute; left: 20em; top: 10em">
		<Form Action="<c:url value='/_00_Login/Login.do' />" method="POST">

			<table class="table table-hover sm-text"
				style="background: #fff; font-size: 1.25em; text-align: left; border-radius: 0.75em; box-shadow: 10px 10px 5px #888888;">
				<tr>
					<td
						style="border-radius: 0.75em; padding: 0.25em 1em; border: none;">
						<div class="form-group" style="padding: 0.25em 1em; border: none;">

							<h4>
								<strong>管理員帳號</strong>&nbsp;&nbsp;<small><Font
									color='red' size="5"><strong></strong></Font></small>
							</h4>
							<br> 
							<input type="text" class="form-control" name="userId"
								value="" placeholder="user1"
								style="font-size: 1em; font-family: 微軟正黑體;">
							<br>
							<small><Font color='red' size="-1">${ErrorMsgKey.AccountEmptyError}</Font></small>
						</div>
					</td>
					
				</tr>
				<tr>
					<td
						style="border-radius: 0.75em; padding: 0.25em 1em; border: none;">
						<div class="form-group" style="padding: 0.25em 1em; border: none;">

							<h4>
								<strong>管理員密碼</strong>&nbsp;&nbsp;<small><Font
									color='red' size="5"><strong></strong></Font></small>
							</h4>
							<br> <input type="password" name="password" value=""
								class="form-control" id="exampleInputPassword1"
								placeholder="123" style="font-size: 1em; font-family: 微軟正黑體;">
							<br>
							<small><Font color='red' size="-1">${ErrorMsgKey.PasswordEmptyError}</Font></small>
						</div>
					</td>
					
						
					
				</tr>

				<TR>
					<TD align="CENTER" colspan='3'><Font color='red' size="-1">${ErrorMsgKey.LoginError}&nbsp;</Font></TD>

				</TR>

				<tr>
					<td
						style="padding: 1em 1.5em; padding-top: 2em; border-radius: 0.75em; border: none; text-align: center"><input
						type="submit" value="登入" class="btn btn-warning login-button"
						style="font-size: 1.25em; width: 8em;"></td>


				</tr>
			</table>
		</form>
	</div>
</body>



</html>
