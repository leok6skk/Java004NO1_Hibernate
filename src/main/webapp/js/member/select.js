function getQueryData(input,servelet,successdiv,errordiv,first) {
	
	//alert("getQueryData "+input+" "+servelet+" "+div);
	var username = document.getElementById(input).value;
	var successID = document.getElementById(successdiv);
	var errorID = document.getElementById(errordiv);
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", servelet, true);//send要傳參數一定要用POST
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	var queryString = setQueryString('formSelect');
	//alert(queryString);
	xhr.send(queryString);

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var validation_messages = JSON.parse(xhr.responseText);//由servelet傳過來JSON格式的資料		
			
			if(validation_messages == null){//找不到
				var content="";
				content += '<div class="alert alert-danger" role="alert" style="positive:absolute;margin-top:1em;">';
				content += '<a href="#" class="alert-link">';				
//				content +=	"<font color='#ffc526' weight='bold' size='3em'>"; 
				content += username +" 找不到!";
//				content += "</Font>";
				content += "</a></div>";
				errorID.innerHTML = content;
				return;
			}
			var content = "";
			
//			content += "<h3>搜尋結果<br></h3>";
			content += "<form id='queryData'>";
			content += "<table>";

			//欄位名稱
			for ( var key in validation_messages) {
				// skip loop if the property is from prototype
				if (!validation_messages.hasOwnProperty(key))
					continue;
				content += "<tr><td>#</td>";
				var obj = validation_messages[key];
				for ( var prop in obj) {
					// skip loop if the property is from prototype
					if (!obj.hasOwnProperty(prop))
						continue;

					content += "<td>" + prop + "</td>";
				}
				content += "</tr>";
				break;//欄位名稱只要一次
			}
		
			
			//每一筆資料
			for ( var key in validation_messages) {
				// skip loop if the property is from prototype
				
				if (!validation_messages.hasOwnProperty(key))
					continue;
				content += "<tr>";
			
				var obj = validation_messages[key];
				for ( var prop in obj) {
					// skip loop if the property is from prototype
					if (!obj.hasOwnProperty(prop))
						continue;	
					
					if(prop == first){
			
						content += "<td width='1em'><input type = 'radio' name = 'member' value ='"  + obj[prop] +"'></td>";			
					}
					content += "<td>" + obj[prop] + "</td>";
				}
				content += "</tr>";
			}
			
			//產生修改和刪除button
			
			
			content += "</table>";
			content += "</form>";
			
			errorID.innerHTML ='<div class="alert alert-success" role="alert" style="positive:absolute;margin-top:1em;"><a href="#" class="alert-link">成功查詢</a></div>';
			successID.innerHTML = content;
			
			//alert("selet success");
		}
	}
}

