<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>登录</title>
<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="css/login.css" />
</head>

<body class="beg-login-bg">
	<div class="beg-login-box">
		<header>
			<h1>开心超市管理系统</h1>
		</header>
		<div class="beg-login-main">
			<form class="layui-form" method="post">
				<div class="layui-form-item">
					<label class="beg-login-icon"> <i class="layui-icon">&#xe612;</i>
					</label> <input type="text" name="loginId" lay-verify="required"
						autocomplete="off" placeholder="这里输入登录账号" class="layui-input">
				</div>
				<div class="layui-form-item">
					<label class="beg-login-icon"> <i class="layui-icon">&#xe642;</i>
					</label> <input type="password" name="password" lay-verify="required"
						autocomplete="off" placeholder="这里输入密码" class="layui-input">
				</div>
				<div class="layui-form-item">

					<div class="beg-pull-right" style="margin-right: 100px;">
						<button class="layui-btn layui-btn-primary" lay-submit=""
							lay-filter="login">
							<i class="layui-icon">&#xe650;</i> 登录
						</button>
					</div>
					<div class="beg-clear"></div>
				</div>
			</form>
		</div>
		<footer>
			<p>@copyRight WeiHuaLei</p>
		</footer>
	</div>
	<script type="text/javascript" src="plugins/layui/layui.js"></script>
	<script>
			layui.use(['layer', 'form'], function() {
				var layer = layui.layer,
					$ = layui.jquery,
					form = layui.form();
					
				form.on('submit(login)',function(data){
				    var formJson = data.field;
					$.ajax({
			   			method: "post",
			   			url:"${pageContext.request.contextPath}/login",
			   			data: formJson,
			   			success:function(result){	   		   
                       	if(result){
                       		console.info(result);
                       		if(null != result){
                       			if(1 == result.status){
                       				location.href='index.jsp';
                       			}else{
                       				layer.msg(result.msg,{title:'提示消息',icon: 2, time: 1500});
                       			}
                       		}
                       	}
			   			},
			   			error: function(){			
			                  layer.msg('服务器异常！', {title:'提示消息',icon: 0, time: 1500}); //1s后自动关闭);                          
			                  return;
			   			}
			           });  
					 return false; 
				});
			});
		</script>
</body>

</html>