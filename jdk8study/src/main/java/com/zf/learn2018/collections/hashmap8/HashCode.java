package com.zfgod.learn2018.collections.hashmap8;

/**
 * @author: zf
 * @Date: 2018-11-7  17:54
 */
public class HashCode {

	public static void main(String[] args) {
		int h;
		String key = "abc";
		// jdk1.8中hashMap计算hashCode值96355
		// jdk1.7 = 93442
		// why? hash分布更为均匀还是只是去除sun包的引用
		String s = "d";
		s.hashCode();
		System.out.println((key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16));
	}
}
