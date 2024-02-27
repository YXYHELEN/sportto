<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en" class="h-100">

<head>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="keywords" content="" />
	<meta name="author" content="" />
	<meta name="robots" content="" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Fillow : Fillow Saas Admin  Bootstrap 5 Template" />
	<meta name="format-detection" content="telephone=no">
	<title>作业管理系统</title>
	<link rel="shortcut icon" type="image/png" href="images/favicon.png" />
    <link href="resource/css/style.css" rel="stylesheet">
</head>

<body class="vh-100">
    <div class="authincation h-100">
        <div class="container h-100">
            <div class="row justify-content-center h-100 align-items-center">
                <div class="col-md-6">
                    <div class="authincation-content">
                        <div class="row no-gutters">
                            <div class="col-xl-12">
                                <div class="auth-form">
									<!-- <div class="text-center mb-3">
										<a href="index.html"><img src="images/logo-full.png" alt=""></a>
									</div> -->
                                    <h4 class="text-center mb-3">作业管理系统登录</h4>
                                    <form  id="loginForm" >
                                        <div class="mb-3">
                                            <label class="mb-1"><strong>用户名</strong></label>
                                            <input type="text" name="userName" id="userName" class="form-control" value="">
                                        </div>
                                        <div class="mb-3">
                                            <label class="mb-1"><strong>密码</strong></label>
                                            <input type="password" name="password" id="password"  class="form-control" value="Password">
                                        </div>
                                        <div class="row d-flex justify-content-between mt-4 mb-2">
                                            <div class="mb-3">
													<input type="radio" class="form-check-input" name="type" value="1" checked  id="basic_checkbox_1">
													<label class="form-check-label" for="basic_checkbox_1">管理员</label>
													 &nbsp; &nbsp; &nbsp; &nbsp;
													
													<input type="radio" class="form-check-input" name="type" value="2"    id="basic_checkbox_2">
													<label class="form-check-label" for="basic_checkbox_2">学生</label>
													 &nbsp; &nbsp; &nbsp; &nbsp; 
														<input type="radio" class="form-check-input" name="type" value="3"    >
													<label class="form-check-label" >教师</label>
												
                                            </div>
                                            
                                            
                                          <!--   <div class="mb-3">
                                                <a href="page-forgot-password.html">Forgot Password?</a>
                                            </div> -->
                                        </div>
                                        <div class="text-center">
                                            <button type="button" id="login"  class="btn btn-primary btn-block">登录</button>
                                        </div>
                                    </form>
                                   <!--  <div class="new-account mt-3">
                                        <p>Don't have an account? <a class="text-primary" href="resource/page-register.html">Sign up</a></p>
                                    </div> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="resource/vendor/global/global.min.js"></script>
    <script src="resource/js/custom.min.js"></script>
    <script src="resource/js/dlabnav-init.js"></script>
	<script src="resource/js/styleSwitcher.js"></script>
	<script src="resource/layui/jquery-1.9.1.min.js"></script>
	
</body>

<script>


$("#login").on("click", function() {
    var userName = $("#userName").val().trim(); // trim()去除空格
    var password = $("#password").val().trim();
    var type = $("#type").val();
    
    
    if(userName == ""){
    	
    	alert('用户名不能为空！');
    	return false;
    }
    if(password == ""){
    	alert('密码不能为空！');
    	return false;
    }
    if(type == ""){
    	alert('请选择角色！');
    	return false;
    }
    
    $.ajax({
		cache : true,
		type : "post",
		url : "LoginServlet?action=login",
		data : $("#loginForm").serialize(),
		async : false,
		success : function(e) {
			if (e == 'yes') {
				alert("登录成功！");
				window.parent.location.href = "LoginServlet?action=toMain";
			} else {
				alert("登录失败，账号或者密码错误！");
			}
		}
	})

});

</script>
</html>