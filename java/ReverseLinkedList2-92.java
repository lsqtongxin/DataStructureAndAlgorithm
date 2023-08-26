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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right)return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode p3 = null;
        ListNode p4 = null;

        while(cur.next!=null && right>0){
            cur = cur.next;
            right--;
        }
        p3 = cur;
        p4 = cur.next;
        p3.next=null;
        cur = dummy;
        
        while(cur.next!=null && left > 1){
            cur = cur.next;
            left--;
        }
        p1=cur;
        p2=cur.next;
        p1.next =null;
        reverseList(p2);
        p1.next = p3;
        p2.next = p4;
        return dummy.next;
    }
    void reverseList(ListNode node){
        if(node==null)return;
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
    }
}