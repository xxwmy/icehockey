/**
 * Created by Administrator on 2017/7/4.
 */
$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	// 点击登录
	$(".submitBtn")
			.click(
					function() {
						var phoneNumber = $("#phoneNumber").val();
						var verificationCode = $("#verificationCode").val();
						if (phoneNumber == "") {
							alert("请输入手机号码");
							return false;
						}
						if (verificationCode == "") {
							alert("验证码不能为空!");
							return false;
						}
						// 请求后台服务
						var data = {
							phoneNumber : phoneNumber,
							verificationCode : verificationCode
						};
						// alert(JSON.stringify(data));
						$
								.post(
										LOGIN_API,
										data,
										function(result) {
											// alert(typeof result + " ,返回的内容为
											// "+ result);
											if (result != null) {
												var jsonReturn = JSON
														.parse(result);// 将JSON字符串转换为对象
												// 判断 result 的返回值 ,isFirst
												// 为后台添加的属性,如果是第一次登陆则至hobbyChoose.html
												if (jsonReturn.result == 'isFirst') {
													window.location.href = "./page/hobbyChoose.html?userid="
															+ jsonReturn.userid;
													// window.open('./test.html');
												} else if (jsonReturn.result == '0') {
													window.location.href = "./main.html?userid="
															+ jsonReturn.userid;
												} else if (jsonReturn.result == '-1') {
													alert("手机号码为："
															+ phoneNumber
															+ "的用户不存在");
												} else if (jsonReturn.result == '-2') {
													alert("密码错误");
												}
											} else {
												alert("数据库有误");
											}
										}, "json");
					});
});