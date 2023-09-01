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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        return mergeLists(lists,0,lists.length-1);
    }
    ListNode mergeLists(ListNode[] lists,int left,int right){
        if(left>=right)return lists[left];
        int mid = left + (right-left)/2;
        ListNode node1 = mergeLists(lists,left,mid);
        ListNode node2 = mergeLists(lists,mid+1,right);
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
