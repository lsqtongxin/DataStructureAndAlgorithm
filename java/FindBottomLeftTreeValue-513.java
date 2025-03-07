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
// 层序遍历
// 与LCR045-找树左下角的值 https://leetcode.cn/problems/LwUNpT/
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root==null)return 0;
        return levelOrder(root);

    }
    private int levelOrder(TreeNode node){
        int res = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.remove();
                if(i==0){
                    res = temp.val;
                }
                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
            }

        }
        return res;
    }
}
