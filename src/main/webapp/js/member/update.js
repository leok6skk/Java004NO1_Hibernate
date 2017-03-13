function updateData() {

	var obj=document.getElementsByName("member");
		//<input type = 'radio' name = 'member' value ='帳號'>
	var selected;
	var tag;
	for (var i=0; i<obj.length; i++) {
		if (obj[i].checked) {
	    	//如果被選取了
	    	 tag =  obj[i];
	    	 selected = obj[i].value;
	    	 break;//只能單選
	     }
	}
	
	//alert(tag);
	if (selected == null) {
		alert("請先選擇要修改的資料");
		return;
	
	} else {
	
	   if (confirm("確定要修改"+selected+"嗎?")) {
		var td = tag.parentElement;
		var tr = td.parentElement;
		var context = "<tr>";
		var temp = td;
		
		var tempLast = temp.parentNode.lastChild; //取得node的最後一個節點
		while (true) {
			temp = nextSib(temp,tempLast);
			if (temp == null)
				break;
			
//			var dc_input = document.createElement("input");
//			dc_input.type = 'text';
//			dc_input.size = 50;
//			dc_input.value= temp.innerHTML;
//			tr.appendChild(dc_input);
			context += "<td><input type='text' value='" + temp.innerHTML
					+ "'></td>";
		}
		context += "</tr>";
		//alert(context);
		//alert(td.parentElement.parentElement.parentElement.nodeName);
//		td.parentElement.parentElement.innerHTML = context;
		document.getElementById('insertIndex').innerHTML = context;
		
		
	   }else{
		   return false;
	   }

	}

}
function nextSib(node, tempLast) {

	if (node == tempLast) { //是否為最後一個節點

		return null;

	}

	var tempObj = node.nextSibling; //非最後一個，可找下一個Node

	while (tempObj.nodeType != 1 && tempObj.nextSibling != null)
		//nodeType不是元素節點且不是最後一個，即找到元素節點為止
		tempObj = tempObj.nextSibling; //往下找下一個

	return (tempObj.nodeType == 1) ? tempObj : null; //如果是元素節點，傳回節點本身，否則傳回null

}