$(document).ready(function() {
	var options = { 
            dataType:       'json',
            success:        showResponse, 
//            resetForm: 		true,
            url:            'Select'
	};
	
	$('#formSelect').ajaxForm(options);
	
}); 




// 提交後
function showResponse(responseText, statusText) {
	alert('狀態: \n' + statusText + '\n 返回的内容是: \n' + responseText);

	// responseText = JSON.parse(responseText);
	var content = "";
	var NumOfData = responseText.length;

	content += "<form id='queryData'>";
	content += "<table>";

//	for (var i = 0; i < NumOfJData; i++) {
//
//		for ( var idx_Key in responseText[i]) {
//
//			alert(responseText[i][idx_Key]);
//
//		}
//
//	}

			// 欄位名稱
			for ( var key in responseText) {
				// skip loop if the property is from prototype
				if (!responseText.hasOwnProperty(key))
					continue;
				content += "<tr><td>#</td>";
				var obj = responseText[key];
				for ( var prop in obj) {
					// skip loop if the property is from prototype
					if (!obj.hasOwnProperty(prop))
						continue;
					alert(prop);
					content += "<td>" + prop + "</td>";
				}
				content += "</tr>";
				break;//欄位名稱只要一次
			}
		
			
			//每一筆資料
			for ( var key in responseText) {
				// skip loop if the property is from prototype
				
				if (!responseText.hasOwnProperty(key))
					continue;
				content += "<tr>";
			
				var obj = responseText[key];
				for ( var prop in obj) {
					// skip loop if the property is from prototype
					if (!obj.hasOwnProperty(prop))
						continue;	
					
					if(prop == first){
			
						content += "<td width='1em'><input type = 'radio' name = 'member' value ='"  + obj[prop] +"'></td>";			
					}
					alert(obj[prop]);
					content += "<td>" + obj[prop] + "</td>";
				}
				content += "</tr>";
			}
	
			content += "</table>";
			content += "</form>";
			
			$('#resultIndex').innerHTML = content;
		
}





