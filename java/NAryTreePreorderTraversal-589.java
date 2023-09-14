/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        preOrder(root);
        return res;
    }
    private void preOrder(Node node){
        if(node==null)return;
        res.add(node.val); 
        for(int i=0;i<node.children.size();i++){
            preOrder(node.children.get(i));
        }
    }
}
