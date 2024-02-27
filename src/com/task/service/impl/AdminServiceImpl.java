package com.task.service.impl;

import com.task.dao.AdminDao;
import com.task.entity.Admin;
import com.task.entity.Student;
import com.task.entity.Teacher;
import com.task.service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDao dao = new AdminDao();

	@Override
	public Admin selectAdmin(int parseInt) {
		// TODO Auto-generated method stub
		return dao.selectAdmin(parseInt);
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		dao.updateAdmin(admin);
	}

	@Override
	public Admin selectAdmin(String username, String pwd) {
		// TODO Auto-generated method stub
		return dao.selectAdmin(username,pwd);
	}


	@Override
	public Student selectStudent(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.selectStudent(userName,password);
	}

	@Override
	public Teacher selectTeacher(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.selectTeacher(userName,password);
	}

}
