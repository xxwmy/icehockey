/*
 .error-submit
 
 .checkboxBtn
 .errorMain
 * */


$(function(){
    $('body').css({'min-height':$(window).height()});
    $('.error-submit').on('click',function(){
        var $checkbox1=$('.checkboxBtn');//请简要说明value
        var $errorMain=$('.errorMain');//电话或邮箱value
        var $phone=$('.phone');
        //请求后台服务
        var data = {};
        var checkboxArr=[];
        
        $checkbox1.each(function(){
            var isChecked=$(this).is(':checked');//错误信息获取
            if(isChecked){
                checkboxArr.push($(this).attr('data'));
            }
        });
        if(checkboxArr.length>0){
            data['errorCheck']=checkboxArr.join(';');
        }
        if($errorMain.val()){
            data['errorDesc']=$errorMain.val();
        }
        if($phone.val()){
            data['errorPhoneEmain']=$phone.val();
        }

        $.post(ERROR_URL, data, function(result) {
            if (result != null) {
                alert('错误信息提交成功');
            } else {
                alert("手机号码为：" + phoneNumber + "的用户不存在");
            }

        }, "json");

    });
});