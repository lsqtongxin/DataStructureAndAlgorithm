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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructBT(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode constructBT(int[] inorder,int leftIn,int rightIn, int[] postorder,int leftPost,int rightPost) {
        if(leftIn>rightIn || leftPost>rightPost)return null;
        int middle = postorder[rightPost];
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
        int cur2 = leftPost;
        while(map.containsKey(postorder[cur2])){
            cur2++;
        }
        node.left = constructBT(inorder,leftIn,cur-1,postorder,leftPost,cur2-1);
        node.right= constructBT(inorder,cur+1,rightIn,postorder,cur2,rightPost-1);
        return node;
    }
}
