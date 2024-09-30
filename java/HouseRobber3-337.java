// 错误的思路：
//     1.通过层序遍历，求出每一层节点的和
//     2.然后把每一层的和放到一个数组或ArrayList中
//     3.将这个题 简化为求 HouseRobber 198的题
//       因为不同层的肯定不相邻，比如：我取1和3，或2和4层，或1和4层
//       心里想这不就是 HouseRobber 198的翻版嘛
// 结论：
//     其实本题不是198的翻版，比如：[ 2,1,3,null,4 ]
//     最大值正确的结果是7，而我得出的是6，所以这个思路就是错误的。

// 这道题的核心是如何判断两个节点，或多个节点是否相邻
//     2
//   1   3
//  n 4
// 比如：我第一次选择了2，那么我是否能选择1，是否能选择4 ? 
//       我选择了3，我能否选择4，如何判断
//       同一个树杈上的节点，不能同时选择孙子和儿子，但是 不同树杈可以选择儿子和孙子
// 之前的HouseRobber198题，数据结构是一个线性数组，而此题是一个二叉树
// 而数组可以通过 start到start+2进行隔离
// 而二叉树的隔离需要有一个判断方法或方式,这是一个待思考的问题，下次再讨论

// 整体来说这题并不需要 判断两个节点是否是相邻或有连接的，而是通过类似于数组那种通过指针就隔离
// 0. 暴力求解
//    因为是二叉树，所以一个爷爷节点，最多有四个孙子
//    爷爷节点偷不偷？ 是后面的关键
//    爷爷节点也是当前的节点，
//    如果偷爷爷，那么下一步只能是孙子
//    如果不偷爷爷，那么下一步是儿子
//    最后这两种方式下选择最大的值

class Solution {
    public int rob(TreeNode root) {
        if(root==null)return 0;
        int ans = 0;
        ans += root.val;
        if(root.left!=null){
            ans += rob(root.left.left);
            ans += rob(root.left.right);
        }
        if(root.right!=null){
            ans += rob(root.right.left);
            ans += rob(root.right.right);
        }
        return Math.max(ans, rob(root.left)+rob(root.right));
    }
}

1. 记忆化搜索
// 此题采用 hashmap进行暂存结果
class Solution {
    HashMap<TreeNode,Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null)return 0;
        return houseRobber3(root);
    }
    private int houseRobber3(TreeNode node){
        if(node==null)return 0;
        if(memo.containsKey(node)){
            return memo.get(node);
        }
        int res = 0;
        if(node.left!=null){
            res+=houseRobber3(node.left.left);
            res+=houseRobber3(node.left.right);
        }
        if(node.right!=null){
            res+=houseRobber3(node.right.left);
            res+=houseRobber3(node.right.right);
        }
        int temp = Math.max(node.val+res,houseRobber3(node.left)+houseRobber3(node.right));
        memo.put(node,temp);
        return temp;
    }
}

2. DFS方法
class Solution {
    public int rob(TreeNode root) {
        if(root==null)return 0;
        int[] res = houseRobber3(root);
        return Math.max(res[0],res[1]);
    }
    private int[] houseRobber3(TreeNode node){
        if(node==null)return new int[2];
        int[] left = houseRobber3(node.left);
        int[] right= houseRobber3(node.right);
        int[] res = new int[2];
        res[0] = node.val + left[1] + right[1];
        res[1] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return res;
    }
}
