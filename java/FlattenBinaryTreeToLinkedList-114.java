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
// 第一种: 函数是void返回值
class Solution {
    public void flatten(TreeNode root) {
        if(root==null)return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode cur = root;
        while(cur.right!=null){
            cur = cur.right;
        }
        cur.right = right;
    }
}

// 第二种: 函数返回某个节点
class Solution {
    public void flatten(TreeNode root) {
        if(root==null)return;
        flattenRec(root);
        return;
    }
    TreeNode flattenRec(TreeNode node){
        if(node==null)return null;
        TreeNode left = flattenRec(node.left);
        TreeNode right = flattenRec(node.right);
        node.left = null;
        node.right = left;
        TreeNode cur = node;
        while(cur.right!=null){
            cur = cur.right;
        }
        cur.right = right;
        return node;
    }
}