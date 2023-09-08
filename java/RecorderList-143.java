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
    public void reorderList(ListNode head) {
        if(head==null)return;
        ListNode dummy1 = new ListNode(0);
        dummy1.next = head;
        ListNode slow = dummy1;
        ListNode fast = dummy1;
        // 拆分两个子链表
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode dummy2 = new ListNode(0);
        dummy2.next = slow.next;
        slow.next = null;
        // 反转第二个子链表
        dummy2.next = reverseList(dummy2.next);
        // 合并两个链表
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        ListNode dummy = new ListNode(0);
        ListNode cur =dummy;
        while(cur1.next!=null && cur2.next!=null){
            ListNode temp = cur1.next;
            cur1.next = temp.next;
            temp.next = null;
            cur.next = temp;
            cur = cur.next;
            temp = cur2.next;
            cur2.next = temp.next;
            temp.next =null;
            cur.next = temp;
            cur = cur.next;
        }
        if(cur1.next ==null){
            cur.next = cur2.next;
        }
        if(cur2.next==null){
            cur.next=cur1.next;
        }
        head = dummy.next;
    }
    private ListNode reverseList(ListNode node){
        ListNode dummy = new ListNode(0);
        dummy.next = node;
        ListNode cur = dummy;
        ListNode res = new ListNode(0);
        while(cur.next!=null){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = null;
            temp.next = res.next;
            res.next = temp;
        }
        return res.next;
    }
}

//
