

window.onload = function() {
	requestUserInfo();
	
	requestMyProjects();
};

function requestMyProjects() {
	var xhr = java33.requestXHR();	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) { 
			if (xhr.status == 200) {
				var response = JSON.parse(xhr.responseText);
				if (response.ajaxResult.status == "success") {
					var projectList = response.ajaxResult.data;
					var tagMyProjects = document.getElementById("myProjects");
					var tagLi = null;
					for(var i in projectList) {
						tagLi = document.createElement("li");
						tagLi.innerHTML = projectList[i].title;
						tagMyProjects.appendChild(tagLi);
					}
				} else {
					window.alert(response.ajaxResult.error);
				}
			} else {
				window.alert('서버에서 오류가 발생했습니다.');
			}
		}
	}; 
	xhr.open('GET', 'ajax/project/mylist.do', true); // 세번째 파라미터: 비동기 요청 
	xhr.send();
}

function requestUserInfo() {
	var xhr = java33.requestXHR();	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) { 
			if (xhr.status == 200) {
				//var response = eval("(" + xhr.responseText + ")");
				var response = JSON.parse(xhr.responseText);
				if (response.ajaxResult.status == "success") {
					var data = response.ajaxResult.data;
					var userName = document.getElementById('userName');
					var userEmail = document.getElementById('userEmail');
				
					userName.innerHTML = data.name;
					userEmail.innerHTML = data.email;
				} else {
					window.alert(response.ajaxResult.error);
				}
			} else {
				window.alert('서버에서 오류가 발생했습니다.');
			}
		}
	}; 
	xhr.open('GET', 'ajax/auth/userInfo.do', true); // 세번째 파라미터: 비동기 요청 
	xhr.send();
}
