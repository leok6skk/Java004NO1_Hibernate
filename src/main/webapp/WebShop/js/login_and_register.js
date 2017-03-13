

$(document).ready(function() {

    $('#login-form-link').click(function(e) {

		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {

		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

	//Handles menu drop down
    $('.dropdown-menu').find('form').click(function (e) {
        e.stopPropagation();
    });
    
    //帳號檢查
   
    $('#member_Username').blur(function(){
    	var URLs = "usernameCheck.do";
        var context = null;
        var id = $(this).val();
        var result = $('#usernameCheckResult');
        if(!id){
        	//沒有輸入帳號馬上回傳錯誤訊息
        	context='<div class="alert-danger">請先輸入帳號</div>';
        	result.html(context);
        
        	return;
        }
        if(!input_Check.Validate.chkAccount(id)){
        	context='<div class="alert-danger">4~20個英數或底線組成的字元</div>';
        	result.html(context);
        
        	return;
        }
        var queryString = 'Username='+id;
        $.ajax({
            url: URLs,
            data: queryString,
            type:"POST",
            dataType:'text',

            success: function(msg){
            	
                if(msg.match('usable')){
                	
                	context='<div class="alert-success">帳號 '+id+'可使用</div>';
                }else{
                
                	if(msg.match('exist')){
                		
                	context='<div class="alert-danger">帳號 '+id+'已存在</div>';	
                	}else{
                	context='<div class="alert-danger">請先輸入帳號</div>';	
                	}
                }
                result.html(context);
            },

             error:function(xhr, ajaxOptions, thrownError){ 
                alert('發生錯誤 '+xhr.status+' '+thrownError+',請洽詢工程師'); 
                
             }
        });
    });
    
    //密碼檢查
    $('#Password').blur(function(){
    	$('#Password').setCustomValidity("自訂訊息");
    });
    
    
    
});

//輸入檢查

//input_Check.Validate 
//isEmail:email格式檢查 return true、false 
//isDate:日期格式檢查 return true、false 
//chkAccount:檢查帳號必須為英數或底線組成，且必須為4碼以上 
//chkPassword:6～20個字元，需包含數字及英文，勿使用特殊字元或符號 
//----------------------------------------------------------------
//input_Check.String 
//trimSymbol:去除字串左右兩邊的指定符號  
//ex: Check.String.trimSymbol(',test,', ","); // test 
//----------------------------------------------------------------
input_Check = {
	    Validate: {
	        isEmail: function (para) {
	            return para == '' ? false : !(!/^[^\s]+@[^\s]+\.[^\s]{2,3}$/.test(para));
	        }, isDate: function (para) {
	            try {
	                var D, d = para.split(/\D+/);
	                d[0] *= 1;
	                d[1] -= 1;
	                d[2] *= 1;
	                D = new Date(d[0], d[1], d[2]);
	                return (D.getFullYear() == d[0] && D.getMonth() == d[1] && D.getDate() == d[2]) ? true : false;
	            }
	            catch (er) {
	                return false;
	            }
	        }, chkAccount: function (para) {
	            return para == '' ? false : /^[0-9a-zA-Z_]{4,20}$/.test(para);
	        }, chkPassword: function (para) {
	            return para == '' ? false : /(?=^.{6,20}$)(?=.*[a-zA-Z])(?=.*[0-9])(?!.*\s).*$/.test(para);
	        }
	    }, String: {
	        trimSymbol: function (para, symbol) {
	            return (para == '' || symbol == '') ? '' : (function () {
	                para = para.substr(0, 1) == symbol ? para.substr(1, para.length - 1) : para;
	                para = para.substr(para.length - 1, 1) == symbol ? para.substr(0, para.length - 1) : para;
	                return para;
	            })(para);
	        }
	    }, DateAndTime: {
	        dateAdd: function (timeU, byMany, dateObj) {
	            var millisecond = 1;
	            var second = millisecond * 1000;
	            var minute = second * 60;
	            var hour = minute * 60;
	            var day = hour * 24;
	            var year = day * 365;

	            var newDate;
	            var dVal = dateObj.valueOf();
	            switch (timeU) {
	                case "ms": newDate = new Date(dVal + millisecond * byMany); break;
	                case "s": newDate = new Date(dVal + second * byMany); break;
	                case "mi": newDate = new Date(dVal + minute * byMany); break;
	                case "h": newDate = new Date(dVal + hour * byMany); break;
	                case "d": newDate = new Date(dVal + day * byMany); break;
	                case "y": newDate = new Date(dVal + year * byMany); break;
	            }
	            return newDate;
	        }, getDateFormat: function (nextDate) {
	            return nextDate.getFullYear() + "/" + (nextDate.getMonth() + 1) + "/" + nextDate.getDate();
	        }
	    }
	}
