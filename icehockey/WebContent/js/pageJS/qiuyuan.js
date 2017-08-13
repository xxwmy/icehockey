
$(document).ready(function(){
	var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
	var data = {
		userid : urlUserId,
	}
	//alert(JSON.stringify(data));
	// 请求后台保存数据
	$.post(MYESSENTIALINFOURL, data, function(result) {
		// 处理后台返回的结果
		var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
		if (jsonReturn.result == "0") {
			//alert("姓名："+jsonReturn.userName);
			$("#userName").html("姓名："+jsonReturn.userName);
			$("#userbody").html("身高/体重："+jsonReturn.height+"cm / "+jsonReturn.weight+"kg");			
			$("#usercountry1").html("国家："+jsonReturn.country);
		} else if (jsonReturn.result == "-1") {
			alert("当前没有登录用户");
		}
	},"json");
	
	$(".button_next1").click(function(){
	var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
  	var data={
  	userid : urlUserId,
		
  	};
    $.post(MYESSENTIALINFOURL,data,function(result){   	
      var jsonReturn = JSON.parse(result);//处理后台返回的结果     
		if(jsonReturn.result=="0"){
			window.location.href="../essentiainfo.html?userid=" + jsonReturn.userid;		
		}
		else if(jsonReturn=="-1"){//接收数据失败的处理
			alert("当前没有登录用户");
		}
	},"json");
    });

 });
function mainClick(){
	var urlUserId = comm.getUrlParameter("userid");
	window.location.href = "../../views/main.html?userid="+urlUserId;
}
function saichengClick(){
		var urlUserId = comm.getUrlParameter("userid");
	    window.location.href = "../../views/saicheng.html?userid="+urlUserId;
	}

function gongjuClick(){
		var urlUserId = comm.getUrlParameter("userid");
		window.location.href = "../../views/gongjv.html?userid="+urlUserId;
}


function clubClick(){
	var urlUserId = comm.getUrlParameter("userid");
	window.location.href = "../../views/imformation/mycommunity.html?userid="+urlUserId;	
}


function infoClick(){
	var urlUserId = comm.getUrlParameter("userid");
	window.location.href = "../../views/imformation/oscenter.html?userid="+urlUserId;
}