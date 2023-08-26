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

// backtrack其实是访问某个节点,是一种前序遍历,先访问这个节点的值，然后判断和是否相等
// 以及是否为叶子节点

// 1. 第一种
class Solution {
    boolean res;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        res=false;
        if(root==null)return res;
        backtrack(root,targetSum,0);
        return res;
    }
    void backtrack(TreeNode node,int targetSum,int pathSum){
        if(node == null)return;
        pathSum+=node.val;
        if(pathSum == targetSum && node.left == null && node.right == null){
            this.res = true;
            return;
        }
        backtrack(node.left,targetSum,pathSum);
        backtrack(node.right,targetSum,pathSum);
        pathSum-=node.val;
    }
}
// 2. 第二种：都一样，只不过是backtrack函数定义的区别而已
class Solution {
    int sum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        return backtrack(root,targetSum);
    }
    private boolean backtrack(TreeNode node,int targetSum){
        if(node==null)return false;
        if(this.sum + node.val == targetSum && node.left==null && node.right==null){
            return true;
        }
        this.sum+=node.val;
        boolean res = backtrack(node.left,targetSum) || backtrack(node.right,targetSum);
        this.sum-=node.val;
        return res;
    }
}