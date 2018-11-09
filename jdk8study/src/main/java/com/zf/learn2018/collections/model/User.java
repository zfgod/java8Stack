package com.zfgod.learn2018.collections.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author: zf
 * @Date: 2018-11-6  13:23
 */
public class User implements Serializable {

	private static final long serialVersionUID = 7405809996453237819L;

	private String name;

	private int age;

	private String address;

	public User(String name, int age, String address) {
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
		User user = (User) o;
		return age == user.age &&
				Objects.equals(name, user.name) &&
				Objects.equals(address, user.address);
	}

	/**
	 * 仅用user的name和age属性进行hashcode
	 * @return
	 */
	@Override
	public int hashCode() {

		return Objects.hash(name, age);
//		return Objects.hash(name, age, address);
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
