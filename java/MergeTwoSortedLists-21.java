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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        dummy1.next = list1;
        dummy2.next = list2;
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(cur1.next!=null && cur2.next!=null){
            if(cur1.next.val<=cur2.next.val){
                ListNode temp = cur1.next;
                cur1.next = temp.next;
                temp.next = null;
                cur.next = temp;
                cur = cur.next;
            }else{
                ListNode temp = cur2.next;
                cur2.next = temp.next;
                temp.next = null;
                cur.next = temp;
                cur = cur.next;
            }
        }
        if(cur1.next!=null){
            cur.next = cur1.next;
        }
        if(cur2.next!=null){
            cur.next = cur2.next;
        }
        return res.next;
    }
}
