package com.billion.vo;

/**
 * @author Billion
 * @create 2021-03-02 10:48
 */
public class Student {
	private String username;
	private Integer age;

	public Student() {
		System.out.println("调用构造器");
	}

	public String getUserame() {
		return username;
	}

	public void setUsername(String username) {
		System.out.println("setName" + username);
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		System.out.println("setAge" + age);
		this.age = age;
	}
}
