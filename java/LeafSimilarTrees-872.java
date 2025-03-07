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
// 前序遍历把叶子节点都取出来
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)return true;
        if(root1==null || root2==null)return false;
        List<Integer> res1 = new ArrayList<>();
        preOrder(root1,res1);
        List<Integer> res2 = new ArrayList<>();
        preOrder(root2,res2);
        if(res1.size()!=res2.size())return false;
        int i=0;
        for(;i<res1.size();i++){
            int temp = res1.get(i);
            if(temp!=res2.get(i))return false;
        }
        if(i!=res2.size())return false;
        return true;
    }
    private void preOrder(TreeNode node,List<Integer> res){
        if(node==null)return;
        if(node.left==null&&node.right==null){
            res.add(node.val);
        }
        preOrder(node.left,res);
        preOrder(node.right,res);
    }
}
