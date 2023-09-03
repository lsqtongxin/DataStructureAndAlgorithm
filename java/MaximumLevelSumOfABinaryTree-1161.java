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
    List<Integer> res = new ArrayList<>();
    int sumMax = Integer.MIN_VALUE;
    public int maxLevelSum(TreeNode root) {
        if(root==null)return 0;
        levelOrder(root);
        for(int i=0;i<res.size();i++){
            if(sumMax==res.get(i))return i+1;
        }
        return 0;
    }
    void levelOrder(TreeNode node){
        if(node==null)return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            int val = 0;
            for(int i=1;i<=size;i++){
                TreeNode temp = queue.remove();
                val+=temp.val;
                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
            }
            if(val>sumMax)sumMax=val;
            res.add(val);
        }
    }
}