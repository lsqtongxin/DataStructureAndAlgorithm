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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode p3 = null;
        ListNode p4 = null;
        while(cur.next!=null){
            p1 = cur;
            p2 = cur.next;
            int i = k;
            while(i>0){
                if(cur.next!=null){
                    cur=cur.next;
                    i--;
                }else{
                    break;
                }
            }
            if(i!=0)break;
            p3 = cur;
            p4 = cur.next;
            cur.next = null;
            cur = p2;
            reverseList(p2);
            p1.next = p3;
            p2.next = p4;
        }
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