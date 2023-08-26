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

// 这个题的考察点：
//    1. 前序遍历，遍历每一个节点，然后在前序操作的时候对这个节点进行计算路径和
//    2. 回溯法，当遍历某个节点时候，通过dfs搜索或回溯法来计算路径和是否等于目标
//       当访问一个节点的时候，要知道 currentSum是多少，然后访问节点(加上这个节点的值)
//       判断是否等于目标和，然后再遍历左右子树，最后再减去回退。
//    3. 有一个坑，是currentSum 必须是一个long型，这题才能通过，否则会整型溢出。

class Solution {
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)return 0;
        backtrack(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return res;
    }
    void backtrack(TreeNode node,int targetSum,long currentSum){
        if(node==null)return;
        currentSum = currentSum + node.val;
        if(targetSum == currentSum){
            this.res++;
        }
        backtrack(node.left,targetSum,currentSum);
        backtrack(node.right,targetSum,currentSum);
        currentSum-=node.val;
    }
}