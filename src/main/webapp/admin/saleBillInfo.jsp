<%@page import="com.hsms.utils.Const"%>
<%@ page language="java" import="com.hsms.utils.SNUtil"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String code=request.getParameter("billCode");
if(code==null){
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
			<input type="hidden" name="status" id="status" value="2"/>
			<input type="hidden" name="id" id="id" value="" />
		  
		 
		<fieldset class="layui-elem-field">
			<legend>销售基本信息</legend>
			<div class=" layui-col-md12 layui-col-md-offset1">
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
							<input type="text"  value="${CurrentLoginUserInfo.loginId}" disabled id="creater" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
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
			             <input type="text" autofocus="autofocus"   id="goodsCodeScan"
								placeholder="请输入或者扫描商品编码" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
				          </div>
		                <button type="button"class="layui-btn layui-btn-xs"  id="btn-add" style="font-size: 10px;"><i class="layui-icon"></i>手动录入</button>
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
	var $;
	 function initbillDetialDatas(goodsAddData){
	
		 for(var i=0;i<billDetialDatas.length;i++){		 
	    		if(billDetialDatas[i].goodsCode.trim()==goodsAddData.goodsCode.trim()){				
	    			billDetialDatas[i]=goodsAddData;	
	    			var transaction=0;
		    		for(var j=0;j<billDetialDatas.length;j++){		 
		    			transaction=parseFloat(transaction)+parseFloat(billDetialDatas[j].transaction);
			    	}
		    	
		  		   $("#transaction").val(transaction);
		    	   table.reload('tableListId',{data:billDetialDatas});
		    	   return;
	    		}
	    	}
	    		//预加载数据添加
	    		billDetialDatas.push(goodsAddData);
	  		   //预加载订单总额设置
	  		   var transaction=0;
	    		for(var i=0;i<billDetialDatas.length;i++){		 
	    			transaction=parseFloat(transaction)+parseFloat(billDetialDatas[i].transaction);
		    	}
	  		   $("#transaction").val(transaction);
	    	   table.reload('tableListId',{data:billDetialDatas});
    
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
       
        //因为扫码器扫一次会请求两次 去除重复
        var delRepeat=1;
      //F2触发搜索事件
   	 document.onkeyup = function (e) {
   	 e = e ? e : event;// 兼容FF
   	
     	
   	 if (e.keyCode == 113) {
   		  
         if (typeof(e.target.value) != "undefined") { 
         	++delRepeat;
         	if(delRepeat%2==0){
         	 //打印扫码器值	
         	 console.info(e.target.value);
        
        		 $.ajax({
      	 			method: "post",
      	 			data : {
      	 				"code":e.target.value
      	                   },
      	 			url:"../goods/getOneByCode",
      	 			success:function(result){
      	 		console.info(JSON.stringify(result));
     					 if(typeof(result.status)==="undefined"){
     	                        parent.layer.msg('数据异常', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
     					       return;
     					 }
     					 if(result.status==1){
     						 var flag=false;
     						
     						 for(var i=0;i<billDetialDatas.length;i++){
     							if(billDetialDatas[i].code==result.data.code){
     								flag=true;
     								billDetialDatas[i].branchNum++;
     								billDetialDatas[i].transaction=billDetialDatas[i].branchNum*billDetialDatas[i].saleBranchPrice;
     	     				       $("#transaction").val(parseFloat(billDetialDatas[i].transaction));

     							}
     						 }	
     				        if(!flag){
     				         var goods=result.data;
     				         if(typeof(goods.branchNum)=="undefined"){
     				        	goods.branchNum=0;
     				        	goods.transaction=0;
     				         }   
     				         goods.branchNum+=1;
     				        goods.transaction+= goods.branchNum* goods.saleBranchPrice;
     				        billDetialDatas.push(goods);
     				       $("#transaction").val(parseFloat(goods.transaction));
     				        }
     				        //清空扫码框
     				        $("#goodsCodeScan").val("");
 	    			        $("#goodsCodeScan").focus();
     				        //重载表格
     				       table.reload('tableListId',{data:billDetialDatas});
     				      flag=false;
     					 }else{
       		  			   layer.msg('该商品不存在或条形码扫描不正确！', {time: 1000}); //1s后自动关闭
       		  		        //清空扫码框
    				        $("#goodsCodeScan").val("");
	    			        $("#goodsCodeScan").focus();
     					 }
      	 				
      	 			}
      	       });  
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
 						if(null!=result.bill){		
 							$("#id").val(result.bill.id);
 	 	 					$("#creater").val(result.bill.creater);
 	 	 					$("#transaction").val(result.bill.transaction);
 	 	 					billDetialDatas=result.billDetailList;
 	 	 					renderForm();
 						}
 					
 					} else{
 						parent.layer.msg(result.msg, {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
 					}
 					
 				}
 				
 			}
       });   
     }    
      
    //添加 
    	$("#btn-add").click(function(){
    		var goodsCodeScan=$("#goodsCodeScan").val();
    		//商品编码空处理
    		if(goodsCodeScan==""){
    			$("#goodsCodeScan").focus();
	            layer.msg('请输入或者扫描商品编码', {time: 1500}); //1s后自动关闭
    			return ;
    		}
 		    //商品入库校验
 	    	for(var i=0;i<billDetialDatas.length;i++){
 	    		 console.info($.trim(billDetialDatas[i].code));
 	    		 console.info($.trim(goodsCodeScan));
 	    		if($.trim(billDetialDatas[i].goodsCode)==$.trim(goodsCodeScan)){	
 	    			layer.msg('商品已经加入缓存列表，如需修改，请点击修改！', {time: 1000}); //1s后自动关闭	
 	    			$("#goodsCodeScan").val("");
 	    			$("#goodsCodeScan").focus();
 	    			return;
 	    		}
 	    	}
    		
 	    	 $.ajax({
 	 			method: "post",
 	 			data : {
 	 				"code":goodsCodeScan
 	                   },
 	 			url:"../goods/getOneByCode",
 	 			success:function(result){
 	 				
					 if(typeof(result.status)==="undefined"){
	                        parent.layer.msg('数据异常', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
					       return;
					 }
					 if(result.status==1){
			      	     sessionStorage.setItem('goodsData', JSON.stringify(result.data)); 
						 layer.open({
				      		  type: 2 //Page层类型
				      		  ,area: ['700px', '350px']
				      		  ,title:  ['新增信息', '']
				      		  ,shade: 0.6 //遮罩透明度
				      		  ,fixed: true //位置固定
				      		  ,maxmin: false //开启最大化最小化按钮
				      		  ,anim: 5 //0-6的动画形式，-1不开启
				      		  ,content: 'saleBillDetailInfo.jsp?code='+goodsCodeScan
				      	   }); 
					 }else{
  		  			   layer.msg('该商品不存在或条形码扫描不正确！', {time: 1000}); //1s后自动关闭

					 }
 	 				
 	 			}
 	       });  
    		
    	});
        //table
         // 表格渲染
	        table.render({
			     elem: '#layTable'
			    ,cellMinWidth: 80//自适应列宽
			    ,cols: [[ 
			       //{type:'numbers' ,title: '序号'},
			       {type: 'checkbox'}
				  ,{field: 'goodsCode', title: '<span style="color:#000;font-weight:bold;">商品编码</span>',align: 'center'}
				  ,{field: 'title', title: '<span style="color:#000;font-weight:bold;">商品名称</span>',align: 'center'}
				  ,{field: 'brandTitle', title: '<span style="color:#000;font-weight:bold;">品牌名称</span>',align: 'center'}
				  ,{field: 'specification', title: '<span style="color:#000;font-weight:bold;">商品规格</span>',align: 'center'}
				  ,{field: 'saleBranchPrice', title: '<span style="color:#000;font-weight:bold;">商品支售价</span>',align: 'center'}
			      ,{field: 'saleBoxPrice', title: '<span style="color:#000;font-weight:bold;">商品箱售价</span>',align: 'center'}
			      ,{field: 'branchNum', title: '<span style="color:#000;font-weight:bold;">商品支数量</span>',align: 'center'}	 
			      ,{field: 'boxNum', title: '<span style="color:#000;font-weight:bold;">商品箱数量</span>',align: 'center'}	 
			      ,{field: 'transaction', title: '<span style="color:#000;font-weight:bold;">总金额</span>',align: 'center'}	 
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
	      	    	      //数据删除
	      	    	     for(var i=0;i<billDetialDatas.length;i++){
	          	    		if(billDetialDatas[i].code==data.code){  	    
	          	    			//数据删除
	          	    			billDetialDatas.splice(i,1);
	          	    			//订单总金额
	          	    			var transaction=0;
	        		    		for(var j=0;j<billDetialDatas.length;j++){		 
	        		    			transaction=Number(transaction)+Number(billDetialDatas[j].transaction);
	        			    	}
	        		  		   $("#transaction").val(transaction);
	        		    	   table.reload('tableListId',{data:billDetialDatas});
	          	    			//table删除
	 	      	    	        obj.del();
	          	    		   //弹出消息
        		  			   layer.msg('删除成功！', {time: 1000}); //1s后自动关闭
	          	    		} 
	          	    	 }  
	      	    	}, function(){
	      	    	  //取消
	      	    	});
	      	      
	      	    }
	      	  	if(obj.event === 'edit'){
	      	  	
	      	      //编辑操作	    
	      	      //初始化数据
	      	      data.edit=true;
	      	     billDetailData= JSON.stringify(data);
	      	     sessionStorage.setItem('goodsData', billDetailData);
	      	  	 layer.open({
	        		  type: 2 //Page层类型
	        		  ,area: ['700px', '350px']
	        		  ,title:  ['编辑信息', '']
	        		  ,shade: 0.6 //遮罩透明度
	        		  ,fixed: true //位置固定
	        		  ,maxmin: false //开启最大化最小化按钮
	        		  ,anim: 5 //0-6的动画形式，-1不开启
	        		  ,content: 'saleBillDetailInfo.jsp'
	        	   });
	      	      
	      	    }
	      	  	
	      
	      	 });
      
	      	//保存按钮
	          form.on('submit(addForm)', function (data) {
	            var formJson = data.field;      
	           if(billDetialDatas!=null&&billDetialDatas!=""){
	        	   var formData={};
	        	   formData.bill=formJson;
	        	   formData.billDetailList=billDetialDatas;
	        	   console.info(JSON.stringify(formData));

	           	 $.ajax({
	       			method: "post",
	       			url:"../bill/outStore",
	       			data: {
	       				"formData":JSON.stringify(formData)
	       			},
	       			async:false,
	       			success:function(result){
	       				var index = parent.layer.getFrameIndex(window.name);
	       				console.log(result+"结果");
	       				if(typeof(result.status)==="undefined"){
	                           parent.layer.msg('保存失败！', {title:'提示消息',icon: 0, time: 1500}); //1s后自动关闭);	                            	                       
                               parent.layer.close(index); 
	           	            return;
	   					}
	       				if(result.status==1){
	                       		//关闭窗口 并给父页面传值
	                               var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	                               parent.layer.msg('保存成功！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);                 
	                                parent.reloadTable(1);         	                       
	                               parent.layer.close(index); 		
	       				}else{
	       				 parent.layer.msg('保存失败！', {title:'提示消息',icon: 0, time: 1500}); //1s后自动关闭);
	       				 parent.layer.close(index);
                         return;
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