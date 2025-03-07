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
// 与 LCR-055 二叉搜索树迭代器一样 https://leetcode.cn/problems/kTOapQ/description/
class BSTIterator {
    int i;
    List<TreeNode> res;
    public BSTIterator(TreeNode root) {
        this.i = 0;
        this.res = new ArrayList<TreeNode>();
        inorderTraversal(root);
    }
    
    public int next() {
        TreeNode temp = this.res.get(i);
        i++;
        return temp.val;
    }
    
    public boolean hasNext() {
        if(i>=res.size()){
            return false;
        }else{
            return true;
        }
    }
    private void inorderTraversal(TreeNode node){
        if(node==null)return;
        inorderTraversal(node.left);
        res.add(node);
        inorderTraversal(node.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
