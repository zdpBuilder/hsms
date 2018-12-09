<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<!DOCTYPE html>
<html> 
<head>
	<meta charset="utf-8">
	<title>开心超市管理系统</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../plugins/layui2.x/css/layui.css" media="all" />
    <link rel="stylesheet" href="../css/global.css" media="all">
    <link rel="stylesheet" href="../css/style.css" media="all">
	<link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
</head>
<style>
.layui-input {
	height: 26px;
	font-size: 12px;
	width: 180px;
}

.layui-form-select {
	font-size: 12px;
	width: 180px;
}

dd {
	line-height: 26px;
	font-size: 12px;
	width: 140px;
}

.layui-elem-field legend {
	font-size: 12px;
}

.layui-form-radio * {
	line-height: 26px;
	font-size: 12px;
}
</style>
<body class="body">
	<div class="layui-form" action="">
	<fieldset class="layui-elem-field">
			<legend>数据库备份信息</legend>	
	<div class="layui-form-item" style="text-align: center; margin: 10px;">
					<div class="layui-progress layui-progress-big"
						lay-showpercent="true" lay-filter="demo">
						<div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>
					</div>
                      <div class="layui-form-item layui-form-text" style="margin-top:20px;margin-left:-15%">
					    <div class="layui-input-block">
					      <textarea placeholder="请输入数据库备份备注" id="comment" name="comment"   class="layui-textarea "></textarea>
					    </div>
					  </div>		
    
</div>
</fieldset>
  <div class="layui-form-item"
			style="text-align: center; margin-top: 10px;">
			<button  id="loadingBtn"class="layui-btn layui-btn-sm layui-btn-normal " 
				>备份</button>
			&nbsp;&nbsp;
			<button class="layui-btn layui-btn-sm layui-btn-normal" id="close">取消</button>
		</div>
	</div>
<script type="text/javascript" src="../plugins/layui2.x/layui.js"></script>	
<script type="text/javascript">
var form;
var $ ;
	    // layui方法
	    layui.use(['table', 'layer','element','form'], function () {
			
	        // 操作对象
	        form = layui.form; 
	        $ = layui.jquery;
	        var layer = layui.layer;  
	        var element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
	        
	    
	     
	        //保存按钮
	          $("#loadingBtn").click(function () {
	         
	           
	            //模拟loading
	            var n = 0, timer = setInterval(function(){
	              n = n + Math.random()*100|0; 
	              
	              if(n>100){
	               
	            	  $.ajax({
		        			method: "post",
		        			data : {
		        				"comment":$("#comment").val(),
		        			       },
		        				    async:false,
		        			url:"../dbBackup/save",
		        			success:function(result){
		        				   if(typeof(result.status)==="undefined"){
		           					parent.layer.msg('备份失败！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);   
		        				   }
		        				   if(result.status==1){
		        					  
		        					   clearInterval(timer);
		        					   $('#loadingBtn').removeClass("layui-btn-disabled");
		        					   $("#comment").removeAttr("disabled","disabled");  
		        			        	 n=100;
		        			        	 element.progress('demo', '100%');
			           					parent.layer.msg('备份成功！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);      
			           					//刷新表格
		                                 parent.reloadTable(1);
		                               //关闭窗口 并给父页面传值
		                 	            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引                   	                       
		                 	            parent.layer.close(index); 
		        				   }else{
		        					   n=100;
		        					   clearInterval(timer);
			           					parent.layer.msg('备份失败！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);         
		        				   }
		        			}
		              });
	              
	              }
	              element.progress('demo', n+'%');
	            }, 300+Math.random()*1000);
        	 
	            $('#loadingBtn').addClass("layui-btn-disabled");
	        	 $("#comment").attr("disabled","disabled"); 
	              
	        });
	        //关闭窗口按钮
	        $("#close").click(function(){
	        	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	        	parent.layer.close(index);
	        });
	         	
	    });
	</script>
</body>
</html>