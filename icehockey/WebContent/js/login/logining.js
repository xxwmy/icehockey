/**
 * Created by Administrator on 2017/7/15.
 */
$(function(){
    setTimeout(function(){
        $('.wait').fadeOut();
    },1000);

    setTimeout(function(){
        if(getCookie(ISLOGIN_NAME)){
            this.location.href='main.html';
        }else{
            $('.container-fluid').fadeIn();
        }

    },1500);
    $('.other').on('click',function(){
        $('.container-fluid').fadeOut();
        this.location=''
    });
});