

//點擊呼叫購物清單--------------------------------
$(function(){
	var list = $('#cd-cart'),
		trigger = $('#cd-cart-trigger');

	trigger.on('click', function(){
		if( list.hasClass('speed-in') ) {
			list.removeClass('speed-in');
		} else {
			list.addClass('speed-in');
		}
	});
});


$(function() {
	
	var arr=new Array();
	var storage = sessionStorage;

	$('#warp button').click(function(){	
		var thisID = $(this).attr('id');		
		var itemName  = $(this).parent().parent().find('.name').html();
		var itemPrice = $(this).parent().parent().find('.price').html();

		if(include(arr,thisID)){
			//如果清單已有此項物品,改寫清單內的數量/價格/總價
			var price = $('#each-'+thisID).next(".cd-price").find('em').html();
			var qty = $('#each-'+thisID).html();
			qty = parseInt(qty)+parseInt(1);
			
			var total = parseInt(itemPrice)*parseInt(qty);
			$('#each-'+thisID).next(".cd-price").find('em').html(total);
			$('#each-'+thisID).html(qty);
			
			var prev_charges = $('.cd-cart-total span').html();
			prev_charges = parseInt(prev_charges)-parseInt(price);			
			prev_charges = parseInt(prev_charges)+parseInt(total);
			
			$('.cd-cart-total span').html(prev_charges);
		}else{	
			//如果清單內沒有此項物品,新增至清單
			arr.push(thisID);
			var prev_charges = $('.cd-cart-total span').html();
			var info = $('#'+thisID).find('input').val();
			prev_charges = parseInt(prev_charges)+parseInt(itemPrice);
			
			$('.cd-cart-total span').html(prev_charges);
			
			$('.cd-cart-items').append('<li><span class=cd-qty id="each-'+thisID+'">1</span>'+itemName
			+'<div class=cd-price>$<em>'+itemPrice+'</em></div><a class=cd-item-remove cd-img-replace></a>'
			+'<input type=hidden value='+ info +'>'
			+'</li>');
			
		}		
	});	
	
	//點擊X刪除該商品--------------------------------
	$(document).on('click','.cd-item-remove',function(){	
		var p = $(this).parent().find('em').html();
		var prev_charges = $('.cd-cart-total span').html();
		prev_charges = parseInt(prev_charges)- parseInt(p);
		$('.cd-cart-total span').html(prev_charges);
		
		var id = $(this).prevAll().eq(1).attr('id').replace('each-','');;
		var idx = arr.indexOf(id);
		arr.splice(idx,1,0)
		$(this).parent().remove(); 	
	});	
	
	//點擊結算商品--------------------------------
	$(document).on('click','.checkout-btn',function(){	
		for(key=0; key< $('.cd-cart-items li').size();key++){			
		var qty = $('.cd-qty').eq(key).html();
		var info = $('input').eq(key).val();
		storage[key] = info + "|" + qty;
		}
	});
});

//點擊商品新增至購物清單--------------------------------
function include(arr, obj) {
  for(var i=0; i<arr.length; i++) {
    if (arr[i] == obj) return true;
  }
}

//Ajax接收後端Json資料，動態產生產品列--------------------
$(document).ready(function() {
	
});
