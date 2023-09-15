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
// hibbard deletion
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return root;
        root = delete(root,key);
        return root;
    }
    private TreeNode delete(TreeNode node,int key){
        if(node==null)return null;
        if(key < node.val){
            node.left = delete(node.left,key);
            return node;
        }else if( node.val < key){
            node.right = delete(node.right,key);
            return node;
        }else {
            if(node.left==null){
                TreeNode rightNode = node.right;
                node.right = null;
                return rightNode;
            }else if(node.right==null){
                TreeNode leftNode = node.left;
                node.left = null;
                return leftNode;
            }else{
                // 先找后继节点并新建一个同样的节点
                TreeNode temp = findMin(node.right);
                TreeNode successor = new TreeNode(temp.val);
                // 设置这个节点左子树
                successor.left = node.left;
                //  删除右子树的后继节点并返回，并进行连接
                successor.right= delMin(node.right);
                // 将原有节点进行置空
                node.left = null;
                node.right = null;
                return successor;
            }
        }
    }
    private TreeNode findMin(TreeNode node){
        if(node==null)return node;
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }
    private TreeNode delMin(TreeNode node){
        if(node.left==null){
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = delMin(node.left);
        return node;
    }
}