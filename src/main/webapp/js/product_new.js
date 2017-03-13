

//----------<Tab功能>----------
//選取下拉選單時,新增呼叫的網頁至頁籤--------目前無使用
//$(function(){
//	$('ul.drop-down-menu ul li').click(function(){
//	var $newTab = $(this);
//	var getJspLink = $($newTab).find('a').attr('class'); //讀取該筆下拉選單的網頁超連結
//	var getHref = $($newTab).find('a').attr('href'); //讀取點擊到的選單的Href,用來產生tab的Herf
//	var setTabId= getHref.substr(1); //去掉_getHref的#,用來產生div的id
//	
//		if($(getHref).length > 0){
//			alert('網頁已存在');
//
//		}else{
//			//最後一個li後面產生新頁籤
//			$('ul.tabs li:last').after("<li><a href="+getHref+"> 123 <i><img id=cross></i></a></li>");
//				//最後一個div後面產生新的div
//			$('div.abgne_tab div:last').after("<div id="+setTabId+" class=tab_content ></div>");
//			//將畫面載入新的div #id 且 _getHref內
//			$(getHref).load(getJspLink);			
//		}		
//	});
//});	

//點擊Tab時切換畫面至被點擊的頁籤-----------------------------
$(function(){
	// 預設顯示第一個 Tab
	var _showTab = 0;
	$('.abgne_tab').each(function(){
		// 目前的頁籤區塊
		var $tab = $(this);
		var $defaultLi = $('ul.tabs li', $tab).eq(_showTab).addClass('active');
		$($defaultLi.find('a').attr('href')).siblings().hide();
 
		// 當 li 頁籤被點擊時...
		// 若要改成滑鼠移到 li 頁籤就切換時, 把 click 改成 mouseover
		$('ul.tabs li', $tab).click(function() {
			// 找出 li 中的超連結 href(#id)
			var $this = $(this),_clickTab = $this.find('a').attr('href');
			// 把目前點擊到的 li 頁籤加上 .active, 並把兄弟元素中有 .active 的都移除 class
			$this.addClass('active').siblings('.active').removeClass('active');
			// 淡入相對應的內容並隱藏兄弟元素
			$(_clickTab).stop(false, true).fadeIn().siblings().hide();
 
			return false;
		}).find('a').focus(function(){
			this.blur();
		});
	});
});

//刪除Tab並跳回第一頁------------------------------------------------------
$(function(){
	//點擊X觸發事件
	$('ul.tabs li a i').click(function(){
		//找出對應的div#id並刪除
		var _getHerf = $(this).parent().attr('href');
		//找出被點擊X所對應的li並刪除
		$(this).parent().parent().remove();
		$(_getHerf).remove();
		//此語法會找出第一個a連結內的herf
		var _getfFstHerf = $('a').attr('href'); 
		//顯示找到的herf(此連結是連到div#id),顯示此id對應的div並隱藏其他div
		$(_getfFstHerf).stop(false, true).fadeIn().siblings().hide();
		//將預設顯示的li設為index=0(第一個li)顯示
		$('.abgne_tab').each(function(){
		var $tab = $(this),$defaultLi = $('ul.tabs li', $tab).eq(0).addClass('active');
		$($defaultLi.find('a').attr('href')).siblings().hide();
		});
    });
});

//----------</Tab功能>----------

//----------<Ajax新增改查功能>----------
//Insert:新增該筆資料,並由Servelet回傳是否成功的json字串,再顯示至畫面----------------
function getInsertData(servelet) {	
		var xhr = new XMLHttpRequest();
		xhr.open("POST", servelet, true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send(setQueryString());

		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var data = JSON.parse(xhr.responseText);
				var result = document.getElementById("insertResult");
				result.innerHTML = data;
		getQueryData('SelectProduct.do');
			}
		}
	}


//載入頁面替換Section內容----------------------------------------------
function getAction(action, tagId) {
	var showResult = document.getElementById(tagId);
	var xhr = new XMLHttpRequest(); // 步驟一: 新建XMLHttpRequest物件
	if (xhr != null) { // 步驟二: 經由AJAX提出HTTP請求
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) { // 步驟三: 處理伺服器送回的回應資料
				showResult.innerHTML = xhr.responseText ;
			}
		}
		xhr.open("POST", action, true);
		xhr.send();
	} else {
		showResult.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
	}
}

