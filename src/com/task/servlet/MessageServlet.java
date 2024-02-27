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
import com.task.entity.Message;
import com.task.entity.Student;
import com.task.entity.Teacher;
import com.task.service.MessageService;
import com.task.service.impl.MessageServiceImpl;
import com.task.util.WebUtils;


@WebServlet(name = "MessageServlet")

public class MessageServlet extends BaseServlet {
	
	
	MessageService MessageService = new MessageServiceImpl();

	/**
	 * 去修改留言
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toUpdateMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Message Message = MessageService.findMessageById(id);
		request.setAttribute("data", Message);
		request.getRequestDispatcher("/WEB-INF/views/message/update.jsp").forward(request, response);
	}

	/**
	 * 删除留言
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "no";
		String id = request.getParameter("id");
		MessageService.deleteMessage(id);
		message = "yes";
		response.getWriter().print(message);

	}

	/**
	 * 添加留言
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 处理注册
		Student student = (Student)request.getSession().getAttribute("student");
		Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
		
		String message = "no";
		Message Message = WebUtils.toBean(request.getParameterMap(), Message.class);
		Message.setTimes(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
        if(student!=null) {
        	Message.setName("学生："+student.getRealname());
		}
        if(teacher != null) {
        	Message.setName("教师："+teacher.getName());
        }
		MessageService.addMessage(Message);
		message = "yes";
		response.getWriter().print(message);

	}
	
	/***
	 * 去新增留言
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toAddMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/message/add.jsp").forward(request, response);
	}

	/**
	 * 留言列表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void MessageList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 跳转到社长列表界面
		String p = request.getParameter("p");// 接收页码
		String key = request.getParameter("key");// 接收页码
		Message Message = (Message)request.getSession().getAttribute("Message");
		System.out.print(p);
		int pageSize = 6;// 每页显示5条
		int pageNum = 1; // 默认第一页
		if (p != null) {
			pageNum = Integer.parseInt(p);
		}
		Map map = new HashMap<>();
		map.put("key", key);
		map.put("uid", Message!=null?Message.getId():null);
		// 调用分页查询
		List<Message> list = MessageService.getMessagePage(pageNum, pageSize, map);
		// 携带参数到页面
		request.setAttribute("list", list); // 绑定参数
		int nums = MessageService.queryMessageCount(map); // 查询总数
		// 计算总页数
		int totalPage = (nums % pageSize == 0) ? (nums / pageSize) : (nums / pageSize + 1);
		request.getSession().setAttribute("cp", pageNum); // 当前页
		request.getSession().setAttribute("tp", totalPage); // 总页数
		request.getSession().setAttribute("key", key); // 总页数
		request.getSession().setAttribute("url", "MessageServlet?action=MessageList"); 
		// 条件 值1：值2
		request.getRequestDispatcher("/WEB-INF/views/message/list.jsp").forward(request, response); // 页面转发
	}

	/**
	 * 修改留言
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 查询个人信息
		String message = "no";
		Message Message = WebUtils.toBean(request.getParameterMap(), Message.class);
		MessageService.updateMessage(Message);
		message = "yes";
		response.getWriter().print(message);

	}

}
