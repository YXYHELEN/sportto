   <%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
        <div class="dlabnav">
            <div class="dlabnav-scroll">
				<ul class="metismenu" id="menu">
                   <li><a class="has-arrow " href="LoginServlet?action=toMain" >
							<i class="fas fa-home"></i>
							<span class="nav-text">首页</span>
						</a>
                    </li> 
                    
                    <c:if test="${admin != null }">
                    
                     <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">个人信息管理</span>
						</a>
                        <ul aria-expanded="true">
							<li><a href="AdminServlet?action=toUpdateAdmin&id=${admin.id }">修改个人信息</a></li>
                        </ul>
                    </li>
                   
					
                    <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">学生管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="StudentServlet?action=StudentList">学生列表</a></li>
							<li><a href="StudentServlet?action=toAddStudent">新增学生</a></li>
                        </ul>
                    </li>
                    
                          <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">教师管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="TeacherServlet?action=TeacherList">教师列表</a></li>
							<li><a href="TeacherServlet?action=toAddTeacher">新增教师</a></li>
                        </ul>
                    </li>
                    
                       
                          <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">班级管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="ClassesServlet?action=ClassesList">班级列表</a></li>
							<li><a href="ClassesServlet?action=toAddClasses">新增班级</a></li>
                        </ul>
                    </li>
                       
                          <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">公告管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="BoardServlet?action=BoardList">公告列表</a></li>
							<li><a href="BoardServlet?action=toAddBoard">新增公告</a></li>
                        </ul>
                    </li>
                    
                              <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">教学资料管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="MaterialServlet?action=MaterialList">教学资料列表</a></li>
							<li><a href="MaterialServlet?action=toAddMaterial">新增教学资料</a></li>
                        </ul>
                    </li>
                    
                           <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">留言管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="MessageServlet?action=MessageList">留言列表</a></li>
                        </ul>
                    </li>
                    
                    
                     </c:if>
                     
                         <c:if test="${teacher != null }">
					
                    
                          <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">个人信息管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="TeacherServlet?action=TeacherList">教师列表</a></li>
                        </ul>
                    </li>
                    
                       
                          <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">公告管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="BoardServlet?action=BoardList">查看公告</a></li>
                        </ul>
                    </li>
                    
                              <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">教学资料管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="MaterialServlet?action=MaterialList">教学资料列表</a></li>
                        </ul>
                    </li>
                    
                   <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">留言管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="MessageServlet?action=MessageList">留言列表</a></li>
                            <li><a href="MessageServlet?action=toAddMessage">去留言</a></li>
                        </ul>
                    </li>
                    
                             
                   <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">作业管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="WorkServlet?action=WorkList">作业列表</a></li>
                            <li><a href="WorkServlet?action=toAddWork">去新增作业</a></li>
                        </ul>
                    </li>
                    
                         <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">学生作业管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="XszyServlet?action=XszyList">学生作业列表</a></li>
                        </ul>
                    </li>
                    
                    
                     </c:if>
                     
                     
                     
                     
                        
                    <c:if test="${student != null }">
                    
					
                    <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">个人信息管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="StudentServlet?action=StudentList">我的个人信息</a></li>
                        </ul>
                    </li>
                    
                    
                       
                       
                          <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">公告管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="BoardServlet?action=BoardList">查看公告</a></li>
                        </ul>
                    </li>
                    
                              <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">教学资料管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="MaterialServlet?action=MaterialList">查看教学资料</a></li>
                        </ul>
                    </li>
                    
                           <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">留言管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="MessageServlet?action=MessageList">留言列表</a></li>
                            <li><a href="MessageServlet?action=toAddMessage">去留言</a></li>
                            
                        </ul>
                    </li>
                    
                        
                   <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">作业管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="WorkServlet?action=WorkList">查看作业列表</a></li>
                        </ul>
                    </li>
                    
                         <li><a class="has-arrow " href="javascript:void()" aria-expanded="false">
						<i class="fas fa-info-circle"></i>
							<span class="nav-text">学生作业管理</span>
						</a>
                        <ul aria-expanded="true">
                            <li><a href="XszyServlet?action=XszyList">我的作业列表</a></li>
                            <li><a href="XszyServlet?action=toAddXszy">上传作业</a></li> 
                        </ul>
                    </li>
                    
                     </c:if>
                     
                     
                     
                </ul>
                
				<div class="copyright">
					<p>2022泰迪专属</p>
				</div>
			</div>
        </div>
        <!--**********************************
            Sidebar end
        ***********************************-->