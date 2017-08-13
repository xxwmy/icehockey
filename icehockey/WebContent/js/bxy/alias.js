/**
 * Created by Administrator on 2017/7/4.
 */
$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	// 点击'完成'按钮
	$("#imgupload").click(function() {

		var touxiang = $("#touxiang").val();
		var name = $("#name").val();
		if (touxiang == "") {
			alert("请选择您的头像");
			return false;
		}
		if (name == "") {
			alert("请输入您的昵称!");
			return false;
		}
		$("#formimgupload").append($("#touxiang"));
		$("#formimgupload").hide();
		$("#formimgupload").submit();				
		});

});
function callback(content) {
	//alert(content);
	var name = $("#name").val();
	var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
	// 请求后台服务
	var data = {
		touxiang : content,
		name : name,
		userid : urlUserId
		};
	//alert(JSON.stringify(data));
	$.post(ALIASURL,data,function(result) {
		var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
		if (jsonReturn.result == "0") {
			window.location.href = "../main.html?userid="+jsonReturn.userid;
			}else if (jsonReturn.result == "-1") {
				alert("当前没有登录用户");
			}
		}, "json");
}