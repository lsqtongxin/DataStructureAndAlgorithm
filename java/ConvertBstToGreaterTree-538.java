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
    List<TreeNode> res = new ArrayList<>();
    public TreeNode convertBST(TreeNode root) {
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
