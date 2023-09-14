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
// 依次取出值并进行相加
class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    public int rangeSumBST(TreeNode root, int low, int high) {
        inOrder(root,high);
        int sum = 0;
        for(int i = res.size()-1;i>=0;i--){
            if(res.get(i)>=low){
                sum+=res.get(i);
            }else{
                break;
            }
        }
        return sum;
    }
    void inOrder(TreeNode node,int high){
        if(node==null)return;
        inOrder(node.left,high);
        if(node.val<=high){
            res.add(node.val);
        }else{
            return;
        }
        inOrder(node.right,high);
    }
}

// 递归的去加相关值
class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)return 0;

        if(root.val>=low && root.val<=high){
            sum+=root.val;
            rangeSumBST(root.left,low,high);
            rangeSumBST(root.right,low,high);
        }else if(root.val < low){
            rangeSumBST(root.right,low,high);
        }else{
            rangeSumBST(root.left,low,high);
        }
        return sum;
    }
}