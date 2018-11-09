package com.zfgod.learn2018.collections.hashtable;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: zf
 * @Date: 2018-11-8  15:44
 */
public class HashTableCat {

	public static void main(String[] args) {
		// 非null值 可以用作hashTab的key和value
		// 为了成功的存储和检索哈希表中的数据,要求用作key的对象必须实现hashCode方法和equals方法
		// 容量capacity and 负载因子load factor 影响着哈希表的实现过程
		// 当出现哈希冲突时,一个哈希桶将存储多个键值对数据,并且一个桶中有序存储--链表
		// rehash 重新散列实现-- 键值对存储数量达到阈值（容量*负载因子）
		// 负载因子默认0.75,高了会提升空间利用率,但是会增加查询和添加的时间复杂度
        // 初始化容量：初始化一个合适的容量,
		  // 当你的存储数量低于该容量对应的rehash阈值时,可以减少rehash操作的时间消耗
		  // 但是设置过大，无疑会带来空间浪费;但是如果存储量较大,应当初始化一个较大容量
		// 迭代过程进行自身提供的remove/put 方法将不被允许(同步修改异常)
        // 线程安全的实现 java.util.concurrent.ConcurrentHashMap
		Hashtable<Object, Object> hashTable = new Hashtable<>();
		// hashTable到底是不是线程安全的呢
		hashTable.put("ad", "阿凡达");
		hashTable.put("ad1", "阿凡达");
		hashTable.put("ad2", "阿凡达");
		hashTable.put("ad3", "阿凡达");
		Set<Map.Entry<Object, Object>> entries = hashTable.entrySet();
		try {
			for (Map.Entry<Object, Object> entry : entries) {
					hashTable.remove(entry.getKey());
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		hashTable.containsValue("");
		Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
		while (iterator.hasNext()){
			try {
				iterator.remove();
			}catch (Exception e){
				e.printStackTrace();
				break;
			}
		}

	}
}
