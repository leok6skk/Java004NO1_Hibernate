 
//判斷是點擊+還是-,如果數量是1點擊-時一樣設定數量為1,並同時更新總金額及數量----
function changeAmount(obj) {
	var td = obj.parent(), btn = obj.attr('class'), c = td.find('.count'), v = parseInt(c.val());
	btn.indexOf('minus') == 0 ? v -= 1 : btn.indexOf('plus') == 0 && (v += 1);
	v <= 1 ? c.val(1) : c.val(v);

	var tr = td.parent(), p = tr.find('.price').text(), t = tr.find('.total');
	v <= 1 ? t.text(p) : t.text(p * v);

	updateData();
}

//刪除該項產品-----------------------------
function setDel(obj) {
	if (confirm("確定刪除此項商品 ?")) {
		obj.parents('tr').remove().children().remove();
	updateData();
	}
}

//畫面載入時先讀取資訊-----------------------------
function updateData(){
	//畫面載入時計算單項物品的總金額	
	for(i=0; i< $('.price').size();i++){
		var p = $('.price').eq(i).text();
		var c = $('.count').eq(i).val();
		var total = p * c;
		$('.total').eq(i).text(total);
	}
	//畫面載入時計算物品總金額
	var subtotal = 0;
	$('.total').each(function() {
		var t = parseInt($(this).text());
		subtotal += t;
	});
	$('.subtotal').text(subtotal);
	
	//畫面載入時計算物品總數量
	var amount = 0;
	$('.count').each(function() {
		var c = parseInt($(this).val());
		amount += c;
	});
	$('.amount').text(amount)
	
	//如果沒有商品顯示以下內容
	if( $('.price').size()==0){
		var txt1=$("<tr class=alertMsg><td></td></tr>").text("購物車空空如也，趕快去購物吧！");
		var txt2=$("<a href=index.html></a>").text("回購物網");
		$('tbody').eq(0).append(txt1,txt2);
	}
}

//doFirst--------------------------------
$(function() {
	 updateData();
});

