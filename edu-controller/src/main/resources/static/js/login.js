$(function(){
    $("#loginBtn").click(function(){
        var userName = $.trim($("#userName").val());
        var pwd = $.trim($("#pwd").val());
        var checkNum = $.trim($("#checkNum").val());
        var flag = $("#roleChoose input[name='adminFlag']:checked").val();
        if(userName==null||userName==""){
            alert("请输入用户名!");
            return false;
        }else if(pwd==null||pwd==""){
            alert("请输入密码!");
            return false;
        }else if(checkNum==null||pwd==""){
            alert("请输入验证码!");
            return false;
        }else{
            $.ajax({
                url:"/edu/login",
                type:"post",
                data:{
                    userName:userName,
                    userPassword:pwd,
                    flag:flag
                },
                success:function(data){
                    if(data.status==0){
                        alert(data.content);
                    }else{
                        if(data.user=="2"||data.user==2){
                            window.location.href="/edu/home?user=student"
                        }else if(data.user=="1"||data.user==1){
                            window.location.href="/edu/home?user=teacher"
                        }else{
                            window.location.href="/edu/home?user=admin"
                        }
                    }
                },
                error:{

                }
            })
        }
    });


    /**
     * 获取验证码
     */
    $("#checkNumBtn").click(function(){
        var verificationCode = "";
        var userName = $.trim($("#userName").val());
        if(userName==null||userName==""){
            alert("请先输入用户名");
            return;
        }
        var i = 60;
        $("#checkNumBtn").attr("disabled","disabled");
        var timer = setInterval(function () {
            if(i==0){
                clearInterval(timer);
                $("#checkNumBtn").removeAttr("disabled");
                $("#checkNumBtn").val("获取验证码");
            }else{
                $("#checkNumBtn").val(i+"秒");
            }
            if(i==30){
                //模拟手机验证码
                $("#checkNum").val(verificationCode);
            }
            i--;
        }, 1000);
        $.ajax({
            url:"/edu/login/getCheckNum?user="+userName,
            type:"get",
            success:function (data) {
                verificationCode = data;
                //$("#checkNum").val(data);
            }
        });
    });
});
