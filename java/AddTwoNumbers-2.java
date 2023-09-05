/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        dummy1.next = l1;
        dummy2.next = l2;
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        int carry = 0;
        ListNode dummyRes = new ListNode(0);
        ListNode cur = dummyRes;
        while(cur1.next!=null && cur2.next!=null){
            int value = cur1.next.val+cur2.next.val+carry;
            carry = value/10;
            value = value%10;
            ListNode temp = new ListNode(value);
            cur.next = temp;
            cur1 = cur1.next;
            cur2 = cur2.next;
            cur = temp;
        }
        while(cur1.next!=null){
            int value = cur1.next.val+carry;
            carry = value/10;
            value = value%10;
            ListNode temp = new ListNode(value);
            cur.next = temp;
            cur1 = cur1.next;
            cur = temp;
        }
        while(cur2.next!=null){
            int value = cur2.next.val+carry;
            carry = value/10;
            value = value%10;
            ListNode temp = new ListNode(value);
            cur.next = temp;
            cur2 = cur2.next;
            cur = temp;
        }
        if(carry==1){
            ListNode temp = new ListNode(carry);
            cur.next = temp;
        }
        return dummyRes.next;
    }
}
