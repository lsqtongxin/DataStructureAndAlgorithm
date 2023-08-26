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
    ArrayList<Integer> track = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        backtrack(root);
        int sum = 0;
        for(int i=0;i<res.size();i++){
            int e = 1;
            for(int j=res.get(i).size()-1;j>=0;j--){
                sum = sum + res.get(i).get(j) * e;
                e=e*10;
            }
        }
        return sum;
    }
    void backtrack(TreeNode node){
        if(node==null)return;
        track.add(node.val);
        if(node.left==null && node.right==null){
            res.add(new ArrayList<>(track));
            // return;  这里一定不要写上return，否则track无法回退
            // 也就是说 下面的一行 track.remove(track.size()-1)无法执行
            // 导致track无法退回,务必要注意
        }
        backtrack(node.left);
        backtrack(node.right);
        track.remove(track.size()-1);
    }
}