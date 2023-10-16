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
    int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null && root.right==null){
            return 1;
        }
        findMin(root,0);
        return res;  
    }
    private void findMin(TreeNode node,int depth){
        if(node.left==null && node.right==null){
            if(1+depth<res){
                res = 1 + depth;
            }
            return;
        }
        if(node.left!=null)findMin(node.left,depth+1);
        if(node.right!=null)findMin(node.right,depth+1);
    }
}
