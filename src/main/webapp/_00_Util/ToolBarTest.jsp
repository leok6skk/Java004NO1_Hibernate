<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/toolBarTest.css?v2">
<script src="${pageContext.request.contextPath}/jQuery/jquery-1.12.4.min.js" type="text/JavaScript"></script>

<div class='SystemTitle'>
	<strong>資料管理系統</strong>
</div>

<div class="toolBar">
		<ul class="drop-down-menu">
				<li><a href="#" data-toggle="dropdown">選單 <b class="caret"></b></a>
					<ul>
						<li><a href="#" class="SelectProduct.jsp">產品資訊</a>
							<ul>
								<li><a href="#">子功能1</a></li>
							</ul>
						</li>
						<li><a href="#" class="#">會員系統</a>
							<ul>
								<li><a href="#">子功能1</a></li>
							</ul>
						</li>
					</ul>
				<li>
			</ul>

		


	<span class="span-btn-right"> <input type='button' id='none'
		value="首頁"> <input type='button' id='none' value="上頁">
		<input type='button' id='none' value="下頁"> <input
		type='button' id='none' value="尾頁">
	</span>
</div>

