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
			    <!-- 操作按钮区域 -->
		        <div class="my-btn-box" style="margin-bottom:-10px;">
		            <div class="fl" style="margin-top:5px;" >
		                <a  class="layui-btn layui-btn-xs" id="btn-add-into"><i class="layui-icon"></i>进货新增</a>
		                <a class="layui-btn layui-btn-xs" id="btn-delete-all" data-type="deleteBatch"><i class="layui-icon"></i>删除</a>
		                <a class="layui-btn layui-btn-xs" id="btn-refresh" data-type="refresh"><i class="layui-icon">&#x1002;</i>刷新</a>
		            </div>
		            <div class="fr" >            		
			
						 <div class="layui-input-inline">
		                    <input type="text" autocomplete="off" id="startDate" name="startDate" placeholder="开始时间" class="layui-input " style="height:26px;font-size:12px;"/>
		                </div> -
		                <div class="layui-input-inline">
		                    <input type="text" autocomplete="off" id="endDate" name="endDate" placeholder="结束时间" class="layui-input " style="height:26px;font-size:12px;"/>
		                </div>	
		                <div class="layui-input-inline">
		                    <input type="text" autocomplete="off" id="keywords" name="keywords" placeholder="订单编号" class="layui-input " style="height:26px;font-size:12px;"/>
		                </div> 
		                <button class="layui-btn layui-btn-xs" id="btn-search" style="font-size: 10px;"><i class="layui-icon" style="font-size: 14px;">&#xe615;</i>&nbsp;查询</button>
		            </div>
		        </div>
		        <!-- 表格内容区域 -->
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
		table.reload('billListTable', {
		  page: {
		    curr: pageNum //当前页开始
		  } 
		});
	}

	    // layui方法
	    layui.use(['table', 'layer','laydate'], function () {
			
	        // 操作对象
	        table = layui.table;
	        var layer = layui.layer;
	        var $ = layui.jquery;
	        var laydate = layui.laydate;
	        
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
			       {type: 'checkbox'}
			      ,{field: 'code', title: '<span style="color:#000;font-weight:bold;">订单编号</span>',align: 'center'}
			      ,{field: 'status', title: '<span style="color:#000;font-weight:bold;">订单类型</span>',align: 'center',templet: '#statusName'}		  
			      ,{field: 'transaction', title: '<span style="color:#000;font-weight:bold;">交易金额</span>',align: 'center'}		  
			      ,{field: '', title: '<span style="color:#000;font-weight:bold;">操作</span>',align: 'center',toolbar: '#toolbar'}
			    ]]
	        	,url:'${pageContext.request.contextPath}/bill/list'
	        	,id: 'billListTable'
	        	,where: {
	        		status:1,
	        		keywords: $("#keywords").val()
	        	}//查询传参
			    //,skin: 'line' //表格风格
			    ,even: true  //隔行换色
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
	        
	        
	      	//监听表格复选框选择
	        table.on('checkbox(tableFilter)', function(obj){     
	        /*   if(obj.checked == true){
	        	  $(this).parent().parent().parent().css("background-color","#CCC");
	          }else{
	        	  $(this).parent().parent().parent().css("background-color","#FFF");
	          }  */
	        });
	      	
	      	//进货添加 
	      	$("#btn-add-into").click(function(){
	      		layer.open({
	      		  type: 2 //Page层类型
	      		  ,area: ['100%', '100%']
	      		  ,title:  ['新增信息', '']
	      		  ,shade: 0.6 //遮罩透明度
	      		  ,fixed: true //位置固定
	      		  ,maxmin: false //开启最大化最小化按钮
	      		  ,anim: 5 //0-6的动画形式，-1不开启
	      		  ,content: 'purchaseBillInfo.jsp'
	      	   });
	      	});
	      	//批量删除
			$("#btn-delete-all").click(function(){
				
				var checkStatus = table.checkStatus('billListTable')
			    var data = checkStatus.data;//选中数据
			    
			    if(data.length>0){
			    	var codeStr = "";
			    	for(var i=0;i<data.length;i++){	
			    		codeStr = data[i].code + "," + codeStr;
			    	}
			    	layer.confirm('确认删除 '+data.length+' 条信息？', {
		      	    	  title: "确认消息", //标题
		      	    	  btn: ['确认','取消'] //按钮
		      	    	}, function(){
		      	    		//单条删除
		      	    		$.ajax({
		        	  			method: "post",
		        	  			url:"${pageContext.request.contextPath}/bill/deleteBatch",
		        	  			data:{"codeStr":codeStr},
		        	  			success:function(result){
		        	  				if(result.status==1){
		        		  				layer.msg('删除 '+data.length+' 条成功！', {time: 1000}); //1s后自动关闭
		      	    					
		        		  				//刷新表格内容
		        		  		        table.reload('billListTable', {
		        		  		          page: {
		        		  		            curr: currPageNum //从当前页开始
		        		  		          }
		        		  		          ,where: {
		        		  		        	//传参
		        		  		            keywords: $("#keywords").val()
		        		  		          }
		        		  		        });
		        		  				
		        	  				}else{
		        	  					layer.msg('删除失败！', {time: 1000}); //1s后自动关闭
		        	  				}
		        	  	        }
		        			});
		      	    	   
		      	    	}, function(){
		      	    	  //取消
		      	    	});
			    }else{	    	
			    	layer.msg('至少选中一条数据！', {time: 1000});  //1s后自动关闭
			    }
			    
	      	});
	     
	      	
	      	
			//页面刷新
	      	$("#btn-refresh").click(function(){
	      		//清空页面刷新条件
	      		$("#keywords").val("");
	      		$("#lineOrderStatus").val("");
	      		$("#intoOrOutStatus").val("");
	      		$("#startDate").val("");
	      		$("#endDate").val("");

	      		//页面刷新
	      		table.reload('billListTable', {
	      		  page: {
	      		    curr: 1 //重新从第 1 页开始
	      		  }
	      		});
	    	});
	      	//多条件查询
	      	$("#btn-search").click(function(){
	      		//表格查询
	      		table.reload('billListTable', {
	      		  page: {
	      		    curr: 1 //重新从第 1 页开始
	      		  }
	      		  ,where: {
	      			//查询传参
	      		   keywords: $("#keywords").val(),
	      		 lineOrderStatus:$("#lineOrderStatus").val(),
	      		intoOrOutStatus:$("#intoOrOutStatus").val(),
	      		startDate:$("#startDate").val(),
	      		endDate	:$("#endDate").val()
	      		  }
	      		});
	      	});
	      	
	      	//toolBar操作列监听
	      	 table.on('tool(tableFilter)', function(obj){
	      		var data = obj.data;  
	      	    if(obj.event === 'del'){
	      	    
	      	      //layer.msg('ID：'+ data.id + ' 的删除操作');
	      	    	layer.confirm('确认删除信息？', {
	      	    	  title: "确认消息", //标题
	      	    	  btnAlign: 'c',
	      	    	  btn: ['确认','取消'] //按钮
	      	    	}, function(){
	      	    		//单条删除
	      	    		$.ajax({
	        	  			method: "post",
	        	  			url:"${pageContext.request.contextPath}/bill/deleteBatch",
	        	  			data:{"codeStr":data.code},
	        	  			success:function(result){
	        	  				if(result.status==1){
	        		  				layer.msg('删除成功！', {time: 1000}); //1s后自动关闭
	      	    					//console.info(obj);
	        		  				//$(obj.tr).fadeOut();
	        		  				//刷新表格内容
	        		  		        table.reload('billListTable', {
	        		  		          page: {
	        		  		            curr: currPageNum //从当前页开始
	        		  		          }
	        		  		          ,where: {
	        		  		        	//传参
	        		  		            keywords: $("#keywords").val()
	        		  		          }
	        		  		        });
	        		  				
	        	  				}else{
	        	  					layer.msg('删除失败！', {time: 1000}); //1s后自动关闭
	        	  				}
	        	  	        }
	        			});
	      	    	   
	      	    	}, function(){
	      	    	  //取消
	      	    	});
	      	      
	      	    }
	      	  	if(obj.event === 'edit'){
	      	      //编辑操作
	      	  
		      		layer.open({
		      		  type: 2 //Page层类型
		      		  ,area: ['100%', '100%']
		      		  ,title:  ['编辑信息', '']
		      		  ,shade: 0.6 //遮罩透明度
		      		  ,fixed: true //位置固定
		      		  ,maxmin: false //开启最大化最小化按钮
		      		  ,anim: 5 //0-6的动画形式，-1不开启
		      		  ,content: 'purchaseBillInfo.jsp?billCode='+data.code
		      	   }); 
	      	    }
	      		if(obj.event === 'show'){
  
		      	      layer.open({
		        		  type: 2 //Page层类型
		        		  ,area: ['100%', '100%']
		        		  ,title: ['查看信息', '']
		        		  ,shade: 0.6 //遮罩透明度
		        		  ,fixed: true //位置固定
		        		  ,maxmin: false //开启最大化最小化按钮
		        		  ,anim: 5 //0-6的动画形式，-1不开启
		        		  ,content: 'purchaseBillInfoShow.jsp?billCode='+data.code
		        	   });
		      	      
		      	    }
	      
	      	 });
	      	
	    });
	</script>
	<!-- 操作列  -->
<!-- 		<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit" style="font-size:10px;"><i class="layui-icon">&#xe642;</i>编辑</a>
 -->	
<script type="text/html" id="toolbar">

	<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="show" style="font-size:10px;"><i class="layui-icon">&#xe615;</i>查看订单详情</a>
	<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit" style="font-size:10px;"><i class="layui-icon">&#xe642;</i>编辑</a>
	<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="del" style="font-size:10px;"><i class="layui-icon">&#xe640;</i>删除</a>
</script>
	<script type="text/html" id="statusName">
		{{#  if( d.status=== 1){ }} 
        进货
        {{#  } }} 
        
        {{#  if( d.status=== 2){ }}
       销售
        {{#  } }} 
	</script>
	
</body>
</html>
