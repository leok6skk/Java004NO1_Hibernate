$(document).ready(function(){

	//總頁數
	totalPages('TotalPages',"#totalPages");
	
	//上一頁
	$('#pageBack').click(function(){
		pageBack();
		
		//自動搜尋
		buttonSelect('Select','#resultIndex','#formSelect');
	});	
	
	//下一頁
	$('#pageNext').click(function(){
		pageNext();
		
		//自動搜尋
		buttonSelect('Select','#resultIndex','#formSelect');
	});	
	
	//自動搜尋
	buttonSelect('Select','#resultIndex','#formSelect');
	
	//搜尋提交
	$('#formSelect').click(function(){
		buttonSelect('Select','#resultIndex','#formSelect');
	});	
	
	//新增畫面
	$('#buttoninsert').click(function(){
		buttonInsert('InsertMember.jsp','#insertIndex');
	});
	
	//新增提交
	$('#submitinsert').click(function(){
		submitInsert('Insert','#resultInsert','#formInsert');
		
		//自動搜尋
		buttonSelect('Select','#resultIndex','#formSelect');
	});
	
	
	//刪除提交
	$("#buttondelete").click(function(){
		buttonDelete("Delete");   	
    });
	
	//說明畫面
	$('#buttonremark').click(function(){
		alert("remark");
	});
	
	
	
});

//總頁數 function
function totalPages(servelet,resultId){
	$.ajax({url: servelet, success: function(result){
        $(resultId).val(result);
    }});	
}

//上一頁 function
function pageBack(){
	
	var num =  Number($('#pageNo').val());

	if(num >=2 ){
		$('#pageNo').val(num-1);
	}
}

//下一頁 function
function pageNext(){
	
	var pageNoId = document.getElementById("pageNo");
	var num =  Number(pageNoId.value); 
	
	var total =  Number(document.getElementById("totalPages").value);
	
	if(num < total && total>=2){
		pageNoId.value = num+1;
	}

}

//查詢提交 function
function buttonSelect(servelet, resultId, formId) {
	$.ajax({url: servelet,dataType: 'json',resetForm: true,data: $(formId).serialize(),
        success:   function(result){
  
        	selectResponse(result, resultId);       	
        }
	});
}

//查詢成功回傳
function selectResponse(result, resultId) {

	var content="";

	content += "<form id='queryData'>";
	content += "<table>";
	
	//每一筆資料
	$.each(result, function(key, value){
		
		//欄位名稱
		if(key==0){
			content += "<tr><td>#</td>";
			
			$.each(value, function(key, value){
		    	content += "<td>"+key+"</td>";
		    });
			content += "</tr>";
		}
		
		//每一筆資料
		content += "<tr>";
		content += "<td><input type='radio'></td>";
		
	    $.each(value, function(key, value){
	    		content += "<td>"+value+"</td>";    	
	    });
	    content += "</tr>";
	});
	content += "</table>";
	content += "</form>";
	
	$(resultId).html(content);
	//$('#resultIndex')
	
}


//新增畫面 function
function buttonInsert(servelet, resultId) {
	$.ajax({url: servelet, success: function(result){
        $(resultId).html(result);
    }});
}

//新增提交 function
function submitInsert(servelet, resultId, formId) {
	$.ajax({url: servelet,dataType: 'json',resetForm: true,data: $(formId).serialize(),
        success:   function(result){
        	
        	alert(result);        	
        }
	});
}


//刪除提交 function
function buttonDelete(servelet){
	
	var selected = $('input:checked').parent().next().text();

	if (selected == null || selected.trim().length == 0) {

		alert("請先選取要刪除的資料");  		
		return false;
	}
	
    $.ajax({
    	url: 		servelet,
    	data:		"Username="+selected,
    	dataType: 	'json',
    	async: 		false,
    	beforeSend: function(xhr, opts){
            if(!confirm("確定要刪除" + selected + "嗎?"))
            {
                xhr.abort();
            }
        },
    	success: 	function(result){
    		alert(result);
    	}
    });
}
