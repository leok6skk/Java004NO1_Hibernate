<!DOCTYPE>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/login_and_register.css?v1">
<title>registered</title>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="shop_index.html">購物平台</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse "
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">麵類<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">牛肉類</a></li>
							<li class="divider"></li>
							<li><a href="#">豬肉類</a></li>
							<li class="divider"></li>
							<li><a href="#">雞肉類</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">飯類<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">牛肉類</a></li>
							<li class="divider"></li>
							<li><a href="#">豬肉類</a></li>
							<li class="divider"></li>
							<li><a href="#">雞肉類</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">零嘴類<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">牛肉類</a></li>
							<li class="divider"></li>
							<li><a href="#">豬肉類</a></li>
							<li class="divider"></li>
							<li><a href="#">雞肉類</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">會員管理</a></li>
					<li><a href="login_and_register.jsp">登入/註冊</a></li>
					<li><a href="cartEdit.html">購物車</a></li>
					<li><a href="index.html">觀光工廠</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>




	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">會員登入</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">會員註冊</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<div class="wrapper">

									<form id="login-form"
										Action="<c:url value='/WebShop/LoginMember' />" method="post"
										role="form" style="display: block;">

										<h3 class="form-signin-heading">歡迎回來! 請先登入!</h3>
										<hr class="colorgraph">
										<br> <input type="text" class="form-control"
											name="Username" id="Username" placeholder="帳號"
											value="${param.Username}" />

										<div class="form-group text-center" style="color: #FF0000;">
											${ErrorMsgKey.AccountEmptyError}<br>
										</div>

										<input type="password" class="form-control" name="Password"
											id="Password" placeholder="密碼" value="${param.Password}" />

										<div class="form-group text-center" style="color: #FF0000;">
											${ErrorMsgKey.PasswordEmptyError}<br>
										</div>

										<div class="form-group text-center">
											<input type="checkbox" tabindex="3" class="" name="remember"
												id="remember"> <label for="remember">
												Remember Me</label>
										</div>

										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<button class="btn btn-lg btn-primary btn-block"
														name="Submit" value="Login" type="Submit">Login</button>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-lg-12">
													<div class="text-center">
														<a href="http://phpoll.com/recover" tabindex="5"
															class="forgot-password">忘記密碼?</a>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group text-center" style="color: #FF0000;">
											${ErrorMsgKey.LoginError}<br>
										</div>

									</form>




									<form id="register-form" method="post" role="form"
										style="display: none;">
										<!-- 									<form class="form-horizontal" role="form"> -->


										<div class="form-group">
											<label for="text" class="col-sm-3 control-label">會員帳號</label>
											<div class="col-sm-8">
												<input type="text" id="member_Username" placeholder="4~20個英數或底線組成的字元"
													class="form-control">

												<div class="form-group text-center" id='usernameCheckResult'
													style="height: 2em;">
													</div>


											</div>
										</div>
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">會員密碼</label>
											<div class="col-sm-8">
												<input type="password" id="Password" placeholder="6～20個數字和英文組成的字元"
													class="form-control" required pattern="(?=^.{6,20}$)(?=.*[a-zA-Z])(?=.*[0-9])(?!.*\s).*$"
													oninvalid="this.setCustomValidity('6～20個數字和英文組成的字元')"
													oninput="setCustomValidity('')">

											</div>
											<br>
										</div>
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">密碼確認</label>
											<div class="col-sm-8">
												<input type="password" id="Password2" placeholder="再輸入一次密碼"
													class="form-control" required="required" required pattern="$(#Password).val()"oninvalid="this.setCustomValidity('必須和密碼相同')"
													oninput="setCustomValidity('')">
											</div>
											<br>
										</div>
										<div class="form-group">
											<label for="Name" class="col-sm-3 control-label">會員姓名</label>
											<div class="col-sm-8">
												<input type="text" id="Name" placeholder=""
													class="form-control" autofocus required="required">
											</div>
											<br>
										</div>
										
										<div class="form-group">
											<label for="EMail" class="col-sm-3 control-label"><br>電子信箱</label>
											<div class="col-sm-8">
												<br>
												<input type="email" id="EMail" placeholder="example@abc.com.tw"
													class="form-control" required pattern="^[^\s]+@[^\s]+\.[^\s]{2,3}$"
													oninvalid="this.setCustomValidity('EMail格式錯誤')"
													oninput="setCustomValidity('')" autofocus required="required">
											</div>
											<br> 
										</div>
										<div class="form-group">
											<label for="birthday" class="col-sm-3 control-label"><br>會員生日</label>
											<div class="col-sm-8">
												<br>
												<input type="date" name="birthday" id="birthday" class="form-control" oninvalid="this.setCustomValidity('生日輸入不完整')"
													oninput="setCustomValidity('')" autofocus required="required">
											</div>
											<br> 
										</div>
											


										<div class="form-group">
											<div class="col-sm-8 col-sm-offset-3">
												<div class="checkbox">
													<label> 
													<br>
													<input type="checkbox" required="required"> <span>我已仔細閱讀並明瞭
															「<a href="#">網站使用條款</a>」、 「<a href="#">隱私權政策</a>」、 「<a
															href="#">免責聲明</a>」
															等所載內容及其意義，茲同意該等條款規定，並願遵守網站現今、嗣後規範的各種規則。
													</span>
													</label>
												</div>
											</div>
										</div>
										<!-- /.form-group -->
										<div class="form-group">
											<div class="col-sm-6 col-sm-offset-3">
												<button type="submit" class="btn btn-primary btn-block">註
													冊</button>
											</div>
										</div>
									</form>
									<!-- /form -->
								</div>
								<!-- ./container -->


							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/login_and_register.js"></script>
</body>

</html>