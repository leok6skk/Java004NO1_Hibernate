<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta name="viewport" content="width=device-width, initial-scale=1"
	charset="UTF-8">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<link rel="stylesheet" href="../asset/css/bootstrap.min.css">
<link rel="stylesheet" href="../asset/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/member/member2.css?110">



<title>會員管理首頁</title>
</head>
<body>

	<header class="container-fuild">

		<div class="row">

			<h4 class="text-center" id="indexheader">
				<strong>資料管理系統</strong>
				<a href="../_00_Login/logout.jsp" style="position: absolute;right:10em;color:white;">登出</a>
			</h4>
			
		</div>
<!-- 				<div> -->
<%-- 					<jsp:include page='../_00_Util/IndexMain.jsp' /> --%>
<!-- 				</div> -->

	</header>

	<section class="container-fuild" id="portfolio">

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="nav navbar-nav" id="buttons">
					<section class="container-fuild" id="about"></section>
					<button id='buttonremark'>
						<br>說明

					</button>
					<button
						onclick="IndexMember.jsp'">

						<br>首頁

					</button>

					<button onclick="ajaxButtonTag('InsertMember.jsp','insertIndex');"
						id='buttoninsert'>
						<img src="../image/insert.png"><br>新增

					</button>
					<button onclick="updateData();" id='buttonupdate'>
						<img src='../image/update.png'><br>修改

					</button>
					<button id='buttondelete'>
						<img src='../image/delete.png'><br>刪除

					</button>

				</div>
				<Form id="formSelect">

					輸入帳號查詢: <input type="text" name="Username" id="M_Username" value=""
						size="20" placeholder="不輸入搜尋全部" />
		
					<input type="text" name="pageNo" id="pageNo" value="1" />


					<button type="submit" id="buttonsearch" ><img src="../image/search.png"></button>
				

					<div id="sqlResult"></div>

				</Form>
			</div>
		</nav>
	</section>
	<div id="pageControl">
		<button id="pageBack" onclick="pageBack();">
			<img src="../image/back.png" style="width: 2.5em; height: 1.5em;">

		</button>

		<input type="text" name="totalPages" id="totalPages" value="0"
			readonly="readonly" />

		<button id="pageNext" onclick="pageNext();">
			<img src="../image/next.png" style="width: 2.5em; height: 1.5em;">

		</button>
	</div>

	<section class="container-fuild" id="resultIndex"></section>
	<section class="container-fuild" id="insertIndex"></section>






	<footer class="container-fuild">我是footer</footer>


	<script src="../js/jquery-3.1.1.min.js"></script>
	<script src="../js/jquery.form.js"></script>
	<script src="../asset/js/bootstrap.min.js"></script>
	
	<script src="../js/member/insert.js?v0001"></script>
	<script src="../js/member/delete.js?v08"></script>
	<script src="../js/member/select.js?v04"></script>
	<script src="../js/member/update.js?v014"></script>
	<script src="../js/member/member.js?v014"></script>

</body>
</html>