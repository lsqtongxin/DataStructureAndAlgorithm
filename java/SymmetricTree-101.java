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

// 1. 这题 需要反转二叉树-226 和 同样的树-100的函数
class Solution {
    public boolean isSymmetric(TreeNode root) {
         if(root==null)return true;
         invert(root.right);
         return isSame(root.left,root.right);
    }
    boolean isSame(TreeNode p,TreeNode q){
        if(p==null && q==null)return true;
        if(p!=null && q==null)return false;
        if(p==null && q!=null)return false;
        if(p.val!=q.val)return false;
        return isSame(p.left,q.left) && isSame(p.right,q.right);
    }
    void invert(TreeNode node){
        if(node==null)return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invert(node.left);
        invert(node.right);
    }
}

// 2. 直接左右进行比对，而不用修改这颗树
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return symmetric(root.left,root.right);
    }
    private boolean symmetric(TreeNode p,TreeNode q){
        if(p==null && q==null)return true;
        if(p==null || q==null)return false;
        if(p.val!=q.val)return false;
        return symmetric(p.left,q.right) && symmetric(p.right,q.left);
    }
}