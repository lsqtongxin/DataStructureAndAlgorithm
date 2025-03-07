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
// 求坡度，也就是求子树的所有节点本身的和
// 每个节点都有它自己的坡度
// 最后还得将各个节点的坡度的总和
// 相当于遍历两次树
class Solution {
    public int findTilt(TreeNode root) {
        if(root==null)return 0;
        int left = findTilt(root.left);
        int right= findTilt(root.right);
        return left+right+ Math.abs(achieveSum(root.left)-achieveSum(root.right));
    }
    private int achieveSum(TreeNode node){
        if(node==null)return 0;
        int left = achieveSum(node.left);
        int right= achieveSum(node.right);
        return left+right+node.val;
    }
}

// 2.
// 对某个节点而言，我需要算出左子树的总和、右子树的总和，以及我这个节点整个树的总和
// 我们需要的坡度，只需要设置一个变量即可
class Solution {
    int res = 0;
    public int findTilt(TreeNode root) {
        if(root==null)return 0;
        achieveSum(root);
        return res;
    }
    private int achieveSum(TreeNode node){
        if(node==null)return 0;
        int left = achieveSum(node.left);
        int right= achieveSum(node.right);
        this.res = this.res + Math.abs(left-right);
        return left+right+node.val;
    }
}
