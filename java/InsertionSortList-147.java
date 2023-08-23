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
    public ListNode insertionSortList(ListNode head) {
        if(head==null)return null;
        ListNode dummy = new ListNode(0);
        ListNode resDummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next!=null){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = null;
            ListNode curRes = resDummy;
            while(curRes.next!=null){
                if(curRes.next.val < temp.val){
                    curRes=curRes.next;
                }else{
                    temp.next = curRes.next;
                    curRes.next = temp;
                    break;
                }
            }
            // 针对结果链表进行特殊处理，
            // 第一：一开始一个节点都没有。
            // 第二：放到最后一个节点后面。
            if(curRes.next==null)curRes.next = temp;
        }
        return resDummy.next;
    }
}
