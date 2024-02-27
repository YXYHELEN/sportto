<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  	<div class="nav-header">
            <a href="index.html" class="brand-logo">
				<svg class="logo-abbr" width="55" height="55" viewBox="0 0 55 55" fill="none" xmlns="http://www.w3.org/2000/svg">
					<path fill-rule="evenodd" clip-rule="evenodd" d="M27.5 0C12.3122 0 0 12.3122 0 27.5C0 42.6878 12.3122 55 27.5 55C42.6878 55 55 42.6878 55 27.5C55 12.3122 42.6878 0 27.5 0ZM28.0092 46H19L19.0001 34.9784L19 27.5803V24.4779C19 14.3752 24.0922 10 35.3733 10V17.5571C29.8894 17.5571 28.0092 19.4663 28.0092 24.4779V27.5803H36V34.9784H28.0092V46Z" fill="url(#paint0_linear)"/>
					<defs>
					</defs>
				</svg>
				<div class="brand-title">
					<h2 class="">作业管理系统</h2>
					<!-- <span class="brand-sub-title">作业管理系统</span> -->
				</div>
            </a>
            <div class="nav-control">
                <div class="hamburger">
                    <span class="line"></span><span class="line"></span><span class="line"></span>
                </div>
            </div>
        </div>
        
        <div class="header border-bottom">
            <div class="header-content">
                <nav class="navbar navbar-expand">
                    <div class="collapse navbar-collapse justify-content-between">
                        <div class="header-left">
							<div class="dashboard_bar">
                                作业管理系统
                            </div>
                        </div>
                        <ul class="navbar-nav header-right">
							<li class="nav-item dropdown  header-profile">
								<!-- <a class="nav-link" href="javascript:void(0);" role="button" data-bs-toggle="dropdown">
									<img src="resource/images/user.jpg" width="56" alt=""/>
								</a> -->
								<a class="nav-link" href="javascript:void(0);" role="button" data-bs-toggle="dropdown">
								<c:if test="${admin != null }">
								    欢迎管理员： ${admin.nickname }
								</c:if>
								 	<c:if test="${student != null }">
								    欢迎学生： ${student.realname }
								</c:if>
								 	<c:if test="${teacher != null }">
								    欢迎教师： ${teacher.name }
								</c:if>
								</a>
								<div class="dropdown-menu dropdown-menu-end">
									<a href="LoginServlet?action=loginOut" class="dropdown-item ai-icon">
										<svg id="icon-logout" xmlns="http://www.w3.org/2000/svg" class="text-danger" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4"></path><polyline points="16 17 21 12 16 7"></polyline><line x1="21" y1="12" x2="9" y2="12"></line></svg>
										<span class="ms-2">退出登录 </span>
									</a>
								</div>
							</li>
                        </ul>
                    </div>
				</nav>
			</div>
		</div>