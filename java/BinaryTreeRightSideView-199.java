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
// 1. 层序遍历，通过层序遍历取每一level的最右侧元素组成结果集。
class Solution {
    List<Integer> res = new ArrayList<>();
    List<List<Integer>> record = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)return res;
        levelTraverse(root);
        for(int i=0;i<record.size();i++){
            res.add(record.get(i).get(record.get(i).size()-1));
        }
        return res;
    }
    void levelTraverse(TreeNode node){
        if(node==null)return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i=1;i<=size;i++){
                TreeNode temp = queue.remove();
                level.add(temp.val);
                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
            }
            record.add(level);
        }
    }
}


// 2. 迭代法：通过指定当前的curDepth，从上到底，从第0层开始
//    每一层存在一个节点，所以 第0层此时结果集也是0，所以这时加入
//    巧妙之处在于 树的深度和结果集的索引是相同的
//    同时 先访问右子树，再访问左子树
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)return res;
        rightView(root,0);
        return res;
    }
    void rightView(TreeNode node,int curDepth){
        if(node==null)return;
        if(curDepth == res.size()){
            res.add(node.val);
        }
        rightView(node.right,curDepth+1);
        rightView(node.left,curDepth+1);
    }
}