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
	<title>SPORTTO智慧体育</title>
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
                                <h4 class="card-title">新增作业</h4>
                            </div>
                            <div class="card-body">
                                <div class="basic-form">
                                    <form id="saveForm" enctype="multipart/form-data">
                                        <div class="mb-3">
                                            <label class="form-label">选择作业类型</label>
                                            <select class="default-select form-control wide" name="title" id="titleSelect" onchange="handleSelectChange()">
                                                <option value="仰卧起坐">仰卧起坐</option>
                                                <option value="引体向上">引体向上</option>
                                                <option value="立定跳远">立定跳远</option>
                                                <option value="日常锻炼">日常锻炼</option>
                                                <option value="其他">其他</option>
                                            </select>
                                        </div>
<%--                                        <div id="customTitleDiv" class="mb-3" style="display: none;">--%>
<%--                                            <label class="form-label">自定义作业类型</label>--%>
<%--                                            <input type="text" class="form-control" name="customTitle" id="customTitle">--%>
<%--                                        </div>--%>
                                        <div class="mb-3">
                                            <label class="form-label">是否为体测</label>
                                            <select class="default-select  form-control wide" name="test" value="yes">
                                                <option value="yes">是</option>
                                                <option value="no">否</option>
                                            </select>
                                        </div>
                                        <div class="mb-3">
                                            <label for="selection">是否有个数需求？</label>
                                            <select id="selection" name="selection" class="form-control" onchange="toggleNumberInput()">
                                                <option value="unlimited">不限个数</option>
                                                <option value="numberRequired">个数需求</option>
                                            </select>
                                        </div>
                                        <div id="numberInput" style="display: none;">
                                            <label for="num">要求个数</label>
                                            <input type="number" id="num" name="number" class="form-control" value="0"> <!-- 注意这里添加了 id="num" 并且 name 改为了 "num" -->
                                        </div>
                                        <div class="mb-3">
                                            <label for="selection">是否有时长需求？</label>
                                            <select id="selection2" name="selection2" class="form-control" onchange="toggleNumberInput()">
                                                <option value="unlimited">不限时长</option>
                                                <option value="timeRequired">个数时长</option>
                                            </select>
                                        </div>
                                        <div id="timeInput" style="display: none;">
                                            <label for="num">要求时长（单位：小时）</label>
                                            <input type="text" id="time" name="time" class="form-control" value="0"> <!-- 注意这里添加了 id="num" 并且 name 改为了 "num" -->
                                        </div>
                                        <div class="mb-3">
                                            <label for="cid">发布班级ID</label>
                                            <input type="text" id="cid" name="cid" class="form-control" value="0"> <!-- 注意这里添加了 id="num" 并且 name 改为了 "num" -->
                                        </div>
                                        <div class="mb-3">
                                                <label class="form-label">上传视频资料</label>
                                                <input type="file" name="file" class="form-control" >
                                            </div>
                                        
                                        
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
			url : "WorkServlet?action=addWork",
			 data : new FormData($('#saveForm')[0]),
			 processData: false,
			 contentType: false,
			//data : $("#saveForm").serialize(),
			async:false,
			success : function(e) {
				if (e == "yes") {
					alert("新增成功！");
					window.location.href = "WorkServlet?action=WorkList";
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
   <script type="text/javascript">
       function toggleNumberInput() {
           // 获取下拉菜单的值
           var selection = document.getElementById("selection").value;
           // 根据选择显示或隐藏number输入框
           if (selection == "numberRequired") {
               document.getElementById("numberInput").style.display = "block";
           } else {
               document.getElementById("numberInput").style.display = "none";
           }
           var selection2 = document.getElementById("selection2").value;
           // 根据选择显示或隐藏number输入框
           if (selection2 == "timeRequired") {
               document.getElementById("timeInput").style.display = "block";
           } else {
               document.getElementById("timeInput").style.display = "none";
           }
       }
   </script>
   <script>
       function handleSelectChange() {
           var titleSelect = document.getElementById("titleSelect");
           var selectedValue = titleSelect.value;
           var customTitleDiv = document.getElementById("customTitleDiv");
           if(selectedValue === "其他") {
               customTitleDiv.style.display = "block";
           } else {
               customTitleDiv.style.display = "none";
           }
       }
   </script>
   
</body>
</html>