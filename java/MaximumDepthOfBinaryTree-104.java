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
// 1. 递归，通过解决各种子问题，并将子问题进行汇总合并得到整个大问题的解
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}

// 2. 记录每个节点的深度，并进行相关比较，这种方式也是回溯法
//    通过深度遍历dfs来得到最深的节点值
//    这个方法可以解决这个问题，例如： 遍历一棵树，输出各个节点的深度
class Solution {
    int res = 0;
    int curDepth = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }
    void traverse(TreeNode node){
        if(node==null)return;
        //前序遍历放置的位置
        curDepth++;
        res = Math.max(curDepth,res);
        traverse(node.left);
        traverse(node.right);
        // 后续遍历放置的位置
        curDepth--;
    }
}

// 3. 这是第2种方法的优化，只统计每个叶子节点的深度，并进行相关的比较
class Solution {
    int res = 0;
    int curDepth = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }
    void traverse(TreeNode node){
        if(node==null)return;
        curDepth++;
        if(node.left==null && node.right==null){
            res = Math.max(curDepth,res);
        }
        traverse(node.left);
        traverse(node.right);
        curDepth--;
    }
}
