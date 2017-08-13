$(function() {
	// 请求后台服务
	var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
		var data = {
			userid : urlUserId,
		}
		//alert(JSON.stringify(data));
		// 请求后台保存数据
		$.post(MYPHOTOURL, data, function(result) {
			// 处理后台返回的结果
			var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
			if (jsonReturn.result == "0") {
				//alert("姓名："+jsonReturn.userName);
				//在id为myphoto的div中显示所有照片信息
				//$("#myphoto").html("级别："+jsonReturn.myphoto);
				// window.open
			} else if (jsonReturn.result == "-1") {
				alert("当前没有登录用户");
			}
		},"json");
});