package com.task.entity;

public class Work {

	private Integer id;
	private String title;
	private String url;
	private String	times;
	private Integer tid;
	private Teacher teacher;


	public Integer getIstest() {
		return istest;
	}

	public void setIstest(Integer istest) {
		this.istest = istest;
	}

	private Integer istest;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	private Integer number;
	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	private float time;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
