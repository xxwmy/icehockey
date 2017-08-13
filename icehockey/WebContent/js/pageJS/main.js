function loadCarousel() {
	// 获得slider插件对象
	var gallery = mui('.mui-slider');
	gallery.slider({
		interval : 3000
	// 自动轮播周期，若为0则不自动播放，默认为0；
	});
}

/* 主页面上方六个功能 */
$(".saishizixun").click(function() {
	window.location.href = "mainUpPage/saishizixun.html";

});

$(".jiaobingbibai").click(function() {
	window.location.href = "mainUpPage/jiaobingbibai.html";
});

$(".hujvzhuangbei").click(function() {
	window.location.href = "mainUpPage/hujvzhuangbei.html";
});

$(".jishutongji").click(function() {
	window.location.href = "mainUpPage/jishutongji.html";
});

$(".jiaoxueziliao").click(function() {
	window.location.href = "mainUpPage/jiaoxueziliao.html";
});

$(".my2016").click(function() {
	window.location.href = "mainUpPage/my2016.html";
});

// 页面中间内容展示页面,待开发
$(".content_out_div>.left_content_div>.content_div").click(function() {
	alert("待开发页面");

});
$(".content_out_div>.right_content_div>.content_div").click(function() {
	alert("待开发页面");

});

function mainClick() {
	var urlUserId = comm.getUrlParameter("userid");
	window.location.href = "../views/main.html?userid=" + urlUserId;

}

function saichengClick() {
	var urlUserId = comm.getUrlParameter("userid");
	window.location.href = "../views/saicheng.html?userid=" + urlUserId;

}

function gongjuClick() {
	var urlUserId = comm.getUrlParameter("userid");
	window.location.href = "../views/gongjv.html?userid=" + urlUserId;
}

function clubClick() {
	var urlUserId = comm.getUrlParameter("userid");
	window.location.href = "../views/imformation/mycommunity.html?userid="
			+ urlUserId;
}

function infoClick() {
	var urlUserId = comm.getUrlParameter("userid");
	window.location.href = "../views/imformation/oscenter.html?userid="
			+ urlUserId;
}

function mineClick() {

	var urlUserId = comm.getUrlParameter("userid");// 解析url中的参数获取userid的值
	var data = {
		userid : urlUserId,

	};
	$
			.post(
					MYINFOURL,
					data,
					function(result) {
						var jsonReturn = JSON.parse(result);// 处理后台返回的结果
						if (jsonReturn.result = "0") {
							//alert(jsonReturn.roleName);
							if (jsonReturn.roleName == "教练")// 判断角色类别跳转相应页面教练员的跳转
							{
								window.location.href = "../views/imformation/coachinfo.html?userid="
										+ jsonReturn.userid;
							}
							if (jsonReturn.roleName == "守门员") {// 守门员的跳转
								window.location.href = "../views/imformation.html?userid="
										+ jsonReturn.userid;
							}
							if (jsonReturn.roleName == "球员")// 球员的跳转
							{
								window.location.href = "../views/imformation/qiuyuan.html?userid="
										+ jsonReturn.userid;

							}
							if (jsonReturn.roleName =="裁判") {
								window.location.href = "../views/imformation/coachinfo.html?userid="
										+ jsonReturn.userid;// 其他成员

							}

						} else if (jsonReturn == "-1") {// 未接收到返回数据的处理
							alert("当前没有登录用户");
						}
					}, "json");

}

// /*主页面点击效果*/
// function mainClick(){
// /*清除当前界面的active*/
// $(".main_top_pages>div").removeClass("active");
// /*给赛程界面设置活动*/
// $(".div_schedule").addClass("active");
// }
//
// //
// /*
// /*赛程点击效果*/
// function saichenClick(){
// /*清除当前界面的active*/
// $(".main_top_pages>div").removeClass("active");
// /*给赛程界面设置活动*/
// $(".div_game").addClass("active");
// }
// /*工具箱点击效果*/
// function gongjuClick(){
// /*清除当前界面的active*/
// $(".main_top_pages>div").removeClass("active");
// /*给赛程界面设置活动*/
// $(".div_tool").addClass("active");
// }
// /*社区点击效果*/
// function clubClick(){
// /*清除当前界面的active*/
// $(".main_top_pages>div").removeClass("active");
// /*给社区界面设置活动*/
// $(".div_club").addClass("active");
// }
// /*消息点击效果*/
// function infoClick(){
// /*清除当前界面的active*/
// $(".main_top_pages>div").removeClass("active");
// /*给消息界面设置活动*/
// $(".div_info").addClass("active");
// }
// /*我的点击效果*/
// function mineClick(){
// /*清除当前界面的active*/
// $(".main_top_pages>div").removeClass("active");
// /*给我的界面设置活动*/
// $(".div_mine").addClass("active");
// }
