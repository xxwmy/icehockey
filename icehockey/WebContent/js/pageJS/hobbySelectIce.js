$(function() {

	var hobbyType = comm.getUrlParameter("play");
	var sportEvent = null;
	var chooseAll = comm.getUrlParameter("All");// ?????null
	$("#bingqiu").click(function() {
		// 每个按钮执行的操作
		sportEvent = "BQ";// 冰球
		submit(sportEvent);
	});

	$("#huayang").click(function() {
		sportEvent = "HY";// 花样
		submit(sportEvent);
	});

	$("#suhua").click(function() {
		sportEvent = "SH";// 速滑
		submit(sportEvent);
	});

	$("#binghu").click(function() {
		sportEvent = "BH";// 冰壶
		submit(sportEvent);
	});

	// 提交用户选择的信息
	var urlUserId = comm.getUrlParameter("userid");// 解析url中的参数获取userid的值
	function submit(sportEvent) {
		var r = confirm("确认要提交吗？");
		if (r == true) {
			var data = {
				play : hobbyType,
				ice_play : sportEvent,
				userid : urlUserId,
			};
			//alert(JSON.stringify(data));
			// 请求后台保存数据
			$.post(ICEURL, data, function(result) {
				// TODO 处理后台返回的结果
				var jsonReturn = JSON.parse(result);
				//alert(jsonReturn);
				if (jsonReturn.result == "0") {
					if (hobbyType == "ICESNOW") {
						window.location.href = "hobbySelectSnow.html?play="
								+ hobbyType + "&userid=" + jsonReturn.userid
								+ "&ice_play=" + sportEvent;
					} else {
						//alert(jsonReturn.userid);
						window.location.href = "../roleChoose/role.html?userid=" + jsonReturn.userid;
					}
				}  else if (jsonReturn.result == "-1") {
					alert("当前没有登录用户");
				}
			},"json");
		} else {

		}
	};

});