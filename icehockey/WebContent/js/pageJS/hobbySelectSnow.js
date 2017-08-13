/**
 * Created by Administrator on 2017/7/16.
 */
$(function(){

    var hobbyType = comm.getUrlParameter("play");
    var sportEvent = null;

    $("#danban").click(function(){
        //每个按钮执行的操作
        sportEvent = "DB";//单板
        submit(sportEvent);
    });

    $("#shuangban").click(function(){
        sportEvent = "SB";//双板
        submit(sportEvent);
    });

    $("#all").click(function(){
        sportEvent = "DS";//单双都玩
        submit(sportEvent);
    });
    
    //提交用户选择的信息
	var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
    function submit(sportEvent){
        var r=confirm("确认要提交吗？");
        if (r==true)
        {
            var data = {
            	play : hobbyType,
                snow_play : sportEvent,
                userid : urlUserId,
            };

           // alert(JSON.stringify(data));
            //TODO 请求后台保存数据
            $.post(SNOWURL,data,function(result){
                //TODO 处理后台返回的结果
            	var jsonReturn = JSON.parse(result);
				if (jsonReturn.result == "0") {
					window.location.href = "../roleChoose/role.html?userid=" + jsonReturn.userid;
                } else if (jsonReturn.result == "-1") {
    				alert("当前没有登录用户");
    			}
            },"json");
        }
        else{

        }
    }

});