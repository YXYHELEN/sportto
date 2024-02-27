package com.task.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.task.entity.Admin;
import com.task.service.AdminService;
import com.task.service.impl.AdminServiceImpl;
import com.task.util.WebUtils;

public class AdminServlet extends BaseServlet{

	private AdminService service = new AdminServiceImpl();
	

	/**
	 * 修改管理员
	 * @param request
	 * @param response
	 */
	protected void updateAdmin(HttpServletRequest request, HttpServletResponse response) {
    	String message ="no";
    	Admin admin = WebUtils.toBean(request.getParameterMap(), Admin.class);
    	 try {
 			service.updateAdmin(admin);
 			message = "yes";
 			response.getWriter().print(message);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
	}

	/**
	 * 去修改管理员页面
	 * @param request
	 * @param response
	 */
	protected void toUpdateAdmin(HttpServletRequest request, HttpServletResponse response) {
	    try {
	    	String id = request.getParameter("id");
			Admin admin = service.selectAdmin(Integer.parseInt(id));
	    	request.setAttribute("adminDate", admin);
		    request.getRequestDispatcher("/WEB-INF/views/admin/update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
