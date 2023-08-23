92. 反转链表2：反转从位置 m 到 n 的链表，这种是左闭右闭，一定注意m和n的是否闭合。
剑指offer 52 求两个链表的第一个公共节点
这题有五种方法：
1. 蛮力法
2. 辅助栈
3. 长度法，分别测量两个链表的长度，谁长谁先走他们之间长度差的步数，然后再一起走进行比对
		时间复杂度O(m+n),空间复杂度O(1)
4. 构建法，构建为一个带有环的链表，然后按照环的处理方式进行
5. 相遇法，L1+C, L2+C,首先让curA走L1+C步，curA再走L2步，总共L1+C+L2
           同理，让curB走L2+C步，curB再走L1步，总共也是L2+C+L1,
           那他们肯定相遇*/
		时间复杂度O(m+n),空间复杂度O(1)
102. 二叉树的层序遍历
层序遍历存在两种方法：
1.递归
class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return res;
        helper(root,0);
        return res;
    }

    private void helper(TreeNode node,int level){
        if(res.size()==level){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(node.val);
        if(node.left!=null)helper(node.left,level+1);
        if(node.right!=null)helper(node.right,level+1);
    }
}
2.迭代
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)return res;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=1;i<=size;i++){
                TreeNode cur = queue.remove();
                level.add(cur.val);
                if(cur.left!=null)queue.add(cur.left);
                if(cur.right!=null)queue.add(cur.right);
            }
            res.add(level);
        }
        return res;
    }
}

