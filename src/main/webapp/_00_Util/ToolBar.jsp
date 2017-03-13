<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/toolBar.css">
<script
	src="${pageContext.request.contextPath}/jQuery/jquery-1.12.4.min.js"
	type="text/JavaScript"></script>

<div class="SystemTitle">
	<strong>資料管理系統</strong>

	<div class="container-fluid" id="toolBar">
		<span class="nav navbar-nav navbar" id="btn-left">
			<button class="information"></button>
			<button class="insert">
<!-- 				onclick="getAction('InsertProduct.jsp','showDAOJsp');"> -->
			</button>
			<button class="delete">
<!-- 			onclick="setDeleteData('DeleteServlet','showDAOJsp');"> -->
<!-- 				onclick="getAction('DeleteProduct.jsp','showDAOJsp');"> -->
			</button>
			<button class="update"
				onclick="getAction('UpdateProduct.jsp','showDAOJsp');">
				</button>
			<button class="select"
				onclick="getAction('SelectProduct.jsp','showDAOJsp');"></button>
			<button class="refresh" 
				onclick="location.href='http://localhost:8080/Java004NO1/_01_ProductTest/IndexProduct.jsp'"></button>
			<button class="export" onclick=""></button>
			<button class="import" 
				onclick="getAction('ImportProduct.jsp','showDAOJsp');"></button>
			<button class="printer" onclick=""></button>
			
			
		</span> <span class="nav navbar-nav navbar-right" id="btn-right">
			<button class="forward" onclick=""></button>
			<button class="back" onclick=""></button>
			<button class="next" onclick=""></button>
			<button class="rewind" onclick=""></button>
		</span>
		<ul class="drop-down-menu">
			<li><a href="#" data-toggle="dropdown">選單 <b class="caret"></b></a>
				<ul>
					<li><a href="#tab-product" class="InsertProduct.jsp">產品資訊</a>
						<ul>
							<li><a href="#">子功能1</a></li>
						</ul></li>
					<li><a href="#tab-Taste" class="../_02_Taste/IndexTaste.jsp">口味資訊</a>
					<li><a href="#tab-member" class="../_14_Member/IndexMember.jsp">會員系統</a>
				</ul>
			<li>
		</ul>
	</div>
</div>
