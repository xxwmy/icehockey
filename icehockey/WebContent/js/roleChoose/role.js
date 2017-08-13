/**
 * Created by Administrator on 2017/7/17.
 */
$(function() {

	var sportEvent = null;

	$("#qiuyuan").click(function() {
		// 每个按钮执行的操作
		sportEvent = "QY";
		submit(sportEvent)
	});

	$("#jiaolian").click(function() {
		sportEvent = "JL";
		submit(sportEvent)
	});

	$("#shoumen").click(function() {
		sportEvent = "SM";
		submit(sportEvent)
	});
	$("#caipan").click(function() {
		sportEvent = "CP";
		submit(sportEvent)
	});
	$("#school").click(function() {
		window.location.href = "school.html";
		// sportEvent = "DS";
		// submit(sportEvent)
	});
	$("#xiehui").click(function() {
		// sportEvent = "DS";
		// submit(sportEvent)
		window.location.href = "team.html";
	});

	// 提交用户选择的信息
	var urlUserId = comm.getUrlParameter("userid");
	function submit(sportEvent) {
		var r = confirm("确认要提交么");
		if (r == true) {
			var data = {
				role : sportEvent,
				userid : urlUserId
			};

			// alert(JSON.stringify(data));
			// TODO 请求后台保存数据
			$.post(ROLEURL, data, function(result) {
				var jsonReturn = JSON.parse(result);
				// TODO 处理后台返回的结果
				if (jsonReturn.result == '0') {
					// 提交成功之后进行的操作
					window.location.href = 'chiganfangshi.html?userid='
							+ jsonReturn.userid;
				} else if (jsonReturn.result == "-1") {
					alert("当前没有登录用户");
				}
			}, "json");
		} else {

		}

	}
});