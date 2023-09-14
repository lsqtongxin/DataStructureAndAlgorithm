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
    ListNode dummy;
    ArrayList<Integer> res;
    public Solution(ListNode head) {
        dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        res = new ArrayList<>();
        while(cur.next!=null){
            res.add(cur.next.val);
            cur = cur.next;
        }
    }
    public int getRandom() {
        int length = res.size();
        int random = (int)(Math.random()*length);
        return res.get(random);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */