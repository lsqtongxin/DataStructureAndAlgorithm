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
//  注意点：题目并不是将x节点后面小于x的节点放到x前面，并排序
//  也不是 快速排序那种，将 小于x的节点放在前面，大于等于x的节点放在后面
//  这题的重点是： 重点是保持相对位置，将小于x的节点放在前面，大于等于x的节点放在后面 
//  例如：
//  1->4->3->0->2->5->2   x=3
//  0->1->2->2->4->3->5  错误 前面排序了
//  0->1->2->2->3->4->5  错误 这就是快排partition
//  1->0->2->2->3->4->5  错误 这就是快排partition
//  1->0->2->2->4->3->5  正确
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null)return head;
        ListNode dummy = new ListNode(0);
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode cur1= dummy1;
        ListNode cur2= dummy2;
        while(cur.next!=null){
            if(cur.next.val>=x){
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = null;
                cur2.next = temp;
                cur2 = cur2.next;
            }else{
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = null;
                cur1.next = temp;
                cur1 = cur1.next;
            }
        }
        cur1.next = dummy2.next;
        return dummy1.next;
    }
}