//Select讀取透過Servelet取出的Json資料,替換Section內容------------------------------
function getQueryData(servelet) {
	if(document.getElementById("productId")){
		var productId = document.getElementById("productId").value;
	}else{
		var productId = "";
	}
	var xhr = new XMLHttpRequest();
	xhr.open("POST", servelet, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("productId=" + productId);
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var content = "<table>" + "<tr><td></td>" + "<td>序號</td>"
					+ "<td>定價</td>" + "<td>名稱</td>" + "<td>成本</td>"
					+ "<td>生產地</td>" + "<td>保存期</td>" + "<td>供應商</td></tr>";

			var data = JSON.parse(xhr.responseText);
			for (var i = 0; i < data.length; i++) {
				content += "<tr><td><input type=radio name=productId value=" + data[i].productId +" onclick=radCheck(this);></td>"
						+ "<td>" + data[i].productId + "</td>"
						+ "<td>" + data[i].pgPrice   + "</td>"
						+ "<td>" + data[i].name      + "</td>"
						+ "<td>" + data[i].avgCost   + "</td>"
						+ "<td>" + data[i].oplace    + "</td>"
						+ "<td>" + data[i].slife     + "</td>" 
						+ "<td>" + data[i].suppierId + "</td></tr>";
			}
			content += "</table>";
			var result = document.getElementById("showResult");
			result.innerHTML = content;
		}
	}
}

//Delete:判斷讀取到的name並取出值,判斷是否刪除該筆資料,並由Servelet回傳是否成功的json字串,再顯示至畫面--------
$(function(){
$('.delete').click(function(){
	var setServlet;
	var getName = $('input:checked').attr('name');
	var selected = $("input[name="+getName+"]:checked").val();
	if(getName == "productId"){
		setServlet="DeleteProduct.do";
	} else if(getName == "tasteId"){
		setServlet="DeleteTaste.do";
	} else if(getName == "member"){
		setServlet="";
	}
		 if (selected!=null) { //如果有被選取,不是空值	 
//			$('input[name=productId]:checked').parent().parent().addClass('highlight')
//				.siblings().removeClass('highlight');
			 if (confirm("確定要刪除"+selected+"嗎?")) {
				 var xhr = new XMLHttpRequest();
					xhr.open("POST", setServlet , true);// send要傳參數一定要用POST
					xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
					xhr.send(getName+"="+selected);
					xhr.onreadystatechange = function() {
						if (xhr.readyState == 4 && xhr.status == 200) {
							var data = JSON.parse(xhr.responseText);
							var result = document.getElementById("showDAOJsp");
							result.innerHTML = "<h3>" + data + "<h3>";
					getQueryData('SelectProduct.do');
						}
					}
			 	}
		 }else{
		 		alert("請選勾選要刪除的資料");
		 } 
	});
});

//Update:取出被點選的radio內的值,並傳到updata畫面內對應的input:value內
function getData() {
	var setServlet;
	var getName = $('input:checked').attr('name');
	var selected = $("input[name="+getName+"]:checked").val();
	 	
		 if (selected!=null) { //如果有被選取,不是空值	
			
			 if (confirm("確定要選取"+selected+"嗎?")) {
				var TextArray = new Array();
				for(i=1; i< $('.highlight > td').size();i++){
					TextArray[i] = $(".highlight > td:eq("+i+")").text();
				}

				for(i=0; i<= $('#updateTable :input').size();i++){
					$("#updateTable input:eq("+i+")").val(TextArray[i+1]);
				}
			 }
		 }else{
		 		alert("請選勾選要更新的資料");
	} 
}

function getUpdateData(servelet) {	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", servelet, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(setQueryString());

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = JSON.parse(xhr.responseText);
			var result = document.getElementById("updateResult");
			result.innerHTML = data;
	getQueryData('SelectProduct.do');
		}
	}
}
//----------</Ajax新增改查功能>----------

//Insert跟Update時使用的方法,會取出Form內每個name的value值----------------
function setQueryString() {
	queryString = "";
	var frm = document.forms[0];
	var numberElements = frm.elements.length;
	for (var i = 0; i < numberElements; i++) {
		if (i < numberElements - 1) {
			//            	alert(frm.elements[i].name);
			//            	alert(frm.elements[i].value);
			queryString += frm.elements[i].name + "="
					+ encodeURIComponent(frm.elements[i].value) + "&";
		} else {
			queryString += frm.elements[i].name + "="
					+ encodeURIComponent(frm.elements[i].value);
		}
	}
	return queryString;
}


