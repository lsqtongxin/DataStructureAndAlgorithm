/**
* @Title: Solution.java
* @Package com.lsqtongxin.linkedlist
* @Description: TODO(用一句话描述该文件做什么)
* @author user
* @date 2021年1月8日
* @version V1.0
*/
package com.lsqtongxin.linkedlist;
import java.util.Random;

import com.lsqtongxin.linkedlist.ListNode;;


/**   
 * @ClassName:  Solution   
 * @Description:TODO(描述这个类的作用)   
 * @author: user
 * @date:   2021年1月8日 下午4:32:57      
 * @Copyright:  
 */

public class Solution {
	/*
	 *     剑指 Offer 52. 两个链表的第一个公共节点
	 * 这题有五种方法：

	1.蛮力法，请先看剑指offer 37题
		时间复杂度O(mn),空间复杂度O(1)

	2.辅助栈，请详见剑指offer 37题，
		时间复杂度O(m+n),空间复杂度O(m+n)

	3.长度法，分别测量两个链表的长度，谁长谁先走他们之间长度差的步数，然后再一起走进行比对
		时间复杂度O(m+n),空间复杂度O(1)

	4.构建法，构建为一个带有环的链表，然后按照环的处理方式进行
		时间复杂度O(m+n),空间复杂度O(1)

	5.相遇法，L1+C, L2+C,首先让curA走L1+C步，curA再走L2步，总共L1+C+L2
		同理，让curB走L2+C步，curB再走L1步，总共也是L2+C+L1,
		那他们肯定相遇
		时间复杂度O(m+n),空间复杂度O(1) 但这个方法比第三种和第四种少走了好多步, 还能求出C的长度。
	
	下面程序求出了交点的值val和公共链表的长度C
	 * 
	 * */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		if(headA==null || headB==null)return null;
		ListNode curA = headA;
		ListNode curB = headB;
		int lenA = 0;
		int sub = 0;
		int tmp = 0;
		while(curA!=curB) {
			//curA = (curA!=null)?curA=curA.next:headB;
			//curB = (curB!=null)?curB=curB.next:headA;
			
			if(curA!=null) {
				curA=curA.next;
				tmp++;
			}else {
				curA=headB;
				lenA = tmp;
			}
			if(curB!=null) {
				curB=curB.next;
				sub++;
			}else {
				curB=headA;
				sub=0;
			}
		}
		//System.out.println("the ListA length :"+ lenA);
		//System.out.println("the ListB sub length :"+ sub);
		System.out.println("the Common List length: "+ (lenA-sub));
		return curA;
	}
	
	public static ListNode makeListNode(int[] arr) {
		ListNode dummyHead = new ListNode(0);
		ListNode cur = dummyHead;
		for(int i=0;i<arr.length;i++) {
			ListNode tmp = new ListNode(arr[i]);
			cur.next=tmp;
			cur=cur.next;
		}
		return dummyHead.next;
	}
	
	public static void main(String[] args) {
		// 1.构建两个相交的链表
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		ListNode headA = makeListNode(arr);
		ListNode headB = makeListNode(arr);
		int len = (int)(Math.random()*10);
		System.out.println("the random insert: "+len);
		ListNode dummyHeadA = new ListNode(0);
		dummyHeadA.next = headA;
		ListNode cur = dummyHeadA;
		while(len>0 && cur.next!=null) {
			cur=cur.next;
			len--;
		}
		
		ListNode dummyHeadB = new ListNode(0);
		dummyHeadB.next = headB;
		ListNode curB = dummyHeadB;
		while(curB.next!=null) {
			curB=curB.next;	
		}
		curB.next = cur.next;
		
		//2. 求其交点
		ListNode result = getIntersectionNode(dummyHeadA.next,dummyHeadB.next);
		
		System.out.println("the IntersectionNode val: "+result.val);		
	}
}
