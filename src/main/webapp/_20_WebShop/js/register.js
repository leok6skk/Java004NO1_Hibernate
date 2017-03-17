function checkPasswords(){
	var password1 = document.getElementById('Password');
	var password2 = document.getElementById('checkpassword');
	if(password1.value!=password2.value){
		password2.setCustomValidity("您輸入的密碼不同");
	}else{
		password2.setCustomValidity(' ');
	}

}