//被點選的Radio改變背景顏色-------------------------
function radCheck(obj) {
	$('input:radio').change(function() {
		//$(this).parent().toggleClass("highlight");//切換背景色彩
		if ( $(this).is(':checked')) {//判斷checkbox是否勾選
			$(this).parent().parent().addClass('highlight').siblings()
				.removeClass('highlight');//被點擊的增加CSS樣式並移除其他radio的CSS樣式
		}
	});
}

//點擊insert按鈕跳出新頁籤-------------------------
$(function(){
	$('.insert').click(function(){
		var tab = "#tab-insert";
		if($(tab).length > 0){
			alert('網頁已存在');
		}else{
			//最後一個li後面產生新頁籤
			$('ul.tabs li:last').after("<li><a href=#tab-insert> 新增資料 <i><img id=cross></i></a></li>");
				//最後一個div後面產生新的div
			$('#product1').after("<div id=tab-insert class=tab_content ></div>");
			//將畫面載入新的div
			$('#tab-insert').load('InsertProduct.jsp');				
			// 把目前點擊到的 li 頁籤加上 .active, 並把兄弟元素中有 .active 的都移除 class
//			$('ul.tabs li:last').addClass('active').siblings('.active').removeClass('active');
//			// 淡入相對應的內容並隱藏兄弟元素		
//			$('#tab-insert').stop(false, true).fadeIn().siblings().hide();
		}	
	});
});	



//點擊insert頁籤時,隱藏其他按鈕-------------------------
$(function(){
	  $("[href='#tab-insert']").click(function () {
			  $('.insert,.delete ,.select,.update,.export,.import,.printer').hide();
	});
});

//點擊主頁頁籤時,顯示其他按鈕-------------------------
$(function(){
	  $("[href='#product1']").click(function () {
			  $('.insert,.delete ,.select,.update,.export,.import,.printer').show();
	});
});

//以下功能無使用------------------------------------------------------

//Import選取要寫入的檔案----------------
//$(function(){
//	$('#importProduct').change(function(){
//		$('#importBtn').removeAttr('disabled');
//	});
//});
//----------</Ajax呼叫物件功能>----------

//----------<>----------
//$(function(){
//	
//	
//});

//點擊Text改變背景顏色------------------------------------------------------
//$(function(){
//$(':text').focus(function(){
//	$(this).css('background-color','yellow')
//			.css('font','normal 20px Tahoma');
//	});
//	$(':text').blur(function(){
//		$(this).css('background-color','#fff')
//				.css('font','normal 16px Tahoma');
//	});						
//});

//舊功能Delete:在text內輸入序號並判斷是否刪除該筆資料,由Servelet回傳是否成功的json字串,再顯示至畫面----------------
//function setDeleteData(servelet) {	
//	var productId = document.getElementByName("productId").value;
//	if((confirm("確定要刪除資料"+ productId +"嗎")))
//	var xhr = new XMLHttpRequest();
//	xhr.open("POST", servelet, true);
//	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//	xhr.send("productId=" + productId);
//		xhr.onreadystatechange = function() {
//			if (xhr.readyState == 4 && xhr.status == 200) {
//				var data = JSON.parse(xhr.responseText);
//				var result = document.getElementById("showDAOJsp");
//				result.innerHTML = data;
//		}
//	}
//}

//舊功能Delete判斷是否刪除該筆資料,並由Servelet回傳是否成功的json字串,再顯示至畫面----------------
//function setDeleteData(servelet, div) {
//	var obj=document.getElementsByName("productId");
//	var selected;
//	  for (var i=0; i<obj.length; i++) {
//	    if (obj[i].checked) { //如果被選取了	    	
//	    	 selected = obj[i].value;
//	      }
//	    }
//	if (selected == null) {
//		alert("請選勾選要刪除的資料");
//		return;
//	} else {
//		if (confirm("確定要刪除"+selected+"嗎?")) {	
//			var xhr = new XMLHttpRequest();
//			xhr.open("POST", servelet, true);// send要傳參數一定要用POST
//			xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//			xhr.send("productId="+selected);
//			xhr.onreadystatechange = function() {
//				if (xhr.readyState == 4 && xhr.status == 200) {
//					var data = JSON.parse(xhr.responseText);
//					var result = document.getElementById("showDAOJsp");
//					result.innerHTML = "<h3>" + data + "<h3>";
//			getQueryData('SelectServlet');
//				}
//			}
//		}
//	}
//}
//------------------------------------------------------