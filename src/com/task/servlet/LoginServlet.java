package com.task.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.task.entity.Admin;
import com.task.entity.Student;
import com.task.entity.Teacher;
import com.task.service.AdminService;
import com.task.service.impl.AdminServiceImpl;

public class LoginServlet extends BaseServlet{
	
	private AdminService service = new AdminServiceImpl();
	
    public LoginServlet() {
        super();
    }
    
	protected void login(HttpServletRequest request, HttpServletResponse response) throws Exception {//跳转到添加用户界�?
	    String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        String message = "no";
	  if(type != null && type.equals("1")){//admin
	    	Admin admin = service.selectAdmin(userName,password);
	    	 if (admin != null) {
	    		   message = "yes";
	    		   request.getSession().setAttribute("flag",1);
	               request.getSession().setAttribute("admin",admin);
             }
	    	 
	    }else  if(type != null && type.equals("2")){
	    	Student student = service.selectStudent(userName,password);
	    	 if (student != null) {
	    		   message = "yes";
	    		   request.getSession().setAttribute("flag",2);
	               request.getSession().setAttribute("student",student);
            }
	    	 
	    }else  if(type != null && type.equals("3")){
	    	Teacher teacher = service.selectTeacher(userName,password);
	    	 if (teacher != null) {
	    		   message = "yes";
	    		   request.getSession().setAttribute("flag",3);
	               request.getSession().setAttribute("teacher",teacher);
           }
	    	 
	    }
	  response.getWriter().print(message);
	}
 
	 
	 protected void toMain(HttpServletRequest request, HttpServletResponse response) throws Exception {//跳转到添加用户界�?
	        request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request,response);
		}
	 
	
	protected void toMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {//跳转到添加用户界�?
	        request.getRequestDispatcher("/WEB-INF/views/menu.jsp").forward(request,response);
	}
	
	protected void toTop(HttpServletRequest request, HttpServletResponse response) throws Exception {//跳转到添加用户界�?
        request.getRequestDispatcher("/WEB-INF/views/top.jsp").forward(request,response);
	}
	
	protected void welcome(HttpServletRequest request, HttpServletResponse response) throws Exception {//跳转到添加用户界�?
        request.getRequestDispatcher("/WEB-INF/views/echarts.jsp").forward(request,response);
	}
	
	 protected void loginOut(HttpServletRequest request, HttpServletResponse response) throws Exception {//�?�?
	        request.getSession().invalidate();
	        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);

	  }
	 
	 protected void toRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {//跳转到添加用户界�?
	        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request,response);
		}
	 
}
