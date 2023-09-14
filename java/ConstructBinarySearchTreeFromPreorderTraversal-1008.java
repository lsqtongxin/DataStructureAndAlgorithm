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
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder,0,preorder.length-1);
    }
    private TreeNode constructBST(int[] preorder,int left,int right){
        if(left>right)return null;
        int middle = preorder[left];
        TreeNode node = new TreeNode(middle);
        int i=left+1;
        while(i<=right){
            if(preorder[i]>middle)break;
            else i++;
        }
        node.left = constructBST(preorder,left+1,i-1);
        node.right = constructBST(preorder,i,right);
        return node;
    }
}
