package com.zfgod.learn2018.collections.hashmap8;

import com.zfgod.learn2018.collections.model.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * hashMap红黑树
 * @author: zf
 * @Date: 2018-11-7  15:26
 * @SINCE JDK1.8
 */
public class HashMapTreeifyBin {
	public static void main(String[] args) {

		HashMap<Object, Object> hashMap = new HashMap<>();

		/**
		 * // 当一条链表下的节点数达到8个, 调用转换为红黑树方法treeifyBin(tab, hash);
		 * 1. 检查tab.length < 64
		 *     resize()
		 * 2. 检查tab.length >= 64,对当前链表进行红黑树处理
		 */
		//  user的hashCode取name + age, equals取所有属性, 未实现comparable
		int testModCount = 16;
		// 由于每个key的hashCode一样, 因此前8个在数组中的角标一致,
		// 第9、10个达到红黑树化阈值,但是由于数组容量未达到最小红黑树化的阈值，进行两次resize达到64
		// TODO第9、10个元素resize之后怎么放置的呢
		// 第11个达到红黑树化条件, 因此该链表结构改为红黑树
		// 后续直接在红黑树下添加节点
		// TODO user疑问 未实现compare,有什么影响,性能？

		for(int i = 1; i <=testModCount; i++){
			User user = new User("aa", 10, "abc" + i);
			System.out.println(String.format("进行第%d次put操作", i));
			hashMap.put(user, user.getAddress());
			// 被替换值为空表明没有替换已经存在的key或原值为null
			System.out.println(String.format("第%d次put操作结束,当前添加完成元素个数%d", i, hashMap.size()));
		}

		System.out.println("size=" + hashMap.size());
		Set<Map.Entry<Object, Object>> entries = hashMap.entrySet();
		for (Map.Entry<Object, Object> entry : entries) {
			System.out.println(String.format("key:%s,value:%s",entry.getKey(),entry.getValue()));
		}

	}


}
