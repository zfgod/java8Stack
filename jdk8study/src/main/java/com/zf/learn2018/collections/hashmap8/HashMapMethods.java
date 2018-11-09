package com.zfgod.learn2018.collections.hashmap8;

import com.zfgod.learn2018.collections.model.User;

import java.util.HashMap;

/**
 * @author: zf
 * @Date: 2018-11-7  13:26
 */
public class HashMapMethods {
	/**
	 * jdk1.8 hashMap： 数组 + 链表 + 红黑树 ,3者可以同时存在
	 * @param args
	 */
	public static void main(String[] args) {
		// put/get
		HashMap<Object, Object> map = new HashMap<>(16);
		User userA = new User("a", 1, "addr1");
		User userB = new User("a", 1, "addr2");


		// first node
		//  if(resize) double threshold ;
		/** put元素过程
		 * 1. 获取key的hashCode
		 *   1.1 为null直接返回0
		 *   1.2 不为null,获取hashCode ,高位运算--散列值，碰撞率低 TODO
		 * 2. 获取节点数组 Node[] ,为空进行初始化 resize()
		 * 3. 添加--根据哈希散列值获取在数组Node[]中的角标index
		 *    3.1 如果该角标无值,在该角标位置新建节点Create a regular (non-tree) node
		 *         进行直接的创建新节点操作,并没有判断数组阈值进行扩容
		 *    3.2 如果该角标有值,（覆盖或者新建，存在哈希冲突）同脚本节点记为sameIndexNode,
		 *        3.2.1 判断新旧值的哈希散列值和key是否相等
		 *              如果相等：sameIndexNode.hash == new.hash且(sameIndexNode.key== key||sameIndexNodeKey.equals(key))
		 *              新元素值覆盖老节点值
		 *        3.2.2 需新建,且sameIndexNode是树节点(表明该节点对应的链表已经改为红黑树结构)
		 *              给新元素创建新的树节点 TODO
		 *              a. 找到包含sameIndexNode的红黑树和该树的父节点
		 *              b. 遍历红黑树 treeNode,根据哈希散列值进行二分查找
		 *
		 *        3.2.3 需新建,且sameIndexNode不是树节点(表明还没改为红黑树结构, 数组中节点+该节点维护的链表数 < 8)
		 *              遍历链表table[i]
		 *              a.该链表下一个节点无值：
		 *               1）直接创建非数结构节点
		 *               2）如果链表节点数>=8, 进行红黑树化（数组中该节点+该节点下所有链表节点） TODO
		 *              b.该链表下一个节点有值：
		 *               1）哈希散列值和key
		 *                  相等则跳出遍历
		 *        3.2.4 覆盖旧值和afterNodeAccess TODO
		 *  4. 判断是否进行resize
		 */
		map.put(userA, userA.getAddress());

		int i = userA.hashCode();

		// get first
		// treeNode or linkedHashMap
		/** get元素过程
		 *  1. 获取key的哈希散列值,记为hash
		 *  2. hash表为空直接返回null,不为空进行获取
		 *  3. 计算该hash值在数组的角标位置并获取该节点值,记为firstNode(同hash下的链表或者红黑树父节点)
		 *     3.1 比较父节点的hash和key是否相等，相等直接返回该节点的value
		 *     3.2 父节点匹配失败,遍历该链表或者红黑树（看父节点是否已转换为树节点）
		 *         3.2.1 遍历红黑树,根据hash和key进行二分查找（key进行compare）O(logn)
		 *         3.2.2 遍历链表,直到匹配到hash和key相等的节点 O(n)
		 */
		Object o = map.get(userA);
		System.out.println("父节点-第一个节点的信息：hashCode= " + i );
		System.out.println("父节点-第一个节点的信息：value= " + o );

		// second node
		map.put(userB, userB.getAddress());


		map.remove(userB);

	}
}
