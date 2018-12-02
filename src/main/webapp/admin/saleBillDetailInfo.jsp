<%@ page language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String  id=request.getParameter("id");
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
			<legend>基本信息</legend>	
				<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品编码</label>
						<div class="layui-input-block">
							<input type="text"  name="code"  value=" <%=id%>" disabled id="code"  
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品名称</label>
						<div class="layui-input-block">
							<input type="text" name="name" id="name" disabled 
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>	
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">供应商名称</label>
						 <div class="layui-input-block">
					           <select name="angName" id="angName" lay-verify="required">
					            <option value="" selected >请选择</option>	            
					           </select>
	                     </div>
					</div>
						<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品支进价</label>
						<div class="layui-input-block">
							<input type="text" name="branchBidPrice" id="branchBidPrice" lay-verify="required|Isdouble"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品箱进价</label>
						<div class="layui-input-block">
							<input type="text" name="boxBidPrice" id="boxBidPrice" lay-verify="required|Isdouble"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品支单价</label>
						<div class="layui-input-block">
							<input type="text" name="branchPrice" id="branchPrice" lay-verify="required|Isdouble"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品箱单价</label>
						<div class="layui-input-block">
							<input type="text" name="boxPrice" id="boxPrice" lay-verify="required|Isdouble"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品箱个数</label>
						<div class="layui-input-block">
							<input type="text" name="eachBoxNum" id="eachBoxNum" lay-verify="required|IsIntegerPositive"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品支数量</label>
						<div class="layui-input-block">
							<input type="text" name="branchCount" id="branchCount" lay-verify="required|IsIntegerNotNagtive"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品箱数量</label>
						<div class="layui-input-block">
							<input type="text" name="boxCount" id="boxCount" lay-verify="required|IsIntegerNotNagtive"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
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

    layui.use(['form', 'upload','layedit', 'laydate', 'element'], function () {
    	
        var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate
                , element = layui.element
                , upload = layui.upload;
        var $ = layui.jquery;
       var goods=null;
       
       
         form.verify({  
        	 IsIntegerNotNagtive:[/^\d+$/,'请输入自然数！'],
        	 IsIntegerPositive:[/^[0-9]*[1-9][0-9]*$/,'请输入非零自然数！'],
        	 Isdouble: [/^(\d+\.\d{1,2}|[1-9][0-9]*)$/,'请输入非负非零的两位小数']
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
  			url:"../goods/show",
  			success:function(result){
  				result = result.data;
  				if(result){
  					goods=result;
  					$("#name").val(result.name);		
  					$("#goodsCode").val(result.goodsCode);		
  				}
  			}
        });   
      }
       //供应商下拉赋值
     
   	   $.ajax({
  			method: "post",
  			data : {"roleStatus":2,
  				    "page":0,
  				    "limit":0,},
  			url:"../braagntyp/list",
  			success:function(result){
  				 if(result){
  					 result=result.data;
  					 if(result){
  						for(var i=0;i<result.length;i++){
  							$("#angName").append('<option value="'+result[i].name+'">'+result[i].name+'</option>');	
  						} 
  						renderForm();
  					 }
  				 }
  			}
        });   
 
     
        //保存按钮
          form.on('submit(addForm)', function (data) {
        	  
        	  
            var formJson = data.field;
            if(formJson.branchCount==0&&formJson.boxCount==0){
                parent.layer.msg('箱数量和支数量不能同时为0！', {title:'提示消息',icon: 0, time: 1500}); //1s后自动关闭); 
            	return ;
            }
            goods.branchCount=formJson.branchCount;
            goods.boxCount=formJson.boxCount;
            goods.branchBidPrice=formJson.branchBidPrice;
            goods.boxBidPrice=formJson.boxBidPrice;
            goods.branchPrice=formJson.branchPrice;
            goods.boxPrice=formJson.boxPrice;
            goods["angName"]=formJson.angName;
            parent.initGoodsData(goods);
            //关闭窗口 并给父页面传值
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引                   	                       
            parent.layer.close(index);      
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