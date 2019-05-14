<%@ page language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
//商品编码
String  code=request.getParameter("code");
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
			<legend>商品基本信息</legend>	
				<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品编码</label>
						<div class="layui-input-inline">		
						<c:if test="<%=code!=null%>">
						<input type="text"  name="goodsCode"  value=" <%=code%>" disabled   
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</c:if>	
						<c:if test="<%=code==null%>">
						<input type="text"  name="goodsCode"  value="" disabled id="goodsCode"  
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</c:if>		
						</div>
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品名称</label>
						<div class="layui-input-inline">
							<input type="text" name="title" id="title"  
								 disabled  placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">品牌名称</label>
						<div class="layui-input-inline">
							<input type="text" name="brandTitle" id="brandTitle"  
								 disabled  placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品规格</label>
						<div class="layui-input-inline">
							<input type="text" name="specification" id="specification" lay-verify="required"
								disabled placeholder="必填项(1X24)" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>				     
						<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品支售价</label>
						<div class="layui-input-inline">
							<input type="text" name="saleBranchPrice" id="saleBranchPrice" lay-verify="required|Isdouble"
								disabled placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品箱售价</label>
						<div class="layui-input-inline">
							<input type="text" name="saleBoxPrice" id="saleBoxPrice" lay-verify="required|Isdouble"
								disabled placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					
		
						
		</fieldset>
		<fieldset class="layui-elem-field">
			<legend>商品销售信息</legend>	
				 <div class="layui-form-item" style="margin-bottom: 3px;">
                    <label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">销售支数量</label>
						<div class="layui-input-inline">
							<input type="text" value="0" name="branchNum" id="branchNum" lay-verify=""
								 autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
			       <label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">销售箱数量</label>
						<div class="layui-input-inline">
							<input type="text" name="boxNum" id="boxNum"  value="0" lay-verify=""
								 autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
			     </div>
                 <div class="layui-form-item" style="margin-bottom: 3px;">           
			     <label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">交易金额(元)</label>
						<div class="layui-input-inline">
							<input type="text" value="0" name="transaction" id="transaction" lay-verify="required"
								 disabled placeholder="0" autocomplete="off"
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


	var form;
	var $ ;
	
    layui.use(['form', 'upload','layedit', 'laydate', 'element'], function () {
    	
               form = layui.form;
           	   var layer = layui.layer;
               var layedit = layui.layedit
                , laydate = layui.laydate
                , element = layui.element
                , upload = layui.upload;
             $ = layui.jquery;
        //入库商品信息
       var billDetialData=null;
       
       
         form.verify({  
        	 IsIntegerNotNagtive:[/^\d+$/,'请输入自然数！'],
        	 IsIntegerPositive:[/^[0-9]*[1-9][0-9]*$/,'请输入非零自然数！'],
        	 Isdouble: [/^(\d+\.\d{1,2}|[1-9][0-9]*)$/,'请输入非负非零的两位小数']
      });
       //重新渲染表单
      function renderForm(){
    	  form.render();
      }
   
      
   	  var goodsData=sessionStorage.getItem('goodsData');
       if(typeof (goodsData)!="undefined" && goodsData!=null&&goodsData!=""){
           goodsData=JSON.parse(goodsData);
           $("#goodsCode").val(goodsData.goodsCode);
	       $("#brandTitle").val(goodsData.brandTitle);
	       $("#title").val(goodsData.title);
     	   $("#saleBranchPrice").val(goodsData.saleBranchPrice);
     	   $("#saleBoxPrice").val(goodsData.saleBoxPrice);
     	   $("#specification").val(goodsData.specification);
     	   if(typeof (goodsData.edit)!="undefined" && goodsData.edit==true){
     	      $("#boxNum").val(goodsData.boxNum);
 	     	  $("#branchNum").val(goodsData.branchNum);
 	     	  $("#transaction").val(goodsData.transaction);
     	   }
     	  sessionStorage.setItem('goodsData',0);
     	  renderForm(); 
       }

   	
			 
      //销售订单总额清算
      $("#boxNum").keyup(function(){
    	  if($("#boxNum").val()==null||$("#boxNum").val()==""){ 		  
    		  return;
    	  }
    	  $("#transaction").val("");
    	  $("#transaction").val($("#boxNum").val()*$("#saleBoxPrice").val()+ $("#branchNum").val()*$("#saleBranchPrice").val());
      });
    $("#branchNum").keyup(function(){
    	  if($("#branchNum").val()==null||$("#branchNum").val()==""){
    		  return;
    	  }
    	  $("#transaction").val("");
    	  $("#transaction").val($("#boxNum").val()*$("#saleBoxPrice").val()+ $("#branchNum").val()*$("#saleBranchPrice").val());
    });
        //保存按钮
          form.on('submit(addForm)', function (data) {
        	  
            var formJson = data.field;
            console.info(formJson);
            if(parseInt(formJson.branchNum.trim()) >= parseInt(formJson.specification.trim())){
            	parent.layer.msg("支数量不得大于规格", {title:'提示消息',icon: 2, time: 1500}); //1s后自动关闭);
            	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引                   	                       
                parent.layer.close(index);        
                return;        
            }
            //将保存的值传入purchaseBillIInfo 进行渲染
            $.post('../store/validateStore',
            	{goodsCode:formJson.goodsCode
            	,specification:formJson.specification
            	,boxNum:formJson.boxNum
            	,branchNum:formJson.branchNum},
            	function(result){
            	if(!result){
            		parent.layer.msg('库存不足！', {title:'提示消息',icon: 2, time: 1500}); //1s后自动关闭);
            		//关闭窗口 并给父页面传值
                    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引                   	                       
                    parent.layer.close(index);        
                    return;
            	}else{
            		 parent.initbillDetialDatas(formJson);
            		 //关闭窗口 并给父页面传值
                     var index = parent.layer.getFrameIndex(window.name); //获取窗口索引                   	                       
                     parent.layer.close(index); 
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