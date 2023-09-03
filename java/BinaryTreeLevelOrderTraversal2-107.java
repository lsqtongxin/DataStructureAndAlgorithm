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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null)return res;
        levelOrder(root,0);
        Collections.reverse(res);
        return res;
    }
    void levelOrder(TreeNode node,int curDepth){
        if(node==null)return;
        if(res.size()==curDepth){
            res.add(new ArrayList<Integer>());
        }
        res.get(curDepth).add(node.val);
        levelOrder(node.left,curDepth+1);
        levelOrder(node.right,curDepth+1);
    }
}



// 逆向写数据
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null)return res;
        levelOrder(root,0);
        //Collections.reverse(res);
        return res;
    }
    void levelOrder(TreeNode node,int curDepth){
        if(node==null)return;
        if(res.size()==curDepth){
            res.add(0,new ArrayList<Integer>());
        }
        res.get(res.size()-curDepth-1).add(node.val);
        levelOrder(node.left,curDepth+1);
        levelOrder(node.right,curDepth+1);
    }
}