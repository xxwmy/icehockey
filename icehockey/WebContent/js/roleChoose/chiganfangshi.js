/**
 * Created by Administrator on 2017/7/17.
 */
$(function(){
    var sportEvent=null;
    $('#left').on('click',function(){
        sportEvent = "LEFT";
        submit(sportEvent)
    });
    $('#right').on('click',function(){
        sportEvent = "RIGHT";
        submit(sportEvent)
    });
    //提交用户选择的信息
    var urlUserId=comm.getUrlParameter("userid");
    function submit(sportEvent){
        var r=confirm("确认要提交么");
        if (r==true)
        {  
            var data = {
                handlingId : sportEvent,
                userid:urlUserId
            };

          //  alert(JSON.stringify(data));
            
            //TODO 请求后台保存数据
            $.post(HANDLINGURL,data,function(result){
            	var jsonReturn = JSON.parse(result);
                //TODO 处理后台返回的结果
                if(jsonReturn.result == "0"){
                    //提交成功之后进行的操作
                    window.location.href = "../bxy/gender.html?userid=" + jsonReturn.userid;//接下来是性别选择
                } else if (jsonReturn.result == "-1") {
    				alert("当前没有登录用户");
    			}
            },"json");
        }
        else
        {}
    }
});