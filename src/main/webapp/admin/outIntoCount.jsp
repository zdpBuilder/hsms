<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>收入/支出饼状图</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="../plugins/layui2.x/css/layui.css"
	media="all" />
<link rel="stylesheet" href="../css/global.css" media="all">
<link rel="stylesheet" href="../css/style.css" media="all">
<link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="../plugins/layui2.x/css/layui.css" media="all" />
</head>
<style>
body {
	overflow-y: scroll;
	background-color:#F2F2F2;
}
	
.layuiadmin-badge, .layuiadmin-btn-group, .layuiadmin-span-color {
    position: absolute;
    right: 15px
}
.layuiadmin-badge {
    top: 50%;
    margin-top: -9px;
    color: #01AAED
}

.layuiadmin-card-list {
    padding: 15px
}

.layuiadmin-card-list p.layuiadmin-big-font {
    font-size: 36px;
    color: #666;
    line-height: 36px;
    padding: 5px 0 10px;
    overflow: hidden;
    text-overflow: ellipsis;
    word-break: break-all;
    white-space: nowrap
}

.layuiadmin-card-list p.layuiadmin-normal-font {
    padding-bottom: 10px;
    font-size: 20px;
    color: #666;
    line-height: 24px
}

.layuiadmin-span-color {
    font-size: 14px
}


</style>
</head>
<body class="body">

	<div class="layui-fluid">
	
	<div class="layui-row layui-col-space15">
      
      <div class="layui-col-sm6 layui-col-md3">
        <div class="layui-card">
          <div class="layui-card-header">
          总支出
            <span class="layui-badge layui-bg-blue layuiadmin-badge">付</span>
          </div>
          <div class="layui-card-body layuiadmin-card-list">
            <p class="layuiadmin-big-font"><label id="pay"></label></p>
       
          </div>
        </div>
      </div>
      <div class="layui-col-sm6 layui-col-md3">
        <div class="layui-card">
          <div class="layui-card-header">
            总收入
            <span class="layui-badge layui-bg-cyan layuiadmin-badge">收</span>
          </div>
          <div class="layui-card-body layuiadmin-card-list">
            <p class="layuiadmin-big-font"><label id="income"></label></p>
           
          </div>
        </div>
      </div>
      <div class="layui-col-sm6 layui-col-md3">
        <div class="layui-card">
          <div class="layui-card-header">
            盈利
            <span class="layui-badge layui-bg-green layuiadmin-badge">利</span>
          </div>
          <div class="layui-card-body layuiadmin-card-list">

            <p class="layuiadmin-big-font"><label id="payoff"></label></p>    
          </div>
        </div>
      </div>
      <div class="layui-col-sm6 layui-col-md3">
        <div class="layui-card">
          <div class="layui-card-header">
            亏损
            <span class="layui-badge layui-bg-orange layuiadmin-badge">亏</span>
          </div>
          <div class="layui-card-body layuiadmin-card-list">

            <p class="layuiadmin-big-font"><label id="lose"></label></p>   
          </div>
        </div>
      </div>   
      </div>
      
      
	<div class="layui-row layui-col-space15">
		<div id="container" style="min-width: 700px; height: 400px"></div>			
	</div>
</div>
	<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="../plugins/chart/js/highcharts.js"></script>
	<script type="text/javascript"
		src="../plugins/chart/js/highcharts-3d.js"></script>
	<script type="text/javascript"
		src="../plugins/chart/js/modules/exporting.js"></script>
	<script type="text/javascript">

/* function decimal(num,v){
	var vv = Math.pow(10,v);
	return Math.round(num*vv)/vv;
	} */
	
$(function () {
  $.post("../store/dataCount", function(res){
	  //res=JSON.parse(res);
  if(res){
	  res=res.data;
	  if(res==null){
		 return; 
	  }
	  $("#income").text(res.saleCount);
	  $("#pay").text(res.purchaseCount);
	  $("#payoff").text((res.saleCount-res.purchaseCount)>0?(res.saleCount-res.purchaseCount):"0.00");
	  $("#lose").text((res.saleCount-res.purchaseCount)<0?(res.saleCount-res.purchaseCount):"0.00");
	  $('#container').highcharts({
	        chart: {
	            type: 'pie',
	            options3d: {
	                enabled: true,
	                alpha: 45,
	                beta: 0
	            }
	        },
	        title: {
	            text: '开心超市收入/支出统计饼状图'
	        },
	        tooltip: {
	            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                depth: 35,
	                dataLabels: {
	                    enabled: true,
	                    format: '{point.name}'
	                }
	            }
	        },
	        series: [{
	            type: 'pie',
	            name: '开心超市销售统计',
	            data: [
	                ['收入',  res.saleCountPercent],
	                ['支出', res.purchaseCountPercent],
	            ]
	        }]
	    });
  }
  	 
  	   
	});   
});
</script>
</body>
</html>
