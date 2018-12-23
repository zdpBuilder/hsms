<%@page import="com.hsms.utils.Const"%>
<%@ page language="java" import="com.hsms.utils.SNUtil"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

String  billCode=request.getParameter("billCode");

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
		
		<fieldset class="layui-elem-field">
			<legend>进货基本信息</legend>
			<div class=" layui-col-md12 layui-col-md-offset2">
		       <div class="layui-form-item" style="margin-bottom:3px;">
					<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">订单编号</label>
						<div class="layui-input-inline">
							<input type="text" disabled name="code" value="<%=billCode %>" id="code" lay-verify="required"
								
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
	                     <label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">交易者</label>
						<div class="layui-input-inline">
							<input type="text"  disabled value="" disabled id="creater" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
							
                    </div>
                    <div class="layui-form-item">
                    <label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">供应商</label>
                    <div class="layui-input-inline">
                    <select id="supplierId"  disabled name="supplierId"  lay-search="" lay-verify="required" >
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
		        <!-- 表格内容区域 -->
			    <div class="layui-col-md12 layui-col-space1">
					<table class="layui-hide" id="layTable" lay-size="sm" lay-filter="tableFilter"></table>
			    </div>
			  </div>
    </div>
		</fieldset>
		<div class="layui-form-item"
			style="text-align: center; margin-top: 10px;">	
			<button class="layui-btn layui-btn-sm layui-btn-normal" id="close">关闭</button>
		</div>
	</form>

	<script src="../plugins/layui2.x/layui.js" charset="utf-8"></script>
	<script type="text/javascript">
	var table; //layUI的渲染动态表格
	var currPageNum = 1;//当前页码
	var billDetialDatas=[];
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

      //重新渲染表单
      function renderForm(){
    	  form.render();
      }
     
     
      //供应商列表获取
 	   $.ajax({
			method: "post",
			data : {
                  "page":0,
				    "limit":0,},
			url:"../supplier/list",
			async:false,
			success:function(result){
				 if(result){
					 result=result.data;
					 if(result){
						for(var i=0;i<result.length;i++){
							$("#supplierId").append('<option value="'+result[i].id+'">'+result[i].name+'</option>');	
						} 
						renderForm();
					 }
				 }
			}
      });
      //表单元素赋值
      var  billCode=$("#code").val();
    if(billCode!=null){
    	  $.ajax({
  			method: "post",
  			data : {"billCode":billCode},
  			url:"${pageContext.request.contextPath}/bill/getBillIncludeBillDetailByBillCode",
  			async:false,
  			success:function(result){
  				if(null != result){
  					if(1 == result.status){
  						result = result.data;
  	 					$("#creater").val(result.bill.creater);
  	 					$("#transaction").val(result.bill.transaction);
  	 					$("#supplierId").val(result.bill.supplierId);
  	 					billDetialDatas=result.billDetailList;
  	 					renderForm();
  					} else{
  						parent.layer.msg(result.msg, {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
  					}
  					
  				}
  				
  			}
        });   
      }    
      
    
      
        //table
         // 表格渲染
	        table.render({
			     elem: '#layTable'
			    ,cellMinWidth: 80//自适应列宽
			    ,cols: [[ 
			       //{type:'numbers' ,title: '序号'},
			       {type: 'checkbox'}
				  ,{field: 'title', title: '<span style="color:#000;font-weight:bold;">商品名称</span>',align: 'center'}
				  ,{field: 'brandTitle', title: '<span style="color:#000;font-weight:bold;">品牌名称</span>',align: 'center'}
				  ,{field: 'specification', title: '<span style="color:#000;font-weight:bold;">商品规格</span>',align: 'center'}
				  ,{field: 'purchasePrice', title: '<span style="color:#000;font-weight:bold;">商品进价（按每箱）</span>',align: 'center',width:150}
			      ,{field: 'boxNum', title: '<span style="color:#000;font-weight:bold;">箱数量</span>',align: 'center'}
			      ,{field: 'transaction', title: '<span style="color:#000;font-weight:bold;">总金额</span>',align: 'center'}	 
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
	        
        //关闭窗口按钮
        $("#close").click(function(){
        	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        	parent.layer.close(index);
        });
        
    });
</script>
</body>
</html>