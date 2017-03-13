
//$(function(){
//	$('ul.drop-down-menu ul li').click(function(){
//	var $newTab = $(this);
//	var getJspLink = $($newTab).find('a').attr('class'); //讀取該筆下拉選單的網頁超連結
//	var getHref = $($newTab).find('a').attr('href'); //讀取點擊到的選單的Href,用來產生tab的Herf
//	var setTabId= getHref.substr(1); //去掉_getHref的#,用來產生div的id
//	
//		if($(getHref).length > 0){
//			alert('網頁已存在');
//
//		}else{
//			//最後一個li後面產生新頁籤
//			$('ul.tabs li:last').after("<li><a href="+getHref+"> 123 <i><img id=cross></i></a></li>");
//				//最後一個div後面產生新的div
//			$('div.abgne_tab div:last').after("<div id="+setTabId+" class=tab_content ></div>");
//			//將畫面載入新的div #id 且 _getHref內
//			$(getHref).load(getJspLink);			
//		}		
//	});
//});	

//------------------------------------------------------
//$(function(){
//	// 預設顯示第一個 Tab
//	var _showTab = 0;
//	$('.abgne_tab').each(function(){
//		// 目前的頁籤區塊
//		var $tab = $(this);
// 
//		var $defaultLi = $('ul.tabs li', $tab).eq(_showTab).addClass('active');
//		$($defaultLi.find('a').attr('href')).siblings().hide();
// 
//		// 當 li 頁籤被點擊時...
//		// 若要改成滑鼠移到 li 頁籤就切換時, 把 click 改成 mouseover
//		$('ul.tabs li', $tab).click(function() {
//			// 找出 li 中的超連結 href(#id)
//			var $this = $(this),_clickTab = $this.find('a').attr('href');
//			// 把目前點擊到的 li 頁籤加上 .active, 並把兄弟元素中有 .active 的都移除 class
//			$this.addClass('active').siblings('.active').removeClass('active');
//			// 淡入相對應的內容並隱藏兄弟元素
//			$(_clickTab).stop(false, true).fadeIn().siblings().hide();
// 
//			return false;
//		}).find('a').focus(function(){
//			this.blur();
//		});
//	});
//});
//
////刪除Tab並跳回第一頁------------------------------------------------------
//$(function(){
//	//點擊X觸發事件
//	$('ul.tabs li a i').click(function(){
//		//找出對應的div#id並刪除
//		var _getHerf = $(this).parent().attr('href');
//		//找出被點擊X所對應的li並刪除
//		$(this).parent().parent().remove();
//		$(_getHerf).contents().remove();
//		//此語法會找出第一個a連結內的herf
//		var _getfFstHerf = $('a').attr('href'); 
//		//顯示找到的herf(此連結是連到div#id),顯示此id對應的div並隱藏其他div
//		$(_getfFstHerf).stop(false, true).fadeIn().siblings().hide();
//		//將預設顯示的li設為index=0(第一個li)顯示
//		$('.abgne_tab').each(function(){
//		var $tab = $(this),$defaultLi = $('ul.tabs li', $tab).eq(0).addClass('active');
//		$($defaultLi.find('a').attr('href')).siblings().hide();
//		});
//    });
//});

