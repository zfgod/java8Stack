package com.zfgod.learn2018.collections.hashmap8;

import com.zfgod.learn2018.collections.model.User;
import org.springframework.util.Assert;

import java.util.*;

/**
 * author: zf
 * Date: 2018-8-2  18:09
 * Description:
 */
public class HashMapAllCat {

	public static void main(String[] args) {
		// why need to init with a capacity? 省去rehash带来的数据结构重建
		  // If the initial capacity is greater than the maximum number of entries divided by the load factor, no rehash operations will ever occur--如果初始容量大于最大条目数除以负载因子，永远不会发生重哈希操作

		// initial capacity
		// load factor
		// its capacity is automatically increased  ： when get or put?
		// rehashed 内部数据结构重建   capacity * 2 ; 性能和安全方法有哪些影响？
		HashMap<Object, Object> map = new HashMap<>(16);
		User userA = new User("a", 1, "addr1");
		User userB = new User("a", 1, "addr2");
		System.out.println("userA equals userB ?:" + userA.equals(userB));
		boolean hashCodeEquals = userA.hashCode() == userB.hashCode();
		System.out.println("hashCode of userA equals hashCode of userB ?:" + hashCodeEquals);

		map.put(userA, userA.getAddress());
		System.out.println("map: " + map);
		// Note that using many keys with the same {@code hashCode()} is a sure way to slow down performance of any hash table
		// 使用相同hashCode的多个键去存储,肯定会降低hash表的效率
		map.put(userB, userB.getAddress());
		System.out.println("map: " + map);

		/**
		 * same hashcode but not equals , two key-value
		 * userA equals userB ?:false
		 * hashCode of userA equals hashCode of userB ?:true
		 * map: {com.zfgod.learn2018.model.User@f81=addr1}
		 * map: {com.zfgod.learn2018.model.User@f81=addr1, com.zfgod.learn2018.model.User@f81=addr2}
		 */

		// hashMap的实现不支持同步,使用方无法包装出同步操作时,需使用Collections的同步操作来包裹。
		Map m = Collections.synchronizedMap(new HashMap(16));

		m.put(userA, userA.getAddress());
		System.out.println(m);

		// 测试不支持同步
		HashMap<Object, Object> testUnConcurrentMap = new HashMap<>();
		testUnConcurrentMap.put("1", "asedf");
		testUnConcurrentMap.put("2", "asedf");
		testUnConcurrentMap.put("3", "asedf");
		testUnConcurrentMap.put("4", "asedf");
		Set<Object> keySet = testUnConcurrentMap.keySet();
		Iterator<Object> iterator = keySet.iterator();

		try{
			for (Object o : keySet) {
				testUnConcurrentMap.remove(o);
			}
		}catch (Exception exception){
			System.out.println("hashMap 迭代中操作发生同步修改异常：" + exception);
			Assert.isTrue(exception instanceof  ConcurrentModificationException, "hashMap不支持同步操作");
		}
	}


}