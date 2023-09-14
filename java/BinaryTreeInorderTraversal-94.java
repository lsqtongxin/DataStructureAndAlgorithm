// 中序遍历-递归法
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
class Solution {
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new LinkedList<Integer>();
        if(root==null)return res;
        inOrder(root);
        return res;
    }
    void inOrder(TreeNode node){
        if(node == null)return;
        inOrder(node.left);
        res.add(node.val);
        inOrder(node.right);
    }
}

// 中序遍历-迭代法1
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!=null || stack.size()!=0){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}

// 中序遍历-迭代法2
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!=null || stack.size()!=0){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur = stack.pop();
                res.add(cur.val);
                cur=cur.right;
            }
        }
        return res;
    }
}
