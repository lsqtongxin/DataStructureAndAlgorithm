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
    public ListNode swapPairs(ListNode head) {
        if(head==null)return null;
        if(head!=null && head.next==null)return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        ListNode dummyRes = new ListNode();
        ListNode curRes = dummyRes;
        while(cur.next!=null && cur.next.next!=null){
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            dummy.next = second.next;
            curRes.next = second;
            second.next =first;
            curRes = first;
            first.next = null;
        }
        if(cur.next!=null){
            curRes.next = cur.next;
        }
        return dummyRes.next;
    }
}
