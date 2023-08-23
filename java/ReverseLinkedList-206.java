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
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode res = new ListNode();
        ListNode cur = dummy;
        while(cur.next!=null){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = res.next;
            res.next = temp;
        }
        return res.next;
    }
}
