<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- <link rel='stylesheet' href='${pageContext.request.contextPath}/css/product_main2.css' type="text/css" /> --%>
<%-- <script src="${pageContext.request.contextPath}/js/product_new2.js" type="text/JavaScript"></script> --%>

<Form Action="Javascript:%200">	
	<div id="updateTable">
		產品序號：<input type="text" name="productId" value="" disabled/>
		產品定價：<input type="text" name="PGPrice" value=""/>
		產品品名：<input type="text" name="name" value=""/>
		產品成本：<input type="text" name="avgCost" value=""/>
		產品生產地：<input type="text" name="oPlace" value=""/>
		產品保存期：<input type="text" name="sLife" value=""/>
		產品供應商：<input type="text" name="suppierId" value=""/>
	</div>
	<div>
		<button onclick="getData();">選取該筆資料</button>
		<input type="submit" value="提交" onclick="getUpdateData('UpdateProduct.do');"/>
		<div id="updateResult"></div>
	</div>
</Form>	