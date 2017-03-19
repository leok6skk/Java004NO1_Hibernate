<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/product_main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/tab_main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/toolBar.css">


<title>work</title>
</head>
<body onload="getQueryData('SelectProduct.do');">
	
	<!-- 插入工具列 -->
	<div>
		<jsp:include page='../_00_Util/ToolBar.jsp' />
	</div>
	<!-- /插入工具列 -->
	
	<!-- 頁籤與相對應之頁面-->
	<div class="abgne_tab">
		<ul class="tabs">
			<li><a href="#product1">資料表 <i><img id="cross"></i></a></li>
		</ul>
		<div class="tab_container">
			<div id="product1" class="tab_content">
				<section class="container-fuild" id='showDAOJsp'>
					<h4>請選擇功能</h4>
				</section>
				<section class="container-fuild" id='showResult'>
				</section>
			</div>
		</div>
	</div>
	<!-- 插入工具列 -->
</body>
<script src="${pageContext.request.contextPath}/jQuery/jquery-1.12.4.min.js" type="text/JavaScript"></script>
<script src="${pageContext.request.contextPath}/js/product_new.js" type="text/JavaScript"></script>

</html>