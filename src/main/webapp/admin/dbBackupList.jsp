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
    	body{overflow-y: scroll;}
    </style>
</head>
<body class="body">

<div class="layui-fluid">  
  <div class="layui-row layui-col-space10">
    
    <div class="layui-col-md12">
	         <div class="layui-field-box">	
					<!-- 表格内容区域 -->
					<div class="my-btn-box" style="margin-bottom:-10px;">
		             <div class="fl">  
		             <a class="layui-btn layui-btn-sm" id="btn-add"><i class="layui-icon">&#xe672;</i>数据库备份</a>   
		                <a class="layui-btn layui-btn-sm" id="btn-refresh" data-type="refresh"><i class="layui-icon">&#x1002;</i>刷新</a>
		            </div> 
		            <div class="fr" >            		
			
						 <div class="layui-input-inline">
		                    <input type="text" autocomplete="off" id="startDate" name="startDate" placeholder="开始时间" class="layui-input " style="height:26px;font-size:12px;"/>
		                </div> -
		                <div class="layui-input-inline">
		                    <input type="text" autocomplete="off" id="endDate" name="endDate" placeholder="结束时间" class="layui-input " style="height:26px;font-size:12px;"/>
		                </div>	 
		                <button class="layui-btn layui-btn-xs" id="btn-search" style="font-size: 10px;"><i class="layui-icon" style="font-size: 14px;">&#xe615;</i>&nbsp;查询</button>
		            </div>
		        </div>
			    <div class="layui-col-md12 layui-col-space1">
			    
					<table class="layui-hide" id="layTable" lay-size="sm" lay-filter="tableFilter"></table>
			    </div>
			  </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="../plugins/layui2.x/layui.js"></script>	
	
	<script type="text/javascript">
	var table; //layUI的渲染动态表格
	var currPageNum = 1;//当前页码
  
	function reloadTable(pageNum){
		//刷新表格内容
		table.reload('dbBackupListTable', {
		  page: {
		    curr: pageNum //当前页开始
		  } 
		});
	}

	    // layui方法
	    layui.use(['table', 'layer','element','laydate'], function () {
			
	        // 操作对象
	        table = layui.table;
	        var layer = layui.layer;
	        var $ = layui.jquery;
	        var laydate = layui.laydate;
	        var element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
          
	        //日期插件加载
	        laydate.render({ 
	            elem: '#startDate' 
	         });
	        //日期插件加载
	        laydate.render({ 
	            elem: '#endDate' 
	         });
	         
	        // 表格渲染
	        table.render({
			     elem: '#layTable'
			    ,cellMinWidth: 80//自适应列宽
			    ,cols: [[ 
			       //{type:'numbers' ,title: '序号'},
				  {field: 'title', title: '<span style="color:#000;font-weight:bold;">数据库日志</span>',align: 'center'}
			      ,{field: 'comment', title: '<span style="color:#000;font-weight:bold;">备份说明</span>',align: 'center'}		
			      ,{field: 'backupPath', title: '<span style="color:#000;font-weight:bold;">备份路径</span>',align: 'center'}
			      ,{field: 'creater', title: '<span style="color:#000;font-weight:bold;">备份者</span>',align: 'center'}
			      ,{field: 'createTime', title: '<span style="color:#000;font-weight:bold;">备份时间</span>',align: 'center'}
			      ,{field: 'restorer', title: '<span style="color:#000;font-weight:bold;">还原者</span>',align: 'center'}
			      ,{field: 'restoreTime', title: '<span style="color:#000;font-weight:bold;">还原时间</span>',align: 'center'}
			      ,{field: '', title: '<span style="color:#000;font-weight:bold;">操作</span>',align: 'center',toolbar: '#toolbar',width:200} 
			      ]]
	        	,url:'${pageContext.request.contextPath}/dbBackup/list'
	        	,id: 'dbBackupListTable'
	        	,where: {
	        	}//查询传参
			    //,skin: 'line' //表格风格
			    ,even: false  //隔行换色
			    ,size: 'sm' //小尺寸的表格
			    ,page: true  //开启分页
			    ,done: function(res, curr, count){
			        //如果是异步请求数据方式，res即为你接口返回的信息。
			        //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
			        //console.log(res);
			        //得到当前页码
			        //console.log(curr);
			        currPageNum = curr;
			        //得到数据总量
			       // console.log(count);
			        
			      }
			  });
	           	
			//页面刷新
	      	$("#btn-refresh").click(function(){
	      		
	      		
	      		//页面刷新
	      		table.reload('dbBackupListTable', {
	      		  page: {
	      		    curr: 1 //重新从第 1 页开始
	      		  }
	      		});
	    	});
	      	//多条件查询
	      	$("#btn-search").click(function(){
	      		//表格查询
	      		table.reload('dbBackupListTable', {
	      		  page: {
	      		    curr: 1 //重新从第 1 页开始
	      		  }
	      		  ,where: {
	      			//查询传参
	      		 startTime:$("#startDate").val(),
	      		endTime:$("#endDate").val()
	      		  }
	      		});
	      	}); 
	      	
	    	//添加 
	      	$("#btn-add").click(function(){
	      		layer.open({
	      		  type: 2 //Page层类型
	      		  ,area: ['70%', '70%']
	      		  ,title:  ['数据备份信息', '']
	      		  ,shade: 0.6 //遮罩透明度
	      		  ,fixed: true //位置固定
	      		  ,maxmin: false //开启最大化最小化按钮
	      		  ,anim: 5 //0-6的动画形式，-1不开启
	      		  ,content: 'dbBackupInfo.jsp'
	      	   });
	      	});
	    	//toolBar操作列监听
	      	 table.on('tool(tableFilter)', function(obj){
	      		var data = obj.data;
	      		
	      	    if(obj.event === 'restore'){
	      	    
	      	      //layer.msg('ID：'+ data.id + ' 的删除操作');
	      	    	layer.confirm('确认还原？', {
	      	    	  title: "确认消息", //标题
	      	    	  btnAlign: 'c',
	      	    	  btn: ['确认','取消'] //按钮
	      	    	}, function(){
	      	    		//还原
	      	    		$.ajax({
	        	  			method: "post",
	        	  			url:"${pageContext.request.contextPath}/dbBackup/save",
	        	  			data:{"id":data.id},
	        	  			success:function(result){
	        	  				if(null != result){
	        	  					if(1 == result.status){
		        		  				layer.msg('还原成功！', {time: 1000}); //1s后自动关闭
		        		  				//刷新表格内容
		        		  		        table.reload('dbBackupListTable', {
		        		  		          page: {
		        		  		            curr: currPageNum //从当前页开始
		        		  		          }      
		        		  		        });
		        	  				}else{
		        	  					layer.msg('还原失败！', {time: 1000}); //1s后自动关闭
		        	  				}
	        	  				}
	        	  				
	        	  	        }
	        			});
	      	    	   
	      	    	}, function(){
	      	    	  //取消
	      	    	});
	      	      
	      	    }
	      
	      	 });
	      	
	    });
	</script>
</body>
</html>
<script type="text/html" id="toolbar">
	<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="restore" style="font-size:10px;"><i class="layui-icon">&#x1002;</i>还原</a>
</script>