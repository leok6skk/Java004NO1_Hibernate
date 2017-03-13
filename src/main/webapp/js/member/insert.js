
function setInsertData(input, servelet, middiv) {

	var username = document.getElementById(input).value;
	var resultID = document.getElementById(middiv);
	//var botID = document.getElementById(botdiv);

	var xhr = new XMLHttpRequest();
	xhr.open("POST", servelet, true);// send要傳參數一定要用POST
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	var queryString = setQueryString('formInsert');
	//alert(queryString);
	xhr.send(queryString);

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var validation_messages = JSON.parse(xhr.responseText);// 由servelet傳過來JSON格式的資料
			//alert(xhr.responseText);
			if (validation_messages == 'Success') {
				//新增成功
			
				var content = "";
				content += "<div style='position: absolute ;left:52em;'>";
				content += "<font color='#ffc526' weight='bold' size='3em'>";
				content += username + "新增成功";
				content += "</font>";
				content += "</div>";
				
				resultID.innerHTML = content;

				// 清空輸入值
				var frm = document.forms.namedItem('formInsert');
				var numberElements = frm.elements.length-1;//button不要清掉
				for (var i = 0; i < numberElements; i++) {

					frm.elements[i].value = "";

				}
				
				getQueryData('M_Username','Select','resultIndex','result','M_Username');
				
				//getQueryDataLimit(serveletQuery,botdiv);
				//查詢最新更新資料

			} else {
				//新增失敗
				
				var content = "";

				content += "<table>";
				content += "<font color='#ffc526' weight='bold' size='3em'>";
				content += "<ul style='position: absolute ;left:42em;'>";
			
				// 每一筆資料
				for ( var key in validation_messages) {
					// skip loop if the property is from prototype
					
					if (!validation_messages.hasOwnProperty(key))
						continue;

					var obj = validation_messages[key];
				
					for ( var prop in obj) {
						// skip loop if the property is from prototype
						if (!obj.hasOwnProperty(prop))
							continue;
						if(prop =="DML_Result"){
							alert(obj[prop]);
								//顯示錯誤原因
							break;
						}
						content += "<li width='15.625em'>" + obj[prop]
								+ "</li>";

					}
					
					content += "</ul>";
					content += "</font>";
					content += "</table>";

					resultID.innerHTML = content;

				}

			}
		}
	}
}


// -------------------------------------------------------
// 彈跳縮放

function toggle_visible(elName){
	
	var el = document.getElementById(elName);
	var isVisible = (el.style.visibility == 'hidden') ? true: false;

	el.style.visibility = isVisible ? 'visible': 'hidden';
	el.style.display = isVisible ? 'inline' : 'none';
	
}


//-------------------------------------------------------

