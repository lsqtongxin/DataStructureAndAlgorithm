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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0)return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        int length = 0;
        while(cur.next!=null){
            cur = cur.next;
            length++;
        }
        ListNode last = cur;
        cur = dummy;
        int remainder = k%length;
        if(remainder==0)return dummy.next;
        int step = length - remainder;
        while(step > 0){
            cur = cur.next;
            step--;
        }
        ListNode temp = cur.next;
        cur.next = null;
        last.next = dummy.next;
        dummy.next = temp;
        return dummy.next;
    }
}