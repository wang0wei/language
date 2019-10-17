package com.bjsxt.test;

public class People {
	private Teacher teacher;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "People [teacher=" + teacher + "]";
	}

	public People(Teacher teacher) {
		super();
		this.teacher = teacher;
	}

	public People() {
		super();
	}
	
}
