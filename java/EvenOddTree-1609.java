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
    List<List<Integer>> res;
    public boolean isEvenOddTree(TreeNode root) {
        if(root==null || root.val%2==0)return false;
        res = new ArrayList<List<Integer>>();
        levelOrder(root);
        for(int i=0;i<res.size();i++){
            List<Integer> row = res.get(i);
            if(i%2==0){
                for(int j=0;j<row.size();j++){
                    if(row.get(j)%2==0)return false;
                    if(j+1<row.size() && row.get(j)>=row.get(j+1)){
                        return false;
                    }
                }
            }else {
                for(int j=0;j<row.size();j++){
                    if(row.get(j)%2==1)return false;
                    if(j+1<row.size() && row.get(j)<=row.get(j+1)){
                        return false;
                    }
                }
            }

        }
        return true;
    }
    // 层序遍历,务必注意这里是队列，而不是栈
    private void levelOrder(TreeNode node){
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.remove();
                row.add(temp.val);
                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
            }
            res.add(row);
        }
    }
}
