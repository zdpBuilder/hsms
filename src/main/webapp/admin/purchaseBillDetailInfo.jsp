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
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">品牌名称</label>
						 <div class="layui-input-inline" >
					           <select name="brandId" id="brandId" lay-verify="required" >
					            <option value="" selected >请选择</option>	            
					           </select>					             
	                     </div> 
	                     <div class="layui-input-inline" style="margin-left:16.5%">
					   <button type="button" class="layui-btn layui-btn-xs"   id="brand-btn-add" style="font-size: 10px;">
					   <i class="layui-icon"></i>品牌新增</button>
					      </div>   
					</div>	
					
								<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品规格</label>
						<div class="layui-input-inline">
							<input type="text" name="specification" id="specification" lay-verify="required|number"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
						  <label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品进价(箱)</label>
						<div class="layui-input-inline">
							<input type="text" name="purchasePrice" id="purchasePrice" lay-verify="required|Isdouble"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
						<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品支售价</label>
						<div class="layui-input-inline">
							<input type="text" name="saleBranchPrice" id="saleBranchPrice" lay-verify="required|Isdouble"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品箱售价</label>
						<div class="layui-input-inline">
							<input type="text" name="saleBoxPrice" id="saleBoxPrice" lay-verify="required|Isdouble"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					
		
						
		</fieldset>
		<fieldset class="layui-elem-field">
			<legend>商品进货信息</legend>	
				
                 <div class="layui-form-item" style="margin-bottom: 3px;">
                    <label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">入库箱数量</label>
						<div class="layui-input-inline">
							<input type="text" name="boxNum" id="boxNum" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
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
	function reloadBrand(title){
		 //品牌列表获取
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
	  						for(var i=0;i<result.length;i++){
	  							if(result[i].title==title){
	  								$("#brandId").val(result[i].id);	
	  							}
	  						} 
	  					  form.render();
	  					 }
	  					 
	  				 }	 
	  			}
	        }); 
		
	}
	
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
   
    
       //品牌列表获取
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
      
   	  var goodsData=sessionStorage.getItem('goodsData');
       if(typeof (goodsData)!="undefined" && goodsData!=null&&goodsData!=""){
           goodsData=JSON.stringify(goodsData);
           $("#goodsCode").val(goodsData.goodsCode);
	       $("#brandId").val(goodsData.brandId);
	       $("#title").val(goodsData.title);
     	   $("#saleBranchPrice").val(goodsData.saleBranchPrice);
     	   $("#saleBoxPrice").val(goodsData.saleBoxPrice);
     	   $("#specification").val(goodsData.specification);
     	   $("#purchasePrice").val(goodsData.purchasePrice);
     	  renderForm(); 
       }
   	 //表单元素赋值
	       var billDetailData = sessionStorage.getItem('billDetailData');
			 if(typeof (billDetailData)!="undefined" && billDetailData!=null&&billDetailData!=""){
				 console.info(billDetailData);
				 var data=JSON.parse(billDetailData);
	     	  $("#goodsCode").val(data.goodsCode);
	     	  $("#brandId").val(data.brandId);
	     	  $("#title").val(data.title);
	     	  $("#transaction").val(data.transaction);
	     	  $("#boxNum").val(data.boxNum);
	     	  $("#saleBranchPrice").val(data.saleBranchPrice);
	     	  $("#saleBoxPrice").val(data.saleBoxPrice);
	     	  $("#specification").val(data.specification);
	     	  $("#purchasePrice").val(data.purchasePrice);
	           //清空session
	             sessionStorage.setItem('billDetailData',0);
	             renderForm(); 
			 }
   	  //品牌新增
   	  $("#brand-btn-add").click(function(){
  	
     		  layer.open({
      		  type: 2 //Page层类型
      		  ,area: ['350px', '180px']
      		  ,title:  ['新增信息', '']
      		  ,shade: 0.6 //遮罩透明度
      		  ,fixed: true //位置固定
      		  ,maxmin: false //开启最大化最小化按钮
      		  ,anim: 5 //0-6的动画形式，-1不开启
      		  ,content: 'brandInfo.jsp?purchaseBillDetailisUsed=true'  //purchaseBillDetailisUsed true 表示明细新增  
      	   });
   	  });
      //进货订单总额清算
      $("#boxNum").keyup(function(){
    	  if($("#purchasePrice").val()==null||$("#purchasePrice").val()==""){ 		  
    		  return;
    	  }
    	  $("#transaction").val($("#boxNum").val()*$("#purchasePrice").val());
      });
    $("#purchasePrice").keyup(function(){
    	  if($("#boxNum").val()==null||$("#boxNum").val()==""){
    		  return;
    	  }
    	  
    	  $("#transaction").val($("#boxNum").val()*$("#purchasePrice").val());
    });
        //保存按钮
          form.on('submit(addForm)', function (data) {
        	  
            var formJson = data.field;
            formJson.brandTitle=$("#brandId").find("option:selected").text();
            
            //将保存的值传入purchaseBillIInfo 进行渲染
            parent.initbillDetialDatas(formJson);
            
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