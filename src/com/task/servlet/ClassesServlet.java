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
import com.task.entity.Classes;
import com.task.service.ClassesService;
import com.task.service.impl.ClassesServiceImpl;
import com.task.util.WebUtils;


@WebServlet(name = "ClassesServlet")

public class ClassesServlet extends BaseServlet {
	
	
	ClassesService ClassesService = new ClassesServiceImpl();

	/**
	 * 去修改班级
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toUpdateClasses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Classes Classes = ClassesService.findClassesById(id);
		request.setAttribute("data", Classes);
		request.getRequestDispatcher("/WEB-INF/views/classes/update.jsp").forward(request, response);
	}

	/**
	 * 删除班级
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteClasses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "no";
		String id = request.getParameter("id");
		ClassesService.deleteClasses(id);
		message = "yes";
		response.getWriter().print(message);

	}

	/**
	 * 添加班级
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addClasses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 处理注册
		String message = "no";
		Classes Classes = WebUtils.toBean(request.getParameterMap(), Classes.class);
		//Classes.setCreate_time(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		ClassesService.addClasses(Classes);
		message = "yes";
		response.getWriter().print(message);

	}
	
	/***
	 * 去新增班级
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toAddClasses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/classes/add.jsp").forward(request, response);
	}

	/**
	 * 班级列表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void ClassesList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 跳转到社长列表界面
		String p = request.getParameter("p");// 接收页码
		String key = request.getParameter("key");// 接收页码
		Classes Classes = (Classes)request.getSession().getAttribute("Classes");
		System.out.print(p);
		int pageSize = 6;// 每页显示5条
		int pageNum = 1; // 默认第一页
		if (p != null) {
			pageNum = Integer.parseInt(p);
		}
		Map map = new HashMap<>();
		map.put("key", key);
		map.put("uid", Classes!=null?Classes.getId():null);
		// 调用分页查询
		List<Classes> list = ClassesService.getClassesPage(pageNum, pageSize, map);
		// 携带参数到页面
		request.setAttribute("list", list); // 绑定参数
		int nums = ClassesService.queryClassesCount(map); // 查询总数
		// 计算总页数
		int totalPage = (nums % pageSize == 0) ? (nums / pageSize) : (nums / pageSize + 1);
		request.getSession().setAttribute("cp", pageNum); // 当前页
		request.getSession().setAttribute("tp", totalPage); // 总页数
		request.getSession().setAttribute("key", key); // 总页数
		request.getSession().setAttribute("url", "ClassesServlet?action=ClassesList"); 
		// 条件 值1：值2
		request.getRequestDispatcher("/WEB-INF/views/classes/list.jsp").forward(request, response); // 页面转发
	}

	/**
	 * 修改班级
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateClasses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 查询个人信息
		String message = "no";
		Classes Classes = WebUtils.toBean(request.getParameterMap(), Classes.class);
		ClassesService.updateClasses(Classes);
		message = "yes";
		response.getWriter().print(message);

	}

}
