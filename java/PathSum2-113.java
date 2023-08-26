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
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)return res;
        backtrack(root,targetSum,0);
        return res;
    }
    void backtrack(TreeNode node,int targetSum,int pathSum){
        if(node==null)return;
        pathSum+=node.val;
        track.addLast(node.val);
        if(pathSum == targetSum && node.left==null && node.right==null){
            res.add(new LinkedList<>(track));
        }
        backtrack(node.left,targetSum,pathSum);
        backtrack(node.right,targetSum,pathSum);
        pathSum-=node.val;
        track.removeLast();
    }
}