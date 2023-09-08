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
// 这题的关键是定义截止条件，否则将会出现stackoverflow
// 当head为空和当head只有一个节点，则无需进行sortList，直接返回
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null)return head;
        if(head.next==null)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur1 = dummy;
        ListNode cur2 = dummy;
        while(cur2.next!=null && cur2.next.next!=null){
            cur2=cur2.next.next;
            cur1=cur1.next;
        }
        ListNode head2 = cur1.next;
        cur1.next = null;
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(head2);
        return merge2Lists(node1,node2);
    }
    

    ListNode merge2Lists(ListNode node1,ListNode node2){
        if(node1==null)return node2;
        if(node2==null)return node1;
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        dummy1.next = node1;
        dummy2.next = node2;
        ListNode cur1=dummy1;
        ListNode cur2=dummy2;
        ListNode res = new ListNode();
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
        if(cur1.next==null){
            cur.next = cur2.next;
        }else{
            cur.next = cur1.next;
        }
        return res.next;
    }
}
