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
// hashtable
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode dummyRes = new ListNode(0);
        ListNode curRes = dummyRes;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(cur.next!=null){
            if(map.containsKey(cur.next.val)){
                map.put(cur.next.val,map.get(cur.next.val)+1);
            }else{
                map.put(cur.next.val,1);
            }
            cur = cur.next;
        }
        cur = dummy;
        while(cur.next!=null){
            if(map.get(cur.next.val)==1){
                ListNode temp =cur.next;
                cur.next = temp.next;
                temp.next = null;
                curRes.next = temp;
                curRes = curRes.next;
            }else{
                cur = cur.next;
            }
        }
        return dummyRes.next;
    }
}

// 滑动窗口
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
	// cur同时是路径前进的指针，也同时是结果集的最后一个节点
        ListNode cur = dummy;
        while(cur.next!=null){
	    // 如果cur.next.next为null，则不进行比较了
	    // 只有一个节点
            if(cur.next.next==null)break;
            if(cur.next.val == cur.next.next.val){
                ListNode inner = cur.next.next;
		// 从inner开始进行循环，找到相等的节点的末尾
                while(inner.next!=null && cur.next.val == inner.next.val){
                    inner=inner.next;
                }
		// 这有两种情况，第一种是inner.next==null，也就是说到了末尾了
		// 第二种情况是 cur.next.val!=inner.next.val 
		// 相等的区间是[cur.next,inner] 左闭右闭
		// 去除相等的区间就是将cur的next指向 null或下一个不相等的节点
                cur.next = inner.next;
            }else {
		// cur.next.val!=cur.next.next.val
		// cur.next和cur.next.next不相等，则向前行进
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
