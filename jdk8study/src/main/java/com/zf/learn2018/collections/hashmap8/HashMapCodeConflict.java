package com.zfgod.learn2018.collections.hashmap8;


import com.zfgod.learn2018.collections.model.Student;

import java.util.*;

/**
 * author: zf
 * Date: 2018-8-2  18:09
 * Description:
 */
public class HashMapCodeConflict {

	public static void main(String[] args) {

		HashMap<Object, Object> map = new HashMap<>(16);
		Student userA = new Student("a", 1, "addr1");
		Student userB = new Student("a", 1, "addr2");
		System.out.println("userA equals userB ?:" + userA.equals(userB));
		boolean hashCodeEquals = userA.hashCode() == userB.hashCode();
		System.out.println("hashCode of userA equals hashCode of userB ?:" + hashCodeEquals);

		map.put(userA, userA.getAddress());
		System.out.println("map: " + map);
		// same hashcode and  a equals b, only one
		map.put(userB, userB.getAddress());
		System.out.println("map: " + map);

		/**
		 * userA equals userB ?:true
		 * hashCode of userA equals hashCode of userB ?:true
		 * map: {com.zfgod.learn2018.model.Student@f81=addr1}
		 * map: {com.zfgod.learn2018.model.Student@f81=addr2}
		 */
	}


}