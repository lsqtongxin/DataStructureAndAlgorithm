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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        int length = 0;
        while(cur.next!=null){
            cur = cur.next;
            length++;
        }
        cur = dummyNode;
        int step = length-n;
        while(step>0){
            cur=cur.next;
            step--;
        }
        ListNode temp = cur.next;
        cur.next = temp.next;
        temp.next = null;
        return dummyNode.next;
    }
}
