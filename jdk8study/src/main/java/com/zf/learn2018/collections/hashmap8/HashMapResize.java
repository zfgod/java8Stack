package com.zfgod.learn2018.collections.hashmap8;

import java.util.HashMap;

/**
 * @author: zf
 * @Date: 2018-11-8  11:40
 */
public class HashMapResize {

	public static void main(String[] args) {
		// 默认容量16,负载因子0.75,阈值12
		HashMap<Object, Object> hashMap = new HashMap<>();

		int threshold = 12;
		for (int i=0 ; i<= threshold; i++){
			hashMap.put(System.currentTimeMillis(), i);
		}
		/**
		 * 1. 检查现有hash表的容量capacity和阈值threshold并附新值
		 *    1.1 容量大于0
		 *        容量和阈值扩大2倍
		 *    1.2 容量<=0, 阈值大于0, 设置了阈值
		 *        容量 = 阈值。
		 *    1.3 使用默认配置
		 *        容量 = 16, 阈值 = 12
		 *
		 * 2. 如果重新赋值后的阈值 = 0 , 重新计算阈值=容量*0.75
		 *
		 * 3. 用新容量newCap新建数组newTab<Node>[]
		 *
		 * 4. 置换新数组为当前hashMap的数组
		 *
		 * 5. 老数组元素遍历添加到新数组  TODO
		 *
		 */
	}
}
