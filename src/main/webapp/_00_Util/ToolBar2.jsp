<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="SystemMain">
	<table class="SystemTitle">
		<tr>
			<td> </td>
			<td>資料管理系統</td>
			<td><a href="../_00_Login/logout.jsp">登出</a></td>
		</tr>
	</table>
	<table class="menuBar">
		<tr>
			<td>
				<ul class="drop-down-menu">
					<li><a href="#" data-toggle="dropdown">基本資料管理 <b
							class="caret"></b></a>
						<ul>
							<li ><a href="#tab-product" onclick="getAction('IndexProduct2.jsp','loadPageDiv');getQueryData('SelectProduct.do');">產品資訊</a>
								<ul>
									<li><a href="#">子功能1</a></li>
								</ul>
							</li>
<!-- 							<li><a href="#tab-Taste" onclick="getAction('../_02_Taste/IndexTaste.jsp','loadPageDiv');getQueryData('../_02_Taste/SelectTaste.do');">口味資訊</a> -->
							<li><a href="../_14_Member/IndexMember.jsp" onclick="">會員系統</a>
						</ul>
					<li>
				</ul>
			</td>
			<td>
				<ul class="drop-down-menu">
					<li><a href="#" data-toggle="dropdown">進銷存管理系統 <b
							class="caret"></b></a>
						<ul>
							<li><a href="" class="">功能1</a>
							<li><a href="" class="">功能2</a>
							<li><a href="" class="">功能3</a>
						</ul>
					<li>
				</ul>
			</td>
			<td>
				<ul class="drop-down-menu">
					<li><a href="#" data-toggle="dropdown">購物車訂單管理系統 <b
							class="caret"></b></a>
						<ul>
							<li><a href="" class="">功能1</a>
							<li><a href="" class="">功能2</a>
							<li><a href="" class="">功能3</a>
						</ul>
					<li>
				</ul>
			</td>
		</tr>
	</table>
</div>
