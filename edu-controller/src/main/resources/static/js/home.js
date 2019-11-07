$(function(){
	
	/*********  点击导航链接添加tabs  ********/
	$('.linkheader a').bind("click",function(){
		var title = $(this).text();
		var url = $(this).attr('data-link');
		var iconCls = $(this).attr('data-icon');
		testAddSubPage(title,url,iconCls);
	});	
	
	$('.index_header_right p a').mouseover(function(){
		$('.index_header_right p a img').attr('src','http://localhost:8066/edu/static/image/homeImg/shutdown2.png')
	});
	$('.index_header_right p a').mouseleave(function(){
		$('.index_header_right p a img').attr('src','http://localhost:8066/edu/static/image/homeImg/shutdown1.png')
	});
	
	
});

function adminExit(){
	$.messager.confirm('退出登录', '您确定退出该系统吗？', function(r){
		if (r){
		    // 退出操作;
			location.href="user/Out";
		}else{
			
		}
	});


}
/**
 * 点击导航链接，添加新的tab
 */
function testAddSubPage(title,url,iconCls){
    var jq = top.jQuery;
    if (jq("#index-tabs").tabs('exists', title)){    
        jq("#index-tabs").tabs('select', title); //选中该tab
    } 
    else {  
    	var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';     
        jq("#index-tabs").tabs('add',{    
        title:title,    
        content:content, 
        iconCls:iconCls,
        closable:true    
        });    
    }    
} 


/*******************************
 *        教师菜单
*******************************/

function changePwd(){
	$('#dd').dialog({    
	    title: 'My Dialog',    
	    width: 400,    
	    height: 200,    
	    closed: false,    
	    cache: false,    
	    href: '',
	    modal: true   
	});
}


