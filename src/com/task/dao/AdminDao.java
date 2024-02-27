package com.task.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.task.entity.Admin;
import com.task.entity.Student;
import com.task.entity.Teacher;
import com.task.util.C3p0Utils;

public class AdminDao {

	private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());

	public Admin selectAdmin(int parseInt) {
		try {//
            return runner.query("select * from admin where id=?", new BeanHandler<Admin>(Admin.class),parseInt);
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}

	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
            //执行插入sql
            runner.update("update admin set username=?,pwd=?,nickname=? where id=?",
            		admin.getUsername(),admin.getPwd(),admin.getNickname(),admin.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	public Admin selectAdmin(String username, String pwd) {
		try {//
            return runner.query("select * from admin where username=? and pwd=?", new BeanHandler<Admin>(Admin.class),username,pwd);
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}


	public Student selectStudent(String userName, String password) {
		try {//
            return runner.query("select * from student where eno=? and pwd=?", new BeanHandler<Student>(Student.class),userName,password);
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}

	public Teacher selectTeacher(String userName, String password) {
		try {//
            return runner.query("select * from teacher where tno=? and pwd=?", new BeanHandler<Teacher>(Teacher.class),userName,password);
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出运行异常
        }
	}

}
