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
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return res.get(k-1);
    }
    void inOrder(TreeNode node,int kth){
        if(node==null)return;
        inOrder(node.left,kth);
        res.add(node.val);
        if(res.size()==kth)return;
        inOrder(node.right,kth);
    }
}