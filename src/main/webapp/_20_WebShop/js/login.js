window.onload = function() {
	alink = document.getElementById("accountlink");
	alink.onclick = function() {

	var div = document.getElementById('result0');
	var userId = document.getElementById("userId").value;
	if (!userId) {
		div.innerHTML = "<font color='blue' size='-2'>請輸入帳號</font>";
		return;
	}
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "CheckUserIdServlet", true);
	xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
	xhr.send("userId=" + userId);
	var message = "";
	xhr.onreadystatechange = function() {
	// 伺服器請求完成
	if (xhr.readyState == 4 && xhr.status == 200) {
		result = JSON.parse(xhr.responseText);
		if (result.custId.length == 0) {
			message = "帳號可用";
		} else if (	result.custId.startsWith("Error") ) {
			message = result.custId ;
		} else {
			message = "帳號重複，請重新輸入帳號";
		}
		div.innerHTML = "<font color='red' size='-2'>" + message
			+ "</font>";
	}
			}
		}
		var sendData = document.getElementById("sendData");
		sendData.onclick = function() {
			// 讀取欄位資料	  
			var userId = document.getElementById("userId").value;
			var pswd = document.getElementById("pswd").value;
			var email = document.getElementById("email").value;

			var hasError = false; // 設定判斷有無錯誤的旗標
			var div0 = document.getElementById('result0');
			var div1 = document.getElementById('result1');
			var div2 = document.getElementById('result2');
			var divResult = document.getElementById('resultMsg');
			// 	    if (!userId){
			// 		    div0.innerHTML = "<font color='red' size='-2'>請輸入帳號</font>";
			// 		    hasError = true;
			// 	    } else {
			// 		    div0.innerHTML = "";
			// 	    }
			// 	    if (!pswd){
			// 		    div1.innerHTML = "<font color='red' size='-2'>請輸入密碼</font>";
			//             hasError = true;
			// 	    } else {
			// 		    div1.innerHTML = "";
			// 	    }
			// 	    if (!email){
			// 		    div2.innerHTML = "<font color='red' size='-2'>請輸入eMail</font>";
			// 		    hasError = true;
			// 	    } else {
			// 		    div2.innerHTML = "";
			// 	    }
			// 	    if (hasError){
			// 		    return false;
			// 	    }
			var xhr1 = new XMLHttpRequest();
			xhr1.open("POST", "AddUser.do", true);
			xhr1.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			xhr1.send("userId=" + userId + "&pswd=" + pswd + "&email=" + email);
			xhr1.onreadystatechange = function() {
				// 伺服器請求完成
				if (xhr1.readyState == 4 && xhr1.status == 200) {
					result = JSON.parse(xhr1.responseText);
					if (result.fail) {
						divResult.innerHTML = "<font color='red' >"
							+ result.fail + "</font>";
					} else if (result.success) {
						divResult.innerHTML = "<font color='GREEN'>"
								+ result.success + "</font>";
						div0.innerHTML = "";	
						div1.innerHTML = "";
						div2.innerHTML = "";
					} else {
						if (result.userIdError) {
							div0.innerHTML = "<font color='green' size='-2'>"
									+ result.userIdError + "</font>";
						} else {
							div0.innerHTML = "";
						}
						if (result.pswdError) {
							div1.innerHTML = "<font color='green' size='-2'>"
									+ result.pswdError + "</font>";
						} else {
							div1.innerHTML = "";
						}
						if (result.emailError) {
							div2.innerHTML = "<font color='green' size='-2'>"
									+ result.emailError + "</font>";
						} else {
							div2.innerHTML = "";
						}
					}
				} 
			}
		}
		
	}
