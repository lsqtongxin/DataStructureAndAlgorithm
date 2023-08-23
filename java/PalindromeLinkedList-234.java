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
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur1 = dummy;
        ListNode cur2 = dummy;
        while(cur2.next!=null && cur2.next.next!=null){
            cur2 = cur2.next;
            cur2 = cur2.next;
            cur1 =cur1.next;
        }
        ListNode second = cur1.next;
        if(cur2.next!=null && cur2.next.next==null){
            second = cur1.next.next;
        }
        ListNode dummy2 = new ListNode();
        dummy2.next = second;
        cur1.next = null;
        dummy.next = reverseLinkedList(dummy.next);
        cur1 = dummy;
        cur2 = dummy2;
        while(cur1.next!=null){
            if(cur1.next.val!=cur2.next.val)return false;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }
    ListNode reverseLinkedList(ListNode node){
        ListNode dummy = new ListNode();
        dummy.next = node;
        ListNode cur = dummy;
        ListNode res = new ListNode();
        while(cur.next!=null){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = res.next;
            res.next = temp;
        }
        return res.next;
    }
}
