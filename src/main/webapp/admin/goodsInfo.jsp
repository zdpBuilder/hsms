<%@page import="com.hsms.utils.Const"%>
<%@ page language="java" import="com.hsms.utils.SNUtil"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String goodsCode="";
String  id=request.getParameter("id");
if(id==null){
	goodsCode =SNUtil.getSNNumber(Const.SUN_GOODS_CODE);	
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
	<input type="hidden" name="imgUrl" id="imgUrlIntoSql"/>
		<input type="hidden" name="braName" id="braName"/>
		<input type="hidden" name="typeTitle" id="typeTitle"/>
		<c:if test="<%=id!=null%>">
			<input type="hidden" name="id" id="id" value="<%=id%>" />
		</c:if>
		<fieldset class="layui-elem-field">
			<legend>基本信息</legend>
			
				<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品编码</label>
						<div class="layui-input-block">
							<input type="text" name="goodsCode" disabled id="goodsCode"  value="<%=goodsCode %>" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品名称</label>
						<div class="layui-input-block">
							<input type="text" name="title" id="title" lay-verify="required|username"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">品牌名称</label>
						 <div class="layui-input-block">
					           <select name="brandId" id="brandId" lay-verify="required" lay-filter="braIdSel">
					            <option value="" selected >请选择</option>	
          
					           </select>
	                     </div>
					</div>
					
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品进价</label>
						<div class="layui-input-block">
							<input type="text" name="purchasePrice" id="purchasePrice" lay-verify="required|number"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品支售价</label>
						<div class="layui-input-block">
							<input type="text" name="saleBranchPrice" id="saleBranchPrice" lay-verify="required|number"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品箱售价</label>
						<div class="layui-input-block">
							<input type="text" name="saleBoxPrice" id="saleBoxPrice" lay-verify="required|number"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品规格</label>
						<div class="layui-input-block">
							<input type="text" name="specification" id="specification" lay-verify="required|number"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
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

    layui.use(['form', 'upload','layedit', 'laydate', 'element'], function () {
    	
        var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate
                , element = layui.element
                , upload = layui.upload;
        var $ = layui.jquery;

      //自定义表单验证
        form.verify({  
        	title:[/^.{0,30}$/,'请输入小于30个字的名称！'],
        	nameLength:[/^.{0,100}$/,'请输入小于100个字的描述！'],
        	phone:[/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/,'输入的手机号码不合法！'],

        });
      //重新渲染表单
      function renderForm(){
    	  form.render();
      }
     

      
      //品牌列表
         $.ajax({
			method: "post",
			data : {
                 "page":0,
				    "limit":0,},
			url:"../brand/list",
			async:false,
			success:function(result){
				 if(result){
					 result=result.data;
					 if(result){
						for(var i=0;i<result.length;i++){
							$("#brandId").append('<option value="'+result[i].id+'">'+result[i].title+'</option>');	
						} 
						renderForm();
					 }
				 }
			}
     });
     
      
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
  	 					$("#purchasePrice").val(result.purchasePrice);
  	 					$("#saleBranchPrice").val(result.saleBranchPrice);
  	 					$("#saleBoxPrice").val(result.saleBoxPrice);
  	 					$("#specification").val(result.specification); 	
  	 					$("#goodsCode").val(result.goodsCode);
  	 					renderForm();
  					} else{
  						parent.layer.msg(result.msg, {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
  					}
  					
  				}
  				
  			}
        });   
      }
       
        //保存按钮
          form.on('submit(addForm)', function (data) {
            var formJson = data.field;
            	$.ajax({
        			method: "post",
        			url:"${pageContext.request.contextPath}/goods/save",
        			data: formJson,
        			async:false,
        			success:function(result){
        				if(null != result){
        					if(1 == result.status){
        						//关闭窗口 并给父页面传值
                                var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                                parent.layer.msg('保存成功！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);                 
                                 parent.reloadTable(1);         	                       
                                parent.layer.close(index); 
        					}else{
        						parent.layer.msg(result.msg, {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
                                return;
        					}
        				}else{
        					parent.layer.msg('保存失败！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
                            return;
        				}
        			},
        			error:function(){
        				parent.layer.msg('服务器异常！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
        			}
                });      
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