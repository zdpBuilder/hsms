<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>冰糕厂后台管理系统</title>
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
<link rel="stylesheet"
	href="../plugins/font-awesome/css/font-awesome.min.css">
</head>
<style>
body {
	overflow-y: scroll;
}
</style>
</head>
<body class="body">

	<div class="layui-fluid">
		<div class="layui-row layui-col-space10">

			<div class="layui-col-md12">
				<div class="layui-field-box">
					<!-- 操作按钮区域 -->
					<div class="my-btn-box" style="margin-bottom: -10px;">
						
					</div>
					<!-- 表格内容区域 -->
					<div class="layui-col-md12 layui-col-space1">
						<div id="container" style="min-width: 700px; height: 400px"></div>
					</div>
				</div>
			</div>
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
  $.post("../bill/intoOutCount", function(res){
	  //res=JSON.parse(res);
  if(res){
	  res=res.data;
	  if(res==null){
		 return; 
	  }
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
	                ['收入',  res.outCountPercent],
	                ['支出', res.intoCountPercent],
	            ]
	        }]
	    });
  }
  	 
  	   
	});   
});
</script>
</body>
</html>
