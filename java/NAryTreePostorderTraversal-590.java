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
    public List<Integer> postorder(Node root) {
        postOrder(root);
        return res;
    }
    private void postOrder(Node node){
        if(node==null)return;
        for(int i=0;i<node.children.size();i++){
            postOrder(node.children.get(i));
        }
        res.add(node.val);
    }
}
