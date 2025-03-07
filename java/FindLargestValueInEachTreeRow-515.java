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
// 层序遍历而已
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null)return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int val = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode temp = queue.remove();
                if(val<temp.val){
                    val = temp.val;
                }
                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
            }
            res.add(val);
        }
        return res;
    }
}
