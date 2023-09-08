	
	//下面程序求出了交点的值val和公共链表的长度C
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null || headB==null)return null;
		ListNode curA = headA;
		ListNode curB = headB;
		int lenA = 0;
		int lenB = 0;
		int sub = 0;
		int tmp = 0;
		while(curA!=curB) {
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
				lenB=sub;
				sub=0;
			}
		}
		//System.out.println("the ListA length :"+ lenA);
		//System.out.println("the ListB sub length :"+ sub);
		System.out.println("the Common List length: "+ (lenA-sub));
		return curA;
	}
