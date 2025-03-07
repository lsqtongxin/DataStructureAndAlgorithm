/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 寻找二叉搜索树的公共祖先
// 需要充分利用二叉搜索树的性质，来查找数的路径
// 最终对路径进行匹配
// 本题和LCR-193 二叉搜索树的最近公共祖先 https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        preOrderTraversal4FindPath(root,p,pathP);
        List<TreeNode> pathQ = new ArrayList<>();
        preOrderTraversal4FindPath(root,q,pathQ);
        int size = Math.min(pathP.size(),pathQ.size());
        int i=0;
        for(;i<size;i++){
            if(pathP.get(i).val==pathQ.get(i).val)continue;
            else break;
        }
        return pathP.get(i-1);
    }

    private void preOrderTraversal4FindPath(TreeNode node,TreeNode n,List<TreeNode> path){
        if(node==null)return;
        while(node!=null){
            path.add(node);
            if(node.val<n.val){
                node = node.right;
            }else if(node.val>n.val){
                node = node.left;
            }else{
                return;
            }
        }
    }
}
