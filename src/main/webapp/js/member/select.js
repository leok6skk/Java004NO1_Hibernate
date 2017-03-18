$(document).ready(function() {

	$('#formSelect').ajaxForm({ 
        dataType: 'json',
        success:   showResponse, 
        resetForm: true,
        url:       'Select'
	});
	
}); 

// 提交後
function showResponse(responseText, statusText) {

	var content="";

	content += "<form id='queryData'>";
	content += "<table>";
	
	//每一筆資料
	$.each(responseText, function(key, value){
		
		//欄位名稱
		if(key==0){
			content += "<tr><td width='1em'>#</td>";
			
			$.each(value, function(key, value){
		    	content += "<td>"+key+"</td>";
		    });
			content += "</tr>";
		}
		
		//每一筆資料
		content += "<tr>";
		content += "<td width='1em'><input type='radio' name='member'></td>";
		
	    $.each(value, function(key, value){
	    		content += "<td>"+value+"</td>";    	
	    });
	    content += "</tr>";
	});
	content += "</table>";
	content += "</form>";
	
	$('#resultIndex').html(content);

	
}





