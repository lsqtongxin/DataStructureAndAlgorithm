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
    ArrayList<Integer> res = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        inOrder(root);
        for(int i=0;i+1<res.size();i++){
            if(res.get(i)>=res.get(i+1))return false;
        }
        return true;
    }
    void inOrder(TreeNode node){
        if(node==null)return;
        inOrder(node.left);
        res.add(node.val);
        inOrder(node.right);
    }
}