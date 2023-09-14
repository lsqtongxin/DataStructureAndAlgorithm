/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow)break;
        }
        // 无环
        if(fast!=slow)return null;

        // 有环
        slow = dummy;
        while(slow.next!=null){
            slow = slow.next;
            fast = fast.next;
            if(slow == fast)break;
        }
        return slow;
    }
}
