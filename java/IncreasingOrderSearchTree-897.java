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

// 不知为何，树这种结构不用全篇考虑它如何处理，只需要考虑某个细节就行。
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if(root==null)return root;
        TreeNode head1 = increasingBST(root.left);
        TreeNode dummy = new TreeNode();
        dummy.right = head1;
        TreeNode cur = dummy;
        while(cur.right!=null){
            cur = cur.right;
        }
        TreeNode head2 = increasingBST(root.right);
        cur.right = root;
        root.left = null;
        root.right = head2;
        return dummy.right;
    }
}
