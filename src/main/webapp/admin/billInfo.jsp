<%@ page language="java" import="yamp.com.util.SNUtil"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String  orderCode="";
String  id=request.getParameter("id");
String  intoOrOutStatus=request.getParameter("intoOrOutStatus");
if(id==null){
  orderCode =SNUtil.getSNNumber("CO");	
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>商品信息</title>
<link rel="stylesheet" href="../plugins/layui2.x/css/layui.css">
<link rel="stylesheet" href="../css/style.css">
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
</head>
<body class="body">

	<form class="layui-form" action="">	
	<input type="hidden" name="goodsIds" id="goodsIds"/>
	<input type="hidden" name="intoOrOutStatus" value="<%=intoOrOutStatus%>"/>
		<c:if test="<%=id!=null%>">
			<input type="hidden" name="id" id="id" value="<%=id%>" />
		</c:if>
		<fieldset class="layui-elem-field">
			<c:if test="<%=intoOrOutStatus.equals(\"0\")%>">
			 <legend>进货基本信息</legend>			
			</c:if>	
			<c:if test="<%=intoOrOutStatus.equals(\"1\")%>">
			 <legend>销售基本信息</legend>			
			</c:if>		
			<c:if test="<%=intoOrOutStatus.equals(\"1\")%>">
			<div class="layui-form-item" style="margin-bottom:3px;">
			<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">送货地址</label>
						<div class="layui-input-inline">
							<input type="text"  name="address"  id="address" 
								placeholder="" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
						 <label class="layui-form-label" style="font-size:12px;line-height:10px;">订单状态</label>
	         <div class="layui-input-inline">
	           <select name="lineOrderStatus" id="lineOrderStatus" lay-verify="required">
	            <option value="" selected >请选择</option>
	            <option value="0"  >未处理订单</option>
	            <option value="1">已处理订单</option>
	           </select>
	        </div>
			</div>	
				
			</c:if>	
					<div class="layui-form-item" style="margin-bottom:3px;">
					<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">订单编号</label>
						<div class="layui-input-inline">
							<input type="text" disabled name="orderCode" value="<%=orderCode %>" id="orderCode" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
	                     <label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">交易者</label>
						<div class="layui-input-inline">
							<input type="text" name="player" value="${CurrentLoginUserInfo.loginId}" disabled id="player" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">交易金额</label>
						<div class="layui-input-inline">
							<input type="text" disabled value="0" name="transaction" id="transaction" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>		
                    </div>
                				
		</fieldset>
		<fieldset class="layui-elem-field">
			<legend>交易商品信息</legend>
		   <div class="layui-col-md12">
	         <div class="layui-field-box">
			    <!-- 操作按钮区域 -->
		        <div class="my-btn-box" style="margin-bottom:-10px;">    
		            <div  style="margin-left:30%;">
		              <span class="layui-form-label" style="font-size:12px;vertical-align: top;line-height:10px;">商品编码</span>
		               
			           <div class="layui-input-inline">
			            <select id="goodsList"  lay-search="">
				          <option value="">直接选择或搜索选择</option>
				         </select>
				          </div>
		                <button type="button"class="layui-btn layui-btn-xs"  id="btn-add" style="font-size: 10px;"><i class="layui-icon"></i>新增</button>
		            </div>
		        </div>
		        <!-- 表格内容区域 -->
			    <div class="layui-col-md12 layui-col-space1">
					<table class="layui-hide" id="layTable" lay-size="sm" lay-filter="tableFilter"></table>
			    </div>
			  </div>
    </div>
		</fieldset>
		<div class="layui-form-item"
			style="text-align: center; margin-top: 10px;">
			<button class="layui-btn layui-btn-sm layui-btn-normal" lay-submit=""
				lay-filter="addForm">保存</button>
			&nbsp;&nbsp;
			<button class="layui-btn layui-btn-sm layui-btn-normal" id="close">取消</button>
		</div>
	</form>

	<script src="../plugins/layui2.x/layui.js" charset="utf-8"></script>
	<script type="text/javascript">
	   var goodsData=[];
	   var table; //layUI的渲染动态表格
	   var transaction=0;
	   var tableDataHTMl=[];
	    function initGoodsData(goodsAddData){
		   var isUsed=true;
	    	for(var i=0;i<goodsData.length;i++){
	    		if(goodsData[i].id==goodsAddData.id){
	    			isUsed=false;
	    		}
	    	}
	   
	    	if(isUsed){
	    		goodsData.push(goodsAddData);
	    		if(<%=intoOrOutStatus%>==0){
	    			
	 		    transaction=transaction+goodsAddData.branchBidPrice*goodsAddData.branchCount+goodsAddData.boxBidPrice*goodsAddData.boxCount;			
	    		}else{
	    			if(goodsAddData.branchCount>8||goodsAddData.boxCount>8){
	 	 		       transaction=transaction+(goodsAddData.branchPrice*goodsAddData.branchCount+goodsAddData.boxPrice*goodsAddData.boxCount)*0.8;			
	 	 		       
	    			}else{
	 	 		       transaction=transaction+goodsAddData.branchPrice*goodsAddData.branchCount+goodsAddData.boxPrice*goodsAddData.boxCount;				
	    			}
	    		}
	    	}
	    	
	    	document.getElementById("transaction").value=transaction;
	    	 table.reload('goodsListTable',{data:goodsData});
	    }
	    
		
    layui.use(['form', 'upload','layedit','table', 'laydate', 'element'], function () {
    	
        var form = layui.form
                
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate
                , element = layui.element
                , upload = layui.upload;
        var $ = layui.jquery;
        table = layui.table;
  
      
       
        laydate.render({
            elem: '#playerTime'
          });
      //重新渲染表单
      function renderForm(){
    	  form.render();
      }
       
      //表单元素赋值
      var billId = <%=id %>;
      if(billId!=null){
    	  $.ajax({
  			method: "post",
  			data : {"id":billId},
  			url:"../bill/show",
  			success:function(result){
  				result = result.data;
  				if(result){	
  					$("#address").val(result.address);
  					$("#lineOrderStatus").val(result.lineOrderStatus);
  					$("#orderCode").val(result.orderCode);
  					$("#transaction").val(result.transaction);
  					transaction=result.transaction;
  					$("#player").val(result.player);
  					goodsData=JSON.parse(result.goodsIds);
  					renderForm();
  	     	    	table.reload('goodsListTable',{data:goodsData});
  							
  				}
  			}
        });   
      }
       
        //保存按钮
          form.on('submit(addForm)', function (data) {
            var formJson = data.field;
           
           if(goodsData!=null&&goodsData!=""){
        	   formJson.goodsIds=JSON.stringify(goodsData);
           	$.ajax({
       			method: "post",
       			url:"../bill/save",
       			data: formJson,
       			async:false,
       			success:function(result){
       				if(result==null){
                           parent.layer.msg('保存失败！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
                           return;
   					}
       				if(result){
       					var data = result.data;
       					if(data<=0){
                               parent.layer.msg('保存失败！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
	                            return;
       					}
                       		//关闭窗口 并给父页面传值
                               var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                               parent.layer.msg('保存成功！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);                 
                                parent.reloadTable(1);         	                       
                               parent.layer.close(index); 		
       				}
       			},
               });        
           }else{
               parent.layer.msg('请添加商品！', {time: 1500}); //1s后自动关闭);   
              return;
           }
           
        });
        
        //关闭窗口按钮
        $("#close").click(function(){
        	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        	parent.layer.close(index);
        });
     if(<%=intoOrOutStatus%>==0){
    	 tableDataHTMl=[    
		      {field: 'goodsCode', title: '<span style="color:#000;font-weight:bold;">商品编码</span>',align: 'center',width:160}
		      ,{field: 'name', title: '<span style="color:#000;font-weight:bold;">商品名称</span>',align: 'center'}
		      ,{field: 'angName', title: '<span style="color:#000;font-weight:bold;">供应商</span>',align: 'center'}
		      ,{field: 'branchBidPrice', title: '<span style="color:#000;font-weight:bold;">商品支进价</span>',align: 'center'}
		      ,{field: 'boxBidPrice', title: '<span style="color:#000;font-weight:bold;">商品箱进价</span>',align: 'center'}
		      ,{field: 'branchPrice', title: '<span style="color:#000;font-weight:bold;">商品支单价</span>',align: 'center'}
		      ,{field: 'boxPrice', title: '<span style="color:#000;font-weight:bold;">商品箱单价</span>',align: 'center'}
		      ,{field: 'branchCount', title: '<span style="color:#000;font-weight:bold;">商品支数量</span>',align: 'center'}
		      ,{field: 'boxCount', title: '<span style="color:#000;font-weight:bold;">商品箱数量</span>',align: 'center'}
		      ,{field: '', title: '<span style="color:#000;font-weight:bold;">操作</span>',align: 'center',toolbar: '#toolbar'}
 
		    ];
    	 table.reload('goodsListTable',{data:goodsData});
     }
     if(<%=intoOrOutStatus%>==1){
    	 tableDataHTMl=[    
		      {field: 'goodsCode', title: '<span style="color:#000;font-weight:bold;">商品编码</span>',align: 'center',width:160}
		      ,{field: 'name', title: '<span style="color:#000;font-weight:bold;">商品名称</span>',align: 'center'}	  
		      ,{field: 'branchPrice', title: '<span style="color:#000;font-weight:bold;">商品支单价</span>',align: 'center'}
		      ,{field: 'boxPrice', title: '<span style="color:#000;font-weight:bold;">商品箱单价</span>',align: 'center'}
		      ,{field: 'branchCount', title: '<span style="color:#000;font-weight:bold;">商品支数量</span>',align: 'center'}
		      ,{field: 'boxCount', title: '<span style="color:#000;font-weight:bold;">商品箱数量</span>',align: 'center'}
		      ,{field: '', title: '<span style="color:#000;font-weight:bold;">操作</span>',align: 'center',toolbar: '#toolbar'}

		    ];
    	 table.reload('goodsListTable',{data:goodsData});
     }
        // 表格渲染
        table.render({
		     elem: '#layTable'
		    ,cellMinWidth: 80//自适应列宽
		    ,cols: [tableDataHTMl]
        	,data:goodsData
        	,id: 'goodsListTable'
        	,where: {
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
        //初始商品搜索
        $.ajax({
   			method: "post",
   			data : {"page":0,
   				    "limit":0,},
   			url:"../goods/list",
   			success:function(result){
   				 if(result){
   					 result=result.data;
   					 if(result){
   						for(var i=0;i<result.length;i++){
   							$("#goodsList").append('<option value="'+result[i].id+'">'+result[i].goodsCode+'</option>');	
   						} 
   						renderForm();
   					 }
   				 }
   			}
         });
   
      //添加 
      	$("#btn-add").click(function(){
      		if($("#goodsList").val()==""){
	  layer.msg('请先选择或输入商品编码！', {time: 1500}); //1s后自动关闭
      			return ;
      		}		
      		if(<%=intoOrOutStatus%>==0){
      			layer.open({
            		  type: 2 //Page层类型
            		  ,area: ['388px', '400px']
            		  ,title:  ['新增信息', '']
            		  ,shade: 0.6 //遮罩透明度
            		  ,fixed: true //位置固定
            		  ,maxmin: false //开启最大化最小化按钮
            		  ,anim: 5 //0-6的动画形式，-1不开启
            		  ,content: 'addIntoGoodsOrder.jsp?id='+$("#goodsList").val()
            	   });
      		}else{
      			layer.open({
            		  type: 2 //Page层类型
            		  ,area: ['388px', '400px']
            		  ,title:  ['新增信息', '']
            		  ,shade: 0.6 //遮罩透明度
            		  ,fixed: true //位置固定
            		  ,maxmin: false //开启最大化最小化按钮
            		  ,anim: 5 //0-6的动画形式，-1不开启
            		  ,content: 'addOutGoodsOrder.jsp?id='+$("#goodsList").val()
            	   });	
      		}
      		
      	});
      
     	//toolBar操作列监听
     	 table.on('tool(tableFilter)', function(obj){
     		var data = obj.data;
     	//确认订单
     		if(obj.event === 'setSign'){    
     			layer.confirm('确认修改订单处理状态？', {
	      	    	  title: "确认消息", //标题
	      	    	  btnAlign: 'c',
	      	    	  btn: ['确认','取消'] //按钮
	      	    	}, function(){	
   	  			   if(data.lineOrderStatus==1){
   	  				 data.lineOrderStatus=0; 
   	  			   }else{    	  			 
   	  				 data.lineOrderStatus=1;   
   	  			   }
   	  			   console.info(data);
	      	    		$.ajax({
	        	  			method: "post",
	        	  			url:"${pageContext.request.contextPath}/bill/save",
	        	  			data:data,
	        	  			success:function(result){    	
	        	  				if(result.data==1){
	        		  				layer.msg('修改成功！', {time: 1000}); //1s后自动关闭
	        		  				//刷新表格内容
	        		  		        table.reload('goodsListTable', {
	        		  		          page: {
	        		  		            curr: currPageNum //从当前页开始
	        		  		          }
	        		  		        });
	        	  				}else{
	        	  					layer.msg('修改失败！', {time: 1000}); //1s后自动关闭
	        	  					reloadTable(1);
	        	  				}
	        	  	        }
	        			}); 
	      	    	}, function(){
	      	    	  //取消
	      	    		 table.reload('goodsListTable', {
   		  		          page: {
   		  		            curr: currPageNum //从当前页开始
   		  		          }
   		  		        });
	      	    	});
     	    }
     	    if(obj.event === 'del'){	    
     	    	 obj.del();
     	    	 for(var i=0;i<goodsData.length;i++){
     	    		if(goodsData[i].id==data.id){
     	    			goodsData.splice(i,1);
     	    			if(<%=intoOrOutStatus%>==0){
                            transaction=transaction-(data.branchBidPrice*data.branchCount+data.boxBidPrice*data.boxCount);
     	   	    		}else{
     	   	    			if(data.branchCount>8||data.boxCount>8){
     	   	    			transaction=transaction-(data.branchPrice*data.branchCount+data.boxPrice*data.boxCount)/0.8;
     	      	   	    			}
                            transaction=transaction-(data.branchPrice*data.branchCount+data.boxPrice*data.boxCount);
     	   	    		}
     	    		   $("#transaction").val(transaction);
     	    		} 
     	    	 }
     	    	console.info(goodsData);
     	    	table.reload('goodsListTable',{data:goodsData});
     	    }    
     	 })
    });
    
</script>
<script type="text/html" id="toolbar">
	<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="del" style="font-size:10px;"><i class="layui-icon">&#xe640;</i>删除</a>
</script>
</body>
</html>