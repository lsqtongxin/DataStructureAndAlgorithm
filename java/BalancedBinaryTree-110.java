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
// 前序处理一个节点，这种方式会产生多余的计算，都只是beats52%
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        int sub = treeMaxDepth(root.left) - treeMaxDepth(root.right);
        if(Math.abs(sub)>1)return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    int treeMaxDepth(TreeNode node){
        if(node==null)return 0;
        return 1+ Math.max(treeMaxDepth(node.left),treeMaxDepth(node.right));
    }
}

// 后续处理一个节点，这种方式也会产生多余的计算，都只是beats52%
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        if(isBalanced(root.left) && isBalanced(root.right)){
            int sub = treeMaxDepth(root.left) - treeMaxDepth(root.right);
            if(Math.abs(sub)>1)return false;
            else return true;
        }
        return false;
    }
    int treeMaxDepth(TreeNode node){
        if(node==null)return 0;
        return 1+ Math.max(treeMaxDepth(node.left),treeMaxDepth(node.right));
    }
}

// 最优的解法，相关请参考 何海涛剑指offer 
// https://github.com/zhedahht/CodingInterviewChinese2/blob/master/55_02_BalancedBinaryTree/BalancedBinaryTree.cpp
// 那是cpp版本，下面是java版本，将数深度和是否平衡 融合在了一个变量里面，如果平衡的话且为树深度，如果不平衡的话则为-1
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        return isHybrid(root)!=-1;        
    }
    int isHybrid(TreeNode node){
        if(node==null)return 0;
        int left = isHybrid(node.left);
        int right= isHybrid(node.right);
        if(left<0 ||right<0 || Math.abs(left-right)>1)return -1;
        return 1+Math.max(left,right);
    }
}

// 这个方法也是后序遍历，通过采集每个节点的是否平衡和它的深度
// 然后后序遍历过程中进行比较
// 这个方法与何海涛剑指offer是一样的，只是语言形式不一样，一个cpp另一个是java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root).getKey();
    }

    private Pair<Boolean, Integer> dfs(TreeNode curr)
    {
        if(curr == null)
        {
            return new Pair<Boolean, Integer>(true, 0);
        }
        
        Pair<Boolean, Integer> left = dfs(curr.left);
        Pair<Boolean, Integer> right = dfs(curr.right);
        boolean balanced = left.getKey() && right.getKey() && Math.abs(right.getValue() - left.getValue()) <= 1;

        
        return new Pair<Boolean, Integer>(balanced,1 +  Math.max(left.getValue(), right.getValue()));
        
    }
}