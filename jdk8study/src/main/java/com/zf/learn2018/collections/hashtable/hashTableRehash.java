package com.zfgod.learn2018.collections.hashtable;

import java.util.Hashtable;

/**
 * @author: zf
 * @Date: 2018-11-8  17:13
 */
public class hashTableRehash {

	public static void main(String[] args) {
		// 当达到阈值,将进行自动扩容 newCap = oldCap*2 + 1
		// 默认11, 0.75
		int cap = 4;
		Hashtable<Object, Object> hashtable = new Hashtable<>(cap);

		for(int i = 1; i<= cap + 1; i ++){
			hashtable.put("iadf" + i , "askdjf" + i);
		}

	}
}
