<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="keywords" content="" />
	<meta name="author" content="" />
	<meta name="robots" content="" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Fillow : Fillow Saas Admin  Bootstrap 5 Template" />
	<meta name="format-detection" content="telephone=no">
	<title>系统</title>
	<link rel="shortcut icon" type="image/png" href="images/favicon.png" />
	<link href="resource/vendor/jquery-nice-select/css/nice-select.css" rel="stylesheet">
    <link href="resource/css/style.css" rel="stylesheet">
</head>
<body>
   <div id="preloader">
		<div class="lds-ripple">
			<div></div>
			<div></div>
		</div>
    </div>
    <div id="main-wrapper">
		<jsp:include page="/WEB-INF/common/form_header.jsp"/>
        <jsp:include page="/WEB-INF/common/line.jsp"/>
       
        <div class="content-body">
            <div class="container-fluid">
				<!-- <div class="row page-titles">
					<ol class="breadcrumb">
						<li class="breadcrumb-item active"><a href="javascript:void(0)">Form</a></li>
						<li class="breadcrumb-item"><a href="javascript:void(0)">Element</a></li>
					</ol>
                </div> -->
                <!-- row -->
                <div class="row">
					
					<div class="col-xl-12 col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">表单</h4>
                            </div>
                            <div class="card-body">
                                <div class="basic-form">
                                    <form id="saveForm">
                                        <input name="id" id="id" value="${adminDate.id}" type="hidden" />
                                    
                                            <div class="mb-3">
                                                <label class="form-label">用户名</label>
                                                <input type="text" name="username" id="username" value="${adminDate.username}"  class="form-control" >
                                            </div>
                                    
                                            <div class="mb-3">
                                                <label class="form-label">昵称</label>
                                                <input type="text" name="nickname" id="nickname" value="${adminDate.nickname}"   class="form-control" >
                                            </div>
                                    
                                            <div class="mb-3">
                                                <label class="form-label">密码</label>
                                                <input type="password" name="pwd"  id="pwd" value="${adminDate.pwd}"   class="form-control" >
                                            </div>
                                        
                                            <button type="button" id="save" class="btn btn-primary mt-3">提交</button>
                                             <a href="AdminServlet?action=toUpdateAdmin&id=${adminDate.id}" class="btn btn-info mt-3" >重置</a>
                                    </form>
                                    
                                    
                                </div>
                            </div>
                        </div>
					</div>
                </div>
            </div>
        </div>
    </div>
    <script src="resource/vendor/global/global.min.js"></script>
	<script src="resource/vendor/jquery-nice-select/js/jquery.nice-select.min.js"></script>
	
    <script src="resource/js/custom.min.js"></script>
	<script src="resource/js/dlabnav-init.js"></script>
	<script src="resource/js/demo.js"></script>
    <script src="resource/js/styleSwitcher.js"></script>
    <script src="resource/layui/layui.js"></script>
    <script src="resource/layui/jquery-1.9.1.min.js"></script>
  <script>

layui.use([ 'form','jquery','layer','laydate' ], function() {
	var form = layui.form,
	 layer = layui.layer,
	 laydate=layui.laydate,
	 $= layui.jquery;
	 form.render();//这句一定要加，占坑
	 
	 $('#save').click(function(){  
		  var username = $.trim($('#username').val());
		  var pwd = $.trim($('#pwd').val());
		  var nickname = $.trim($('#nickname').val());
		  if(username == ''){  
		         layer.msg('用户名不能为空',{icon:6},function() {time:2000}); 
		         return false;  
		   }
		  if(pwd == ''){  
		         layer.msg('密码不能为空',{icon:6},function() {time:2000}); 
		         return false;  
		   }
		  if(nickname == ''){  
		         layer.msg('昵称不能为空',{icon:6},function() {time:2000}); 
		         return false;  
		   }
		  
		  $.ajax({
				cache : true,
				type : "post",
				url : "AdminServlet?action=updateAdmin",
				data : $("#saveForm").serialize(),
				async : false,
				success : function(e) {
					if (e == 'yes') {
						alert("修改成功！");
						window.parent.location.href = "LoginServlet?action=loginOut";
					} else {
						alert("修改失败！");
					}
				}
			})
	 });
   

});
</script>
   
   
   
</body>
</html>