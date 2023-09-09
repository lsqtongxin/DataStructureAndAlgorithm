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
    public ListNode oddEvenList(ListNode head) {
        if(head==null)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode dummy2 = new ListNode(0);
        ListNode cur2 = dummy2;
        while(cur.next!=null && cur.next.next!=null){
            ListNode temp = cur.next.next;
            cur.next.next = temp.next;
            cur = cur.next;
            cur2.next = temp;
            temp.next = null;
            cur2=cur2.next;
        }
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = dummy2.next;
        return dummy.next;
    }
}