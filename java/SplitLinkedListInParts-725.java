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

// 这一版写的有点乱，虽然能AC
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        int count = 0;
        ListNode cur = dummy;
        while(cur.next!=null){
            count++;
            cur = cur.next;
        }
        ListNode[] res = new ListNode[k];
        if(count<k){
            cur = dummy.next;
            int i =0;
            while(cur!=null){
                ListNode temp = cur;
                cur = cur.next;
                temp.next = null;
                res[i] = temp;
                i++;
            }
            return res;
        }
        int x = count/k;
        int y = count%k;

        //  (x+1)有y个，剩余的是(x)有 k-y个
        cur = dummy;
        for(int i=0;i<y;i++){
            int n = x + 1;
            res[i]= cur.next;
            while(n>0){
                cur=cur.next;
                n--;
            }
            ListNode temp = new ListNode();
            temp.next = cur.next;
            cur.next = null;
            cur = temp;
        }
        for(int i=y;i<k;i++){
            int n = x;
            res[i] = cur.next;
            while(n>0){
                cur = cur.next;
                n--;
            }
            ListNode temp = new ListNode();
            temp.next = cur.next;
            cur.next = null;
            cur = temp;
        }
        return res;
    }
}