package com.task.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.task.entity.Admin;
import com.task.entity.Work;
import com.task.entity.Teacher;
import com.task.entity.Work;
import com.task.service.TeacherService;
import com.task.service.WorkService;
import com.task.service.impl.TeacherServiceImpl;
import com.task.service.impl.WorkServiceImpl;
import com.task.util.MyUtil;
import com.task.util.WebUtils;


@WebServlet(name = "WorkServlet")

public class WorkServlet extends BaseServlet {
	
	
	WorkService WorkService = new WorkServiceImpl();
	
	TeacherService TeacherService = new TeacherServiceImpl();


	/**
	 * 去修改作业
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toUpdateWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Work Work = WorkService.findWorkById(id);
		request.setAttribute("data", Work);
		request.getRequestDispatcher("/WEB-INF/views/work/update.jsp").forward(request, response);
	}

	/**
	 * 删除作业
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "no";
		String id = request.getParameter("id");
		WorkService.deleteWork(id);
		message = "yes";
		response.getWriter().print(message);

	}
	
	
	/**
	 * 上传文件
	 * @param request
	 * @return
	 */
	private Work fileUpload(HttpServletRequest request) {
		Work ss = new Work();
		try {
			String time;
			String test="";
			String number;
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					BeanUtils.setProperty(ss, name, value);
					System.out.println(name+","+value);
				} else {
					String filename = item.getName();
					String savefilename = makeFileName(filename);
					if (filename != null && !filename.equals("")) {
						String savepath = "D:\\upload\\";
						InputStream in = item.getInputStream();
						FileOutputStream out = new FileOutputStream(savepath + "\\" + savefilename);
						int len = 0;
						byte buffer[] = new byte[1024];
						while ((len = in.read(buffer)) > 0) {
							out.write(buffer, 0, len);
						}
						in.close();
						out.close();
						item.delete();
						ss.setUrl("/images/"+savefilename);
					}
				}
			}
			return ss;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private String makeFileName(String filename) {
		String ext = filename.substring(filename.lastIndexOf(".") + 1);
		return UUID.randomUUID().toString() + "." + ext;
	}
	
	
	/**
	 * 下载文件
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void downLoad(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File downLoadFileDir = new File("D:\\upload");
		String aFileName = null;// 要下载的文件名
		FileInputStream in = null;
		ServletOutputStream out = null;
		request.setCharacterEncoding("utf-8");
		try {
			aFileName = request.getParameter("url");
			aFileName = aFileName.substring(7,aFileName.length());

			response.setHeader("Content-Type", "application/x-msdownload");// 设置下载文件使用的报头
			response.setHeader("Content-Disposition", "attachment;filename=" + MyUtil.toUTF8String(aFileName));
			in = new FileInputStream(downLoadFileDir + File.separator + aFileName);// 读入文件
			out = response.getOutputStream();// 得到输出流,用于向客户端输出二进制数据
			out.flush();
			int aRead = 0;
			byte b[] = new byte[1024];
			while ((aRead = in.read(b)) != -1 && in != null) {
				out.write(b, 0, aRead);
			}
			out.flush();
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
	



	/**
	 * 添加作业
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 处理注册
		String message = "no";
		Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
		//Work Work = WebUtils.toBean(request.getParameterMap(), Work.class);
		Work Work = fileUpload(request);
		Work.setTimes(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		if(teacher!=null) {
			Work.setTid(teacher.getId());
			WorkService.addWork(Work);
			message = "yes";
		}
		response.getWriter().print(message);

	}


	/***
	 * 去新增作业
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toAddWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/work/add.jsp").forward(request, response);
	}

	/**
	 * 作业列表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void WorkList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 跳转到社长列表界面
		String p = request.getParameter("p");// 接收页码
		String key = request.getParameter("key");// 接收页码
		Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
		System.out.print(p);
		int pageSize = 6;// 每页显示5条
		int pageNum = 1; // 默认第一页
		if (p != null) {
			pageNum = Integer.parseInt(p);
		}
		Map map = new HashMap<>();
		map.put("key", key);
		map.put("uid", teacher!=null?teacher.getId():null);
		// 调用分页查询
		List<Work> list = WorkService.getWorkPage(pageNum, pageSize, map);
		for(Work work:list) {
			work.setTeacher(TeacherService.findTeacherById(work.getTid().toString()));
		}
		// 携带参数到页面
		request.setAttribute("list", list); // 绑定参数
		int nums = WorkService.queryWorkCount(map); // 查询总数
		// 计算总页数
		int totalPage = (nums % pageSize == 0) ? (nums / pageSize) : (nums / pageSize + 1);
		request.getSession().setAttribute("cp", pageNum); // 当前页
		request.getSession().setAttribute("tp", totalPage); // 总页数
		request.getSession().setAttribute("key", key); // 总页数
		request.getSession().setAttribute("url", "WorkServlet?action=WorkList"); 
		// 条件 值1：值2
		request.getRequestDispatcher("/WEB-INF/views/work/list.jsp").forward(request, response); // 页面转发
	}

	/**
	 * 修改作业
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 查询个人信息
		String message = "no";
		Work Work = WebUtils.toBean(request.getParameterMap(), Work.class);
		WorkService.updateWork(Work);
		message = "yes";
		response.getWriter().print(message);

	}

}
