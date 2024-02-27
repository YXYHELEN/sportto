package com.task.service;

import com.task.entity.Admin;
import com.task.entity.Student;
import com.task.entity.Teacher;

public interface AdminService {

	Admin selectAdmin(int parseInt);

	void updateAdmin(Admin admin);
	
	Admin selectAdmin(String username,String pwd);

	Student selectStudent(String userName, String password);

	Teacher selectTeacher(String userName, String password);


}
