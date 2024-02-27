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
import com.task.entity.Teacher;
import com.task.service.TeacherService;
import com.task.service.impl.TeacherServiceImpl;
import com.task.util.WebUtils;


@WebServlet(name = "TeacherServlet")

public class TeacherServlet extends BaseServlet {
	
	
	TeacherService TeacherService = new TeacherServiceImpl();

	/**
	 * 去修改教师
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toUpdateTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Teacher Teacher = TeacherService.findTeacherById(id);
		request.setAttribute("data", Teacher);
		request.getRequestDispatcher("/WEB-INF/views/teacher/update.jsp").forward(request, response);
	}

	/**
	 * 删除教师
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "no";
		String id = request.getParameter("id");
		TeacherService.deleteTeacher(id);
		message = "yes";
		response.getWriter().print(message);

	}

	/**
	 * 添加教师
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 处理注册
		String message = "no";
		Teacher Teacher = WebUtils.toBean(request.getParameterMap(), Teacher.class);
		//Teacher.setCreate_time(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		Teacher data = TeacherService.selectTeacherByKey(Teacher.getTno());
		if(data==null) {
			TeacherService.addTeacher(Teacher);
			message = "yes";
		}else {
			message = "is";
		}
	
		response.getWriter().print(message);

	}
	
	/***
	 * 去新增教师
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toAddTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/teacher/add.jsp").forward(request, response);
	}

	/**
	 * 教师列表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void TeacherList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 跳转到社长列表界面
		String p = request.getParameter("p");// 接收页码
		String key = request.getParameter("key");// 接收页码
		Teacher Teacher = (Teacher)request.getSession().getAttribute("Teacher");
		System.out.print(p);
		int pageSize = 6;// 每页显示5条
		int pageNum = 1; // 默认第一页
		if (p != null) {
			pageNum = Integer.parseInt(p);
		}
		Map map = new HashMap<>();
		map.put("key", key);
		map.put("uid", Teacher!=null?Teacher.getId():null);
		// 调用分页查询
		List<Teacher> list = TeacherService.getTeacherPage(pageNum, pageSize, map);
		// 携带参数到页面
		request.setAttribute("list", list); // 绑定参数
		int nums = TeacherService.queryTeacherCount(map); // 查询总数
		// 计算总页数
		int totalPage = (nums % pageSize == 0) ? (nums / pageSize) : (nums / pageSize + 1);
		request.getSession().setAttribute("cp", pageNum); // 当前页
		request.getSession().setAttribute("tp", totalPage); // 总页数
		request.getSession().setAttribute("key", key); // 总页数
		request.getSession().setAttribute("url", "TeacherServlet?action=TeacherList"); 
		// 条件 值1：值2
		request.getRequestDispatcher("/WEB-INF/views/teacher/list.jsp").forward(request, response); // 页面转发
	}

	/**
	 * 修改教师
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 查询个人信息
		String message = "no";
		Teacher Teacher = WebUtils.toBean(request.getParameterMap(), Teacher.class);
		TeacherService.updateTeacher(Teacher);
		message = "yes";
		response.getWriter().print(message);

	}

}
