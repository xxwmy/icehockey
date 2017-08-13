/**
 * 
 */
$(function() {
	// 请求后台服务
	var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
		var data = {
			userid : urlUserId,
		};
		//alert(JSON.stringify(data));
		// 请求后台保存数据
		$.post(MYESSENTIALINFOURL, data, function(result) {
			// 处理后台返回的结果
			var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
			if (jsonReturn.result == "0") {
				//alert("姓名："+jsonReturn.userName);
				$("#userName1").html("姓名："+jsonReturn.userName);
				$("#userbody1").html("身高体重："+jsonReturn.height+"cm / "+jsonReturn.weight+"kg");
				$("#usersex1").html("性别："+jsonReturn.sex);
				$("#birthday1").html("出生年月："+jsonReturn.birthday);
				$("#usercountry1").html("国家："+jsonReturn.country);
				$("#usercity1").html("籍贯："+jsonReturn.city);
				$("#userplay1").html("爱好:"+jsonReturn.play);
				$("#userice_play1").html("玩冰项目:"+jsonReturn.ice_play);
				$("#userroleId1").html("角色:"+jsonReturn.roleName);
				$("#userhandlingId1").html("持杆方式:"+jsonReturn.handling);
				// window.open
			} else if (jsonReturn.result == "-1") {
				alert("当前没有登录用户");
			}
		},"json");
});
