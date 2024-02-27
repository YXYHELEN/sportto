package com.task.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.task.entity.Admin;
import com.task.entity.Student;
import com.task.service.StudentService;
import com.task.service.impl.StudentServiceImpl;
import com.task.util.WebUtils;


@WebServlet(name = "StudentServlet")

public class StudentServlet extends BaseServlet {
	
	
	StudentService StudentService = new StudentServiceImpl();

	/**
	 * 去修改学生
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toUpdateStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Student Student = StudentService.findStudentById(id);
		request.setAttribute("data", Student);
		request.getRequestDispatcher("/WEB-INF/views/student/update.jsp").forward(request, response);
	}

	/**
	 * 删除学生
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "no";
		String id = request.getParameter("id");
		StudentService.deleteStudent(id);
		message = "yes";
		response.getWriter().print(message);

	}

	/**
	 * 添加学生
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 处理注册
		String message = "no";
		Student Student = WebUtils.toBean(request.getParameterMap(), Student.class);
		//Student.setCreate_time(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		Student student = StudentService.selectStudentByKey(Student.getEno());
		if(student==null) {
			StudentService.addStudent(Student);
			message = "yes";
		}else {
			message = "is";
		}
	
		response.getWriter().print(message);

	}
	
	/***
	 * 去新增学生
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toAddStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/student/add.jsp").forward(request, response);
	}

	/**
	 * 学生列表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void StudentList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 跳转到社长列表界面
		String p = request.getParameter("p");// 接收页码
		String key = request.getParameter("key");// 接收页码
		Student Student = (Student)request.getSession().getAttribute("Student");
		System.out.print(p);
		int pageSize = 6;// 每页显示5条
		int pageNum = 1; // 默认第一页
		if (p != null) {
			pageNum = Integer.parseInt(p);
		}
		Map map = new HashMap<>();
		map.put("key", key);
		map.put("uid", Student!=null?Student.getId():null);
		// 调用分页查询
		List<Student> list = StudentService.getStudentPage(pageNum, pageSize, map);
		// 携带参数到页面
		request.setAttribute("list", list); // 绑定参数
		int nums = StudentService.queryStudentCount(map); // 查询总数
		// 计算总页数
		int totalPage = (nums % pageSize == 0) ? (nums / pageSize) : (nums / pageSize + 1);
		request.getSession().setAttribute("cp", pageNum); // 当前页
		request.getSession().setAttribute("tp", totalPage); // 总页数
		request.getSession().setAttribute("key", key); // 总页数
		request.getSession().setAttribute("url", "StudentServlet?action=StudentList"); 
		// 条件 值1：值2
		request.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(request, response); // 页面转发
	}

	/**
	 * 修改学生
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 查询个人信息
		String message = "no";
		Student Student = WebUtils.toBean(request.getParameterMap(), Student.class);
		StudentService.updateStudent(Student);
		message = "yes";
		response.getWriter().print(message);

	}

}
