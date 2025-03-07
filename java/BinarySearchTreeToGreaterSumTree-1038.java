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
// 中序遍历，再反向加和
// 与题538一模一样，还有LCR-054把二叉搜索树转化为累加树，
// 这三题是同一题目
// https://leetcode.cn/problems/w6cpku/
class Solution {
    List<TreeNode> res = new ArrayList<>();
    public TreeNode bstToGst(TreeNode root) {
        int sum = 0;
        inorderTraversal(root);
        for(int i=res.size()-1;i>=0;i--){
            TreeNode temp = res.get(i);
            sum = sum + temp.val;
            temp.val = sum;
        }
        return root;
    }

    private void inorderTraversal(TreeNode node){
        if(node==null)return;
        inorderTraversal(node.left);
        res.add(node);
        inorderTraversal(node.right);
    } 
}
