function indexdofirst(){

//	getQueryDataLimit('LimitSelect','resultIndex','M_ID');
	getQueryData('M_Username','Select','resultIndex','result','M_Username');
	
	document.getElementById('buttonremark').onclick = function(){
		alert("remark");
	}
	
	totalPages('TotalPages');
//	document.getElementById('buttonsearch').onclick = getQueryData('M_Username','Select','resultIndex','result','M_Username');

//	document.getElementById('buttondelete').onclick = setDeleteData('Delete','Username','resultIndex','LimitSelect','resultLimit');


}


//-------------------------------------------------------

function selectMenu(e) {
	window.open(e.options[e.selectedIndex].value);
}

////-------------------------------------------------------

function ajaxButtonTag(sendJsp, tag) {

	var tagId = document.getElementById(tag);
	// 步驟一: 新建XMLHttpRequest物件
	var xhr = new XMLHttpRequest();
	// 步驟二: 經由AJAX提出HTTP請求
	if (xhr != null) {
		xhr.onreadystatechange = function() {
			// 步驟三: 處理伺服器送回的回應資料
			if (xhr.readyState == 4 && xhr.status == 200) {
				tagId.innerHTML =  xhr.responseText;
			}
		}
		xhr.open('POST', sendJsp, true);
		xhr.send();
	} else {
		tagId.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
	}
}



////-------------------------------------------------------




function setQueryString(formId) {
	queryString = "";
	//alert(formId);
	var frm = document.forms.namedItem(formId);
	var numberElements = frm.elements.length;
	for (var i = 0; i < numberElements; i++) {
		if (i < numberElements - 1) {
			            	//alert(frm.elements[i].name);
			            	//alert(frm.elements[i].value);
			queryString += frm.elements[i].name + "="
					+ encodeURIComponent(frm.elements[i].value) + "&";
		} else {
			queryString += frm.elements[i].name + "="
					+ encodeURIComponent(frm.elements[i].value);
		}

	}
	return queryString;
}



function totalPages(servelet){
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", servelet, true);//send要傳參數一定要用POST
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	xhr.send();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var validation_messages = xhr.responseText;//由servelet傳過來JSON格式的資料		
			
			document.getElementById("totalPages").value = validation_messages;
		}
	}
}


function pageBack(){
	
	var pageNoId = document.getElementById("pageNo");	
	var num =  Number(pageNoId.value);
	
	
	if(num >=2 ){
		pageNoId.value = num-1;
	}
	
	getQueryData('M_Username','Select','resultIndex','result','M_Username');
}

function pageNext(){
	
	var pageNoId = document.getElementById("pageNo");
	var num =  Number(pageNoId.value); 
	
	var total =  Number(document.getElementById("totalPages").value);
	
	if(num < total && total>=2){
		pageNoId.value = num+1;
	}
	
	getQueryData('M_Username','Select','resultIndex','result','M_Username');
}


//----------------------------------------------------



window.addEventListener('load',indexdofirst,false);
