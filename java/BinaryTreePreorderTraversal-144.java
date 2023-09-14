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
// 前序遍历-递归版本
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)return res;
        preOrder(root);
        return res;
    }
    private void preOrder(TreeNode node){
        if(node==null)return;
        res.add(new Integer(node.val));
        preOrder(node.left);
        preOrder(node.right);
    }
}

// 前序遍历-迭代版本1
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
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(stack.size()!=0){
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if(temp.right!=null)stack.push(temp.right);
            if(temp.left!=null)stack.push(temp.left);
        }
        return res;
    }
}

// 前序遍历-迭代版本2
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!=null || stack.size()!=0){
            while(cur!=null){
                res.add(cur.val);
                stack.push(cur);
                cur=cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }
}

// 前序遍历-迭代版本3
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!=null || stack.size()!=0){
            if(cur!=null){
                res.add(cur.val);
                stack.push(cur);
                cur=cur.left;
            }else{
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return res;
    }
}
