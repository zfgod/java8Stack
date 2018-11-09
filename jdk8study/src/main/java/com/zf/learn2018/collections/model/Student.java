package com.zfgod.learn2018.collections.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 2416890807161400935L;
	private String name;

	private int age;

	private String address;

	public Student(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o){
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Student Student = (com.zfgod.learn2018.collections.model.Student) o;
		return age == Student.age &&
				Objects.equals(name, Student.name);
	}

	/**
	 * 仅用user的name和age属性进行hashcode
	 * @return
	 */
	@Override
	public int hashCode() {

		return Objects.hash(name, age);
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
