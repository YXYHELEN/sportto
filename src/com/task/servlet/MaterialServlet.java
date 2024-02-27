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

import com.task.entity.Material;
import com.task.service.MaterialService;
import com.task.service.impl.MaterialServiceImpl;
import com.task.util.MyUtil;
import com.task.util.WebUtils;


@WebServlet(name = "MaterialServlet")

public class MaterialServlet extends BaseServlet {
	
	
	MaterialService MaterialService = new MaterialServiceImpl();

	/**
	 * 去修改教学资料
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toUpdateMaterial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Material Material = MaterialService.findMaterialById(id);
		request.setAttribute("data", Material);
		request.getRequestDispatcher("/WEB-INF/views/material/update.jsp").forward(request, response);
	}

	/**
	 * 删除教学资料
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteMaterial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "no";
		String id = request.getParameter("id");
		MaterialService.deleteMaterial(id);
		message = "yes";
		response.getWriter().print(message);

	}

	/**
	 * 添加教学资料
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addMaterial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 处理注册
		String message = "no";
		//Material Material = WebUtils.toBean(request.getParameterMap(), Material.class);
		Material Material = fileUpload(request);
		Material.setTimes(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		MaterialService.addMaterial(Material);
		message = "yes";
		response.getWriter().print(message);

	}
	
	/***
	 * 去新增教学资料
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toAddMaterial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/material/add.jsp").forward(request, response);
	}
	
	/**
	 * 上传文件
	 * @param request
	 * @return
	 */
	private Material fileUpload(HttpServletRequest request) {
		Material ss = new Material();
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					BeanUtils.setProperty(ss, name, value);
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
	 * 教学资料列表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void MaterialList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 跳转到社长列表界面
		String p = request.getParameter("p");// 接收页码
		String key = request.getParameter("key");// 接收页码
		Material Material = (Material)request.getSession().getAttribute("Material");
		System.out.print(p);
		int pageSize = 6;// 每页显示5条
		int pageNum = 1; // 默认第一页
		if (p != null) {
			pageNum = Integer.parseInt(p);
		}
		Map map = new HashMap<>();
		map.put("key", key);
		map.put("uid", Material!=null?Material.getId():null);
		// 调用分页查询
		List<Material> list = MaterialService.getMaterialPage(pageNum, pageSize, map);
		// 携带参数到页面
		request.setAttribute("list", list); // 绑定参数
		int nums = MaterialService.queryMaterialCount(map); // 查询总数
		// 计算总页数
		int totalPage = (nums % pageSize == 0) ? (nums / pageSize) : (nums / pageSize + 1);
		request.getSession().setAttribute("cp", pageNum); // 当前页
		request.getSession().setAttribute("tp", totalPage); // 总页数
		request.getSession().setAttribute("key", key); // 总页数
		request.getSession().setAttribute("url", "MaterialServlet?action=MaterialList"); 
		// 条件 值1：值2
		request.getRequestDispatcher("/WEB-INF/views/material/list.jsp").forward(request, response); // 页面转发
	}

	/**
	 * 修改教学资料
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateMaterial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 查询个人信息
		String message = "no";
		//Material Material = WebUtils.toBean(request.getParameterMap(), Material.class);
		Material Material = fileUpload(request);
		MaterialService.updateMaterial(Material);
		message = "yes";
		response.getWriter().print(message);

	}

}
