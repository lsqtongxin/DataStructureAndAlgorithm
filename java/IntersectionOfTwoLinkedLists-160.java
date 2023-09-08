/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA = new ListNode(0);
        dummyA.next = headA;
        int lenA=0;
        ListNode curA = dummyA;
        ListNode dummyB = new ListNode(0);
        dummyB.next = headB;
        int lenB=0;
        ListNode curB = dummyB;
        while(curA.next!=null){
            curA=curA.next;
            lenA++;
        }
        while(curB.next!=null){
            curB=curB.next;
            lenB++;
        }
        curA=dummyA;
        curB=dummyB;
        if(lenA>lenB){
            int temp = lenA-lenB;
            while(temp>0){
                curA=curA.next;
                temp--;
            }
        }else if(lenA<lenB){
            int temp = lenB-lenA;
            while(temp>0){
                curB=curB.next;
                temp--;
            }
        }
        while(curA.next!=curB.next){
            curA=curA.next;
            curB=curB.next;
        }
        if(curA.next==curB.next && curA.next!=null){
            return curA.next;
        }
        return null;
    }
}
