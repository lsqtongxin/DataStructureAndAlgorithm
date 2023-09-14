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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructBT(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        
    }
    private TreeNode constructBT(int[] preorder,int leftPre,int rightPre, int[] inorder,int leftIn,int rightIn) {
        if(leftPre>rightPre || leftIn>rightIn)return null;
        int middle = preorder[leftPre];
        TreeNode node = new TreeNode(middle);
        int cur = leftIn;
        HashMap<Integer,Boolean> map = new HashMap<>();
        while(cur<=rightIn){
            if(inorder[cur]==middle)break;
            else{
                map.put(inorder[cur],true);
                cur++;
            } 
        }
        int cur2 = leftPre+1;
        while(cur2<=rightPre && map.containsKey(preorder[cur2])){
            cur2++;
        }
        node.left = constructBT(preorder,leftPre+1,cur2-1,inorder,leftIn,cur-1);
        node.right= constructBT(preorder,cur2,rightPre,inorder,cur+1,rightIn);
        return node;
    }


}
