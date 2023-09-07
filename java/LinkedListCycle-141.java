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
    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast.next==slow.next)return true;
            
        }
        return false;
    }
}


// 2.带dummy节点
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast.next!=null){
            if(fast.next.next==null || fast.next.next.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(fast.next==slow.next)return true;
            
        }
        return false;
    }
}
// 3.带dummy节点
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast.next==slow.next)return true;
            
        }
        return false;
    }
}
