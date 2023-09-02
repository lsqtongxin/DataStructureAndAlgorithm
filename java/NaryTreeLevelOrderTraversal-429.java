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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null)return res;
        levelTraverse(root);
        return res;
    }
    void levelTraverse(Node node){
        if(node==null)return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i=1;i<=size;i++){
                Node temp = queue.remove();
                level.add(temp.val);
                for(int j=0;j<temp.children.size();j++){
                    queue.add(temp.children.get(j));
                }
            }
            res.add(level);
        }
    }
}