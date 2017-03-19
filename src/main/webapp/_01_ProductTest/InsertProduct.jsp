<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- <html> -->
<!-- <head> -->
<!-- <link rel='stylesheet' -->
<!-- 	href='${pageContext.request.contextPath}/css/product_main2.css' -->
<!-- 	type="text/css" /> -->

<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <title>MVC</title> -->
<!-- </head> -->
<!-- <body> -->


<Form name="form1" id="form1" action="InsertProduct2.do" method="post" enctype="multipart/form-data">

	產品序號： <input type="text" name="productId" value="001"> 
	產品定價： <input type="text" name="PGPrice" value="500"> 
	產品品名： <input type="text" name="name" value="羊咩咩羊肉爐"> 
	產品成本： <input type="text" name="avgCost" value="300"> 
	產品生產地： <input type="text" name="oPlace" value="台灣台北"> 
	產品保存期： <input type="text" name="sLife" value="360"> 
            產品供應商： <input type="text" name="suppierId" value="A"> 
            <input type="file" name="fileName" id=ProductPic size="40" required>
	 <input type="submit" name="upload" id="upLoadPic" value="提交">
</Form>
	<div>
		<div id="insertResult"></div>
	</div>

<!-- </body> -->
<!-- </html> -->
