$(document).ready(function(){
    $("#buttondelete").click(function(){
    	
    	var selected = $('input:checked').parent().next().text();

    	if (selected == null || selected.trim().length == 0) {

    		alert("請先選取要刪除的資料");  		
    		return false;
    	}
    	
        $.ajax({
        	url: 		"Delete",
        	data:		"Username="+selected,
        	dataType: 	'json',
        	async: 		false,
        	cache: 		false,
        	beforeSend: function(xhr, opts){
                if(!confirm("確定要刪除" + selected + "嗎?"))
                {
                    xhr.abort();
                }
            },
        	success: 	function(result){
//        		$('#sqlResult').html(result);
        		alert(result);
        	}
        });
    });
});











