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
                                <h4 class="card-title">新增教师</h4>
                            </div>
                            <div class="card-body">
                                <div class="basic-form">
                                    <form id="saveForm">
                                            <div class="mb-3">
                                                <label class="form-label">姓名</label>
                                                <input type="text" name="name" class="form-control" >
                                            </div>
                                            
                                              <div class="mb-3">
                                                <label class="form-label">教师号</label>
                                                <input type="text" name="tno" class="form-control" >
                                            </div>
                                            
                                              <div class="mb-3">
                                                <label class="form-label">密码</label>
                                                <input type="password" name="pwd" class="form-control" >
                                            </div>
                                                
		                                         <div class="mb-3">
		                                            <label class="form-label">性别:</label>
		                                            <select class="default-select  form-control wide" name="sex" >
		                                                <option value="男">男</option>
		                                                <option value="女">女</option>
		                                            </select>
		                                        </div> 
		                                            
                                            
                                              <div class="mb-3">
                                                <label class="form-label">年龄</label>
                                                <input type="number" name="age" class="form-control" >
                                            </div>
                                        
                                            
                                            
                                     <!--        <div class="mb-3">
                                                <label class="form-label">内容</label>
                                                <textarea class="form-control" rows="4" name="content"></textarea>
                                            </div>
                                             <div class="mb-3">
                                            <label class="form-label">类型:</label>
                                            <select class="default-select  form-control wide" name="type" >
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                            </select>
                                        </div> -->
                                <!--         
                                         <div class="mb-3">
                                                <label class="form-label">标题</label>
                                                <div class="img_cont">
												<img id="photo" style="width:250px;height:150px;"/>
													 <input type="file" id="img" >
												</div>
                                            </div> -->
                                            <button type="button" id="save" class="btn btn-primary mt-3">提交</button>
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
			url : "TeacherServlet?action=addTeacher",
			data : $("#saveForm").serialize(),
			async:false,
			success : function(e) {
				if (e == "yes") {
					alert("新增成功！");
					window.location.href = "TeacherServlet?action=TeacherList";
				}else if (e == "is") {
					alert("新增失败，教师号重复！");
				}else{
					alert("新增失败");
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