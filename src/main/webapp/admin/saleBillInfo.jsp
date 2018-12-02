<%@page import="com.hsms.utils.Const"%>
<%@ page language="java" import="com.hsms.utils.SNUtil"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String code="";
String  id=request.getParameter("id");
if(id==null){
	code =SNUtil.getSNNumber(Const.SUN_PURCHASE_CODE);	
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
			<input type="hidden" name="braName" id="braName"/>
		<input type="hidden" name="typeTitle" id="typeTitle"/>
		<c:if test="<%=id!=null%>">
			<input type="hidden" name="id" id="id" value="<%=id%>" />
		</c:if>
		<fieldset class="layui-elem-field">
			<legend>进货基本信息</legend>
			<div class=" layui-col-md12 layui-col-md-offset2">
		       <div class="layui-form-item" style="margin-bottom:3px;">
					<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">订单编号</label>
						<div class="layui-input-inline">
							<input type="text" disabled name="code" value="<%=code %>" id="code" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
	                     <label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">交易者</label>
						<div class="layui-input-inline">
							<input type="text" name="creater" value="${CurrentLoginUserInfo.loginId}" disabled id="creater" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
							
                    </div>
                    <div class="layui-form-item">
                    <label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">供应商</label>
                    <div class="layui-input-inline">
                    <select id="supplierId"  lay-search="" lay-verify="required" >
				          <option value="">请选择</option>
				         </select>
				         </div>
				         
				         <label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">订单总额</label>
						<div class="layui-input-inline">
							<input type="text" disabled value="0" name="transaction" id="transaction" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>	
				          </div>
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
			             <input type="text" autofocus="autofocus"  name="goodsCodeScan" id="goodsCodeScan" lay-verify="required"
								placeholder="请输入或者扫描商品编码" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
				          </div>
		                <button type="button"class="layui-btn layui-btn-xs"  id="btn-add" style="font-size: 10px;"><i class="layui-icon"></i>入库新增</button>
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
	var table; //layUI的渲染动态表格
	var currPageNum = 1;//当前页码
	 var billDetialDatas=[];  //账单列表详情
	 var transaction=0;       //订单总额
    
	
	 
	 function initbillDetialDatas(goodsAddData){
		 
		   var checkStatus=true;//商品入库校验状态量 true 表示未入库可以入库   false 表示已经入库
		    //商品入库校验
	    	for(var i=0;i<billDetialDatas.length;i++){
	    		if(billDetialDatas[i].id==goodsAddData.id){
	    			isUsed=false;
	  				layer.msg('商品已经入库！', {time: 1000}); //1s后自动关闭
	    		}
	    	}
	   
	    	if(isUsed){
	    		//预加载数据添加
	    		billDetialDatas.push(goodsAddData);
	  		   //预加载订单总额添加
	 		    transaction=transaction+goodsAddData.branchBidPrice*goodsAddData.branchCount+goodsAddData.boxBidPrice*goodsAddData.boxCount;			  		  	
	    	 $("#transaction").val(transaction);
	    	 table.reload('goodsListTable',{data:billDetialDatas});
	    }
	 }
	function reloadTable(pageNum){
		//刷新表格内容
		table.reload('tableListId', {
		  page: {
		    curr: pageNum //当前页开始
		  } 
		});
	}
    layui.use(['form', 'upload','layedit','table', 'laydate', 'element'], function () {
    	
    	
        var form = layui.form
                , layedit = layui.layedit
                , laydate = layui.laydate
                , element = layui.element
                , upload = layui.upload;
        table = layui.table;
        layer = layui.layer;
        $ = layui.jquery;
        var flag=1;
      //F2触发搜索事件
   	 document.onkeyup = function (e) {
   	 e = e ? e : event;// 兼容FF
   	
     	
   	 if (e.keyCode == 113) {
   		 
         goodsCodeScan.focus();
         if (typeof(e.target.value) != "undefined") { 
        	 ++flag; 
        	 $("#goodsCodeScan").val(e.target.value);
        	 if(flag%2==0) { 
        		 $("#btn-add").trigger("click");
        	 }
          } 
   	 return false;//防止页面跳转刷新掉
   	  }
   	 };
   	 

      //自定义表单验证
        form.verify({  
        	title:[/^.{0,30}$/,'请输入小于30个字的名称！'],
        	nameLength:[/^.{0,100}$/,'请输入小于100个字的描述！'],
        });
      //重新渲染表单
      function renderForm(){
    	  form.render();
      }
     
     
  
      //表单元素赋值
      var goodsId = <%=id %>;
      if(goodsId!=null){
    	  $.ajax({
  			method: "post",
  			data : {"id":goodsId},
  			url:"${pageContext.request.contextPath}/goods/show",
  			success:function(result){
  				if(null != result){
  					if(1 == result.status){
  						result = result.data;
  	 					$("#title").val(result.title);
  	 					$("#brandId").val(result.brandId);
  	 					$("#typeTitle").val(result.typeTitle);
  	 					$("#branchPrice").val(result.branchPrice);
  	 					$("#boxPrice").val(result.boxPrice);
  	 					$("#branchCount").val(result.branchCount);
  	 					$("#boxCount").val(result.boxCount);
  	 					$("#eachBoxNum").val(result.eachBoxNum);
  	 					$("#branchBidPrice").val(result.branchBidPrice);
  	 					$("#boxBidPrice").val(result.boxBidPrice);
  	 					$("#imgUrlIntoSql").val(result.imgUrl);
  	 					$("#braId").val(result.braId);
  	 					$("#braName").val(result.braName);
  	 					$("#note").val(result.note);
  	 					$("#code").val(result.code);
  	 					pohotoUrl='${pageContext.request.contextPath}/upload_files/goods_photo/'+result.imgUrl;
  	 	            	$("#preImg").html('<img style=" margin:20px 10px 0 10px;"src="'+pohotoUrl +'" width="240" height="250"/>');	
  	 					renderForm();
  					} else{
  						parent.layer.msg(result.msg, {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
  					}
  					
  				}
  				
  			}
        });   
      }   
      
    //添加 
    	$("#btn-add").click(function(){
    		if($("#goodsCodeScan").val()==""){
    			$("#goodsCodeScan").focus();
	       layer.msg('请输入或者扫描商品编码', {time: 1500}); //1s后自动关闭
    			return ;
    		}
    		
    		layer.open({
      		  type: 2 //Page层类型
      		  ,area: ['388px', '400px']
      		  ,title:  ['新增信息', '']
      		  ,shade: 0.6 //遮罩透明度
      		  ,fixed: true //位置固定
      		  ,maxmin: false //开启最大化最小化按钮
      		  ,anim: 5 //0-6的动画形式，-1不开启
      		  ,content: 'purchaseBillDetialInfo.jsp?id='+$("#goodsCodeScan").val()
      	   });
    		$("#goodsCodeScan").val("");
    		$("#goodsCodeScan").focus();
    	});
        //table
         // 表格渲染
	        table.render({
			     elem: '#layTable'
			    ,cellMinWidth: 80//自适应列宽
			    ,cols: [[ 
			       //{type:'numbers' ,title: '序号'},
			       {type: 'checkbox'}
				   ,{field: 'title', title: '<span style="color:#000;font-weight:bold;">品牌名称</span>',align: 'center'}
			      ,{field: 'creater', title: '<span style="color:#000;font-weight:bold;">创建者</span>',align: 'center'}
			      ,{field: 'createTime', title: '<span style="color:#000;font-weight:bold;">创建时间</span>',align: 'center'}
			      ,{field: 'updater', title: '<span style="color:#000;font-weight:bold;">更新者</span>',align: 'center'}
			      ,{field: 'updateTime', title: '<span style="color:#000;font-weight:bold;">更新时间</span>',align: 'center'}
			      ,{field: '', title: '<span style="color:#000;font-weight:bold;">操作</span>',align: 'center',toolbar: '#toolbar',width:200}
			    ]]
	        	,id:"tableListId" 	
	        	,data:billDetialDatas
			    ,even: true  //隔行换色
			    ,size: 'sm' //小尺寸的表格
			    ,page: true  //开启分页
			    ,done: function(res, curr, count){		     
			        console.info(res);
			        currPageNum = curr;	        
			      }
			  });
	     	//toolBar操作列监听
	      	 table.on('tool(tableFilter)', function(obj){
	      		var data = obj.data;
	      		
	      	    if(obj.event === 'del'){  
	      	    	layer.confirm('确认删除吗？', {
	      	    	  title: "确认消息", //标题
	      	    	  btnAlign: 'c',
	      	    	  btn: ['确认','取消'] //按钮
	      	    	}, function(){
	      	    		//单条删除   	   
	      	    	      //table删除
	      	    	       obj.del();
	      	    	      //数据删除
	      	    	     for(var i=0;i<billDetialDatas.length;i++){
	          	    		if(billDetialDatas[i].id==data.id){
	          	    		   //数据删除
	          	    			billDetialDatas.splice(i,1);	
	          	    		   //订单总额减少	          	    		   
	                           transaction=transaction-(data.branchBidPrice*data.branchCount+data.boxBidPrice*data.boxCount);	   	      	   	    			
	          	    		   $("#transaction").val(transaction);
	          	    		} 
	          	    	 }
	          	        //渲染表格数据
	          	    	table.reload('tableListId',{data:billDetialDatas});
	          	        
	      	    	}, function(){
	      	    	  //取消
	      	    	});
	      	      
	      	    }
	      	  	if(obj.event === 'edit'){
	      	      //编辑操作
	      	  	  //layer.msg('ID：'+ data.id + ' 的编辑操作');
	      	      layer.open({
	        		  type: 2 //Page层类型
	        		  ,area: ['350px', '180px']
	        		  ,title: ['编辑信息', '']
	        		  ,shade: 0.6 //遮罩透明度
	        		  ,fixed: true //位置固定
	        		  ,maxmin: false //开启最大化最小化按钮
	        		  ,anim: 5 //0-6的动画形式，-1不开启
	        		  ,content: 'brandInfo.jsp?id='+data.id
	        	   });
	      	      
	      	    }
	      	  	
	      
	      	 });
      
	      	//保存按钮
	          form.on('submit(addForm)', function (data) {
	            var formJson = data.field;      
	           if(billDetialDatas!=null&&billDetialDatas!=""){
	        	   formJson.goodsIds=JSON.stringify(billDetialDatas);
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
        
    });
</script>

	<!-- 操作列  -->
<script type="text/html" id="toolbar">
	<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit" style="font-size:10px;"><i class="layui-icon">&#xe642;</i>编辑</a>
	<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="del" style="font-size:10px;"><i class="layui-icon">&#xe640;</i>删除</a>
</script>
</body>
</html>