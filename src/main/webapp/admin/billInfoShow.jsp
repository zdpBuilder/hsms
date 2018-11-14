<%@ page language="java" 
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String  id=request.getParameter("id");
String  intoOrOutStatus=request.getParameter("intoOrOutStatus");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>订单信息</title>
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
							<input type="text"  name="address" disabled id="address" 
								placeholder="" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
						 <label class="layui-form-label" style="font-size:12px;line-height:10px;">订单状态</label>
	         <div class="layui-input-inline">
	           <select name="lineOrderStatus" disabled id="lineOrderStatus" lay-verify="required">
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
							<input type="text" disabled name="orderCode" value="" id="orderCode" lay-verify="required"
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
	var goodsData=[];
	var tableDataHTMl=[];
    layui.use(['form', 'upload','layedit','table', 'laydate', 'element'], function () {
    	
        var form = layui.form
                
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate
                , element = layui.element
                , upload = layui.upload;
        var $ = layui.jquery;
        table = layui.table;
     
       
      //重新渲染表单
      function renderForm(){
    	  form.render();
      }
       
      //关闭窗口按钮
      $("#close").click(function(){
     	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     	parent.layer.close(index);
     });
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
  					$("#player").val(result.player);
  					goodsData=JSON.parse(result.goodsIds);
  					renderForm();
  	     	    	table.reload('goodsListTable',{data:goodsData});					
  				}
  			}
        });   
      }
        
       
     
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
    });
    
</script>

</body>
</html>