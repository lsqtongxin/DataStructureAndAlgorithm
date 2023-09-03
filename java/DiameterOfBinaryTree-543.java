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
// 这题用了两个遍历解决这个问题，一个通过前序遍历遍历每个节点的属性即半径值
// 这个半径值等于 左子树的最大深度加上右子树的最大深度之和
// 另一个通过后续遍历每个节点的深度
class Solution {
    int diameter = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        traverse(root);
        return diameter;
    }
    void traverse(TreeNode node){
        if(node==null)return;
        int temp = maxDepth(node.left) + maxDepth(node.right);
        if(temp>diameter)diameter=temp;
        traverse(node.left);
        traverse(node.right);
    }
    int maxDepth(TreeNode node){
        if(node==null)return 0;
        return 1 + Math.max(maxDepth(node.left),maxDepth(node.right));
    }
}