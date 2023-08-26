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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)return 0;
        sumDFS(root);
        return sum;
    }
    void sumDFS(TreeNode node){
        if(node==null)return;
        
        if(node.left!=null && node.left.left==null && node.left.right==null){
            sum = sum + node.left.val;
        }
        sumDFS(node.left);
        sumDFS(node.right);
    }
}


// 这里有一个小插曲，请大家务必注意

class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)return 0;
        sumDFS(root);
        return sum;
    }
    void sumDFS(TreeNode node){
        if(node==null)return;

        // 一定注意这种情况，表明上看，一点问题都没有，但是LeetCode就是无法通过
        // 原因是 假设当node.left为空，node.right不一定为空，所以失去了node.right那部分左叶子节点的值。
        // 直接返回，sumDFS(node.right)就 无法执行了，所以会造成错误
        if(node.left!=null)return;      
        
        if(node.left.left==null && node.left.right==null){
            sum = sum + node.left.val;
        }
        sumDFS(node.left);
        sumDFS(node.right);
    }
}