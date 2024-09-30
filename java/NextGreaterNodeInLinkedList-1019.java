// 单调栈问题，只不过是在数组中
// 先将链表中的数据放到数组中
// 然后使用数组进行单调栈查找
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if(head==null)return new int[0];

        // 将链表里面的值取到ArrayList
        List<Integer> source = new ArrayList<>();
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while(cur.next!=null){
            source.add(cur.next.val);
            cur = cur.next;
        }
        // 这下就类似 739 每日温度
        int length = source.size();
        // stack 保存的是索引
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[length];
        for(int i=0;i<length;i++){
            while(!stack.isEmpty() && source.get(i)> source.get(stack.peek())){
                int preInd = stack.pop();
                ans[preInd] = source.get(i);
            }
            stack.push(i);
        }
        return ans;
    }
}  
