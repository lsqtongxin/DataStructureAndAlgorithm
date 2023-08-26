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
    String level = "->";
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<>();
        if(root==null)return ans;
        backtrack(root);
        for(int i=0;i<res.size();i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<res.get(i).size();j++){
                sb.append(res.get(i).get(j).toString());
                if(j==res.get(i).size()-1)continue;
                sb.append(level);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
    void backtrack(TreeNode node){
        if(node==null)return;
        track.addLast(node.val);
        if(node.left==null && node.right==null){
            res.add(new LinkedList<>(track));
        }
        backtrack(node.left);
        backtrack(node.right);
        track.removeLast();
    }
}