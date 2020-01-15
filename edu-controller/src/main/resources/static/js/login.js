$(function(){
    $("#loginBtn").click(function(){
        var userName = $.trim($("#userName").val());
        var pwd = $.trim($("#pwd").val());
        var flag = $("#roleChoose input[name='adminFlag']:checked").val();;
        console.log(userName,pwd,flag);
        if(userName==null||userName==""){
            alert("请输入用户名!");
            return false;
        }else if(pwd==null||pwd==""){
            alert("请输入密码!");
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
});
