package com.zfgod.learn2018.collections.hashtable;

import java.util.Hashtable;
import java.util.concurrent.ExecutorService;

/**
 * @author: zf
 * @Date: 2018-11-8  16:58
 */
public class HashTableMethods {
	public static void main(String[] args) {
		// synchronized put/get/remove ,调用添加、获取、删除操作都是同步的
		// iterator 会快速失败，不被允许
		Hashtable<Object, Object> hashTable = new Hashtable<>();
		// hashTable到底是不是线程安全的呢？
		// 是,只不过其他线程必须等待,且每个开发者谨记hashTable不支持迭代过程做更新操作
		// 多线程 TODO
		hashTable.put("ad", "阿凡达");
		hashTable.put("ad1", "阿凡达");
		hashTable.put("ad2", "阿凡达");
		hashTable.put("ad3", "阿凡达");
		hashTable.get("ad");
		hashTable.remove("ad");

	}
}
