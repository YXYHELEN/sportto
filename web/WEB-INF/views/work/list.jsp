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
                <div class="row">
					<div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">作业信息列表</h4>
                            </div>
                                <div class="card-header">
                                    <form action="WorkServlet?action=WorkList"  method="post"  class="d-flex align-items-center">
                                        <div class="mb-2 mx-sm-3">
                                            <input type="text" name="key" value="${key }" class="form-control" placeholder="作业主题">
                                        </div>
                                        <button type="submit" class="btn btn-primary mb-2">查询</button>
                                    </form>
                                </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered table-responsive-md" >
                                        <thead> 
                                            <tr>
                                                <th><strong>作业主题</strong></th> 
                                                <th><strong>下载资料</strong></th> 
                                                <th><strong>发布时间</strong></th> 
                                                <th><strong>发布教师</strong></th> 
                                                <th><strong>操作</strong></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${list}" var="data">
                                            <tr>
                                                <td>${data.title }</td>
                                                <td><a style="color:red" href="WorkServlet?action=downLoad&url=${data.url }">点击下载</a></td>
                                                <td>${data.times }</td>
                                                <td>${data.teacher.name }</td>
                                                <td>
													<div class="d-flex">
													 <c:if test="${admin!=null || teacher!=null }">
														<a href="WorkServlet?action=toUpdateWork&id=${data.id }" class="btn btn-primary shadow btn-xs sharp me-1"><i class="fas fa-pencil-alt"></i></a>
														<a type="button" onclick="del(${data.id})" class="btn btn-danger shadow btn-xs sharp"><i class="fa fa-trash"></i></a>
													</c:if>
													</div>
												</td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                        
                                    </table>
                                    			<jsp:include page="/WEB-INF/common/page.jsp"/>
                                    
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
    <script>
       
    function del(id){
    	if(confirm("确定要删除吗？")){
    		$.ajax({
    			cache:true,
    			type : "post",
    			url : "WorkServlet?action=deleteWork",
    			 data :{"id":id},
    			async:false,
    			success : function(e) {
    				if (e == "yes") {
    					alert("删除成功！");
    			    	document.location.reload();//当前页面
    				} else{
    					alert("修改失败");
    				}
    			}
    		})
       	}
    }
    
    </script>
</body>
</html>