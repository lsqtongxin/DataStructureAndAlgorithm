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
// 1. 时间复杂度和空间复杂度最优
//    一边统计词频，一边进行比较
class Solution {
    HashMap<Integer,Integer> freqMap = new HashMap<>();
    ArrayList<Integer> resList = new ArrayList<>();
    int maxCount;
    int count;
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        if(root==null)return null;
        traverse(root);
        int[] res = new int[resList.size()];
        for(int i=0;i<resList.size();i++){
            res[i]=resList.get(i);
        }
        return res;
    }
    private void traverse(TreeNode node){
        if(node==null)return;
        traverse(node.left);
        if(pre==null || pre.val!=node.val){
            count = 1;
        }else{
            count++;
        }
        if(count>maxCount){
            resList.clear();
            maxCount = count;
            resList.add(node.val);
        }else if(count==maxCount){
            resList.add(node.val);
        }
        pre = node;
        traverse(node.right);
    }
}


// 2. 先统计词频，再进行处理
class Solution {
    HashMap<Integer,Integer> freqMap = new HashMap<>();
    public int[] findMode(TreeNode root) {
        if(root==null)return null;
        traverse(root);
        // 按频率倒序排序
        int maxFreq = -1;
        List<Integer> listRes = new ArrayList<>();
        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(maxFreq<freq){
                maxFreq = freq;
                listRes.clear();
                listRes.add(key);
                continue;
            }
            if(maxFreq==freq){
                listRes.add(key);
            }
        }
        return listRes.stream().mapToInt(Integer::valueOf).toArray();

    }
    private void traverse(TreeNode node){
        if(node==null)return;
        freqMap.put(node.val,freqMap.getOrDefault(node.val,0)+1);
        traverse(node.left);
        traverse(node.right);
    }
}


// 3. 最差的方法，先统计词频，然后再词频进行排序，再根据最大词频数进行遍历，得出结果
//    这种最慢，但功能最全，例如：求按词频排序的所有数字
class Solution {
    HashMap<Integer,Integer> freqMap = new HashMap<>();
    public int[] findMode(TreeNode root) {
        if(root==null)return null;
        traverse(root);
        // 按频率倒序排序
        List<Map.Entry<Integer, Integer>> sortedElements = new ArrayList<>(freqMap.entrySet());
        sortedElements.sort((a, b) -> {
            int freqComparison = Integer.compare(b.getValue(), a.getValue());
            return (freqComparison == 0) ? Integer.compare(a.getKey(), b.getKey()) : freqComparison;
        }); 
        List<Integer> res = new ArrayList<>();
        //int max = sortedElements.get(0).getVaule();
        Map.Entry<Integer,Integer> first = sortedElements.get(0);
        int max = first.getValue();
        for (Map.Entry<Integer, Integer> entry : sortedElements) {
            if(max == entry.getValue()){
                res.add(entry.getKey());
            }
        } 
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    private void traverse(TreeNode node){
        if(node==null)return;
        freqMap.put(node.val,freqMap.getOrDefault(node.val,0)+1);
        traverse(node.left);
        traverse(node.right);
    }
}
