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
	<title>作业管理系统</title>
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
                                <h4 class="card-title">评阅作业</h4>
                            </div>
                            <div class="card-body">
                                <div class="basic-form">
                                    <form id="saveForm">
                                               <input type="hidden" name="id" value="${data.id }" >
                                    
                                             <div class="mb-3">
                                                <label class="form-label">评阅内容</label>
                                                <input type="text" name="note"  class="form-control" >
                                            </div>
                                        
                                            
                                                   <div class="mb-3">
                                                <label class="form-label">评阅分数</label>
                                                <input type="text" name="points"  class="form-control" >
                                            </div>
                                            
                                            <div class="mb-3">
		                                            <label class="form-label">评阅等级:</label>
		                                            <select class="default-select  form-control wide" name="type" >
		                                                   <option value="A">A</option>
		                                                   <option value="B">B</option>
		                                                   <option value="C">C</option>
		                                                   <option value="D">D</option>
		                                                   <option value="E">E</option>
		                                            </select>
		                                        </div>
                                            <button type="button" id="save" class="btn btn-primary mt-3">提交</button>
                                           <a href="XszyServlet?action=XszyList" class="btn btn-info   mt-3">返回</a>
                                           
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

	$("#save").click(function() {
		//swal("删除失败", "", "success")
		 $.ajax({
			cache:true,
			type : "post",
			url : "XszyServlet?action=updateXszy",
			data : $("#saveForm").serialize(),
			async:false,
			success : function(e) {
				if (e == "yes") {
					alert("评阅成功！");
					window.location.href = "XszyServlet?action=XszyList";
				}else{
					alert("评阅失败");
				}
			}
		})
	});


    $("#img").change(function () {
	    var img_src = URL.createObjectURL($(this)[0].files[0]);
	    document.getElementById("photo").src=img_src;
	});
</script>
   
   
   
</body>
</html>