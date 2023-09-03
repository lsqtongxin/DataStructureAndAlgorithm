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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)return res;
        levelOrder(root,0);
        return res;
    }
    void levelOrder(TreeNode node,int curDepth){
        if(node==null)return;
        if(curDepth==res.size()){
            res.add(new ArrayList<Integer>());
        }
        if(curDepth%2==0){
            res.get(curDepth).add(node.val);
        }else{
            res.get(curDepth).add(0,node.val);
        }
        levelOrder(node.left,curDepth+1);
        levelOrder(node.right,curDepth+1);
    }
}