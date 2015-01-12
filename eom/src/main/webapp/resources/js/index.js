window.onload = function() {
	requestUserInfo();
	
	requestMyProjects();
	
	$('#project').click(function(){
		$.load('#content', 'project/main.html');
	});
	
	$('#member').click(function(){
		$.load('#content', 'member/main.html');
	});
};

function requestMyProjects() {
	$.ajax('ajax/project/mylist.do',	{
		type: 'GET',
		success: function(data) {
			var tagMyProjects = $("#myProjects");
			var tagLi = null;
			for(var i in data.list) {
				tagLi = $("<li>");
				tagLi.innerHTML = data.list[i].title;
				tagMyProjects.appendChild(tagLi);
			}
		},
		error: function(data) {
			window.alert(data);
		}
	});
}

function requestUserInfo() {
	$.ajax('ajax/user/userInfo.do',	{
		type: 'GET',
		success: function(data) {
			var userName = $('#userName');
			var userEmail = $('#userEmail');
		
			userName.innerHTML = data.member.name;
			userEmail.innerHTML = data.member.email;
		},
		error: function(data) {
			window.alert(data);
		}
	});
}
