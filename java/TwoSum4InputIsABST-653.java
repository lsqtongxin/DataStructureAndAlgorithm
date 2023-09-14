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
    ArrayList<Integer> arr = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)return false;
        traverse(root);
        // two sum
        int i=0;
        int j=arr.size()-1;
        while(i<j && j< arr.size()){
            int sum = arr.get(i)+arr.get(j);
            if(sum==k){
                return true;
            }else if(sum<k){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
    void traverse(TreeNode node){
        if(node==null)return;
        traverse(node.left);
        arr.add(node.val);
        traverse(node.right);
    }
}
