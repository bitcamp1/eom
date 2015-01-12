var xhr;

window.onload = function() {
	xhr = new XMLHttpRequest();	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) { 
			if (xhr.status == 200) {
				var data = eval("(" + xhr.responseText + ")");
				var userName = document.getElementById('userName');
				var userEmail = document.getElementById('userEmail');
				
				userName.innerHTML = data.name;
				userEmail.innerHTML = data.email;
				
			} else {
				window.alert('서버에서 오류가 발생했습니다.');
			}
		}
	}; 
	xhr.open('GET', 'auth/userInfo.do', true); // 세번째 파라미터: 비동기 요청 
	xhr.send();
};
