
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 这个需要回溯，需要重新学习一下回溯的使用，这个很关键
// 本题与LCR-194 二叉树的最近公共祖先完全相同，https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        List<TreeNode> pathP = new ArrayList<>();
        dfs(root,p,pathP);
        List<TreeNode> pathQ = new ArrayList<>();
        dfs(root,q,pathQ);
        int size = Math.min(pathP.size(),pathQ.size());
        int i=0;
        for(;i<size;i++){
            if(pathP.get(i).val==pathQ.get(i).val)continue;
            else break;
        }
        return pathP.get(i-1);
    }
    private boolean dfs(TreeNode node, TreeNode target, List<TreeNode> path) {
        if (node == null) {
            return false; // 空节点，直接返回
        }
        path.add(node); // 将当前节点加入路径
        // 找到目标节点，直接返回成功
        if (node == target) {
            return true;
        }
        // 递归搜索左子树
        if (dfs(node.left, target, path)) {
            return true;
        }
        // 递归搜索右子树
        if (dfs(node.right, target, path)) {
            return true;
        }
        // 未找到目标节点，回溯：移除当前节点
        path.remove(path.size() - 1);
        return false;
    }
}
