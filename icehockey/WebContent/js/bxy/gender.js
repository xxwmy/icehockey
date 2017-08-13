$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});
	// 
	$("#man").click(function() {
		submit('man');
		//window.location.href = "manWeight.html";
	});

	// 性别"lady"击事件
	$("#lady").click(function() {
		submit('lady');
		//window.location.href = "ladyWeight.html";
	});

	// 请求后台服务
	var urlUserId = comm.getUrlParameter("userid");// 解析url中的参数获取userid的值

	function submit(gender) {
		var data = {
			userid : urlUserId,
			gender : gender
		};
		//alert(JSON.stringify(data));
		// 请求后台保存数据
		$.post(GENDERURL, data, function(result) {
			// 处理后台返回的结果
			var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
			if (jsonReturn.result == "0") {
				//alert(gender);
				if (gender == "man") {// 如果选择'man'，跳转man体重面
					window.location.href = "../bxy/manWeight.html?gender=" + gender
							+ "&userid=" + jsonReturn.userid;
				} else if (gender == "lady") {// 如果选择‘lady''，跳转lady体重页面
					window.location.href = "../bxy/ladyWeight.html?gender="
							+ gender + "&userid=" + jsonReturn.userid;
				}
			} else if (jsonReturn.result == "-1") {
				alert("当前没有登录用户");
			}
		}, "json");
	}
});
