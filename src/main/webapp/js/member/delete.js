function setDeleteData(servelet, div) {

	// JS寫法

	// var obj=document.getElementsByName("member");
	// //<input type = 'radio' name = 'member' value ='帳號'>
	// var selected;
	// for (var i=0; i<obj.length; i++) {
	// if (obj[i].checked) {
	// //如果被選取了
	//	    	
	// selected = obj[i].value;
	// break;//只能單選
	// }
	// }

	
	// JQuery寫法

	var getName = $('input:checked').attr('name');
	var selected = $("input[name=" + getName + "]:checked").val();

	//----------------------------------------------------------
	
	if (selected == null) {

		alert("請先選取要刪除的資料");
		return false;
	} else {
		if (confirm("確定要刪除" + selected + "嗎?")) {

			var idValue = selected;
			var divId = document.getElementById(div);// result

			var xhr = new XMLHttpRequest();
			xhr.open("POST", servelet, false);// send要傳參數一定要用POST
			xhr.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");

			var queryString = "Username=" + selected;
			xhr.send(queryString);

			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {

					var validation_messages = JSON.parse(xhr.responseText);// 由servelet傳過來JSON格式的資料
					alert('delete');
					if (validation_messages != "true") {
						var content = "<font color='red' weight='bold' size='3em'>";
						// content += "<center>";

						content += "刪除 " + idValue + " 發生錯誤 !!";

						// content += "</center>";
						content += "</Font>";

					} else {
						// 刪除成功

						var content = "<font color='#ffc526' weight='bold' size='3em'>";
						content += "刪除 " + idValue + " 成功";
						content += "</center>";
						content += "</Font>";

					}
					
					alert(context);
					divId.innerHTML = content;
					// idValue = "";
				} else{					
					return;
				}
			}

		} else {
			return;
		}

	}
}








