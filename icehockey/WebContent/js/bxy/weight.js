$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});
	$('.next').click(function() { // ---> 注意function为小写
		var weight = $("#points").val();// 得到weight的值
		// submit('weight'); ---> 这样写 是将'weight'字符串传入到 submit中
		submit(weight);
		// alert(JSON.stringify(data)); ---> data 不存在 会报错
	});

	var urlUserId = comm.getUrlParameter("userid");// 解析url中的参数获取userid的值
	function submit(weight) {
		var data = {
			weight : weight,
			userid : urlUserId,
		};
		//alert(JSON.stringify(data));

		// 请求后台保存数据
		$.post(WEIGHTURL, data, function(result) {
			//alert(JSON.stringify(data));
			var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
			if (jsonReturn.result == "0") {
				if (jsonReturn.gender == "man") {// 如果选择'man'，跳转man体重面
					window.location.href = "manHeight.html?userid="
							+ jsonReturn.userid;
				} else if (jsonReturn.gender == "lady") {// 如果选择‘lady''，跳转lady体重页面
					window.location.href = "ladyHeight.html?userid="
							+ jsonReturn.userid;
				}
			} else if (jsonReturn.result == "-1") {
				alert("当前没有登录用户");
			}
		}, "json");
	}
});
