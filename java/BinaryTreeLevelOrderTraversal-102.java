/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// 1. 迭代法：通过队列，逐层遍历，以当前队列的大小作为分层的分隔符
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)return res;
        // Queue<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i=1;i<=size;i++){
                TreeNode temp = queue.remove();
                level.add(temp.val);
                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
            }
            res.add(level);
        }
        return res;
    }
}

// 2. 递归：通过当前的curDepth和结果集的索引是一样的，一致的
//    这是巧妙的方式，比如： 把整棵树当成一个大数组，树根为0，每一层加一
//    这个大数组是一个竖着的数组，从上到下，从0开始，正好对应树的各层
//    通过前序遍历得到层序遍历的值
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return res;
        levelTraverse(root,0);
        return res;
    }
    void levelTraverse(TreeNode node,int curDepth){
        if(node==null)return;
        if(curDepth == res.size()){
            res.add(new ArrayList<Integer>());
        }
        res.get(curDepth).add(node.val);
        levelTraverse(node.left,curDepth+1);
        levelTraverse(node.right,curDepth+1);
    }
}
