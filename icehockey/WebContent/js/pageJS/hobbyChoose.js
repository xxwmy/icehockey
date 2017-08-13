$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});
	// 玩冰点击事件
	$("#playice").click(function() {
		submit('ICE');
		// window.location.href = "hobbySelectIce.html?hobbyType=ICE";
	});

	// 玩雪点击事件
	$("#playsnow").click(function() {
		submit('SNOW');
		// window.location.href = "hobbySelectSnow.html?hobbyType=SNOW";
	});

	// 玩冰又玩雪点击事件
	$("#playboth").click(function() {
		submit('ICESNOW');
		// window.location.href = "hobbySelectIce.html?hobbyType=ICE&All=true";
	});
	// 请求后台服务
	var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
	function submit(play) {
		var data = {
			userid : urlUserId,
			play : play		
		};
		//alert(JSON.stringify(data));
		// 请求后台保存数据
		$.post(HobbyURL, data, function(result) {
			// 处理后台返回的结果
			var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
			if (jsonReturn.result == "0") {
				if (play == "ICE") {// 如果选择玩冰，跳转玩冰页面
					window.location.href = "hobbySelectIce.html?play=" + play
							+ "&userid=" + jsonReturn.userid;
				} else if (play == "SNOW") {// 如果选择玩雪，跳转玩雪页面
					window.location.href = "hobbySelectSnow.html?play=" + play
							+ "&userid=" + jsonReturn.userid;
				} else if (play == "ICESNOW") {// 如果选择两者都玩，先跳转至玩冰页面，再跳转玩雪页面
					window.location.href = "hobbySelectIce.html?play=" + play
							+ "&userid=" + jsonReturn.userid;
				}
				// window.open
			} else if (jsonReturn.result == "-1") {
				alert("当前没有登录用户");
			}
		},"json");
	}
});
