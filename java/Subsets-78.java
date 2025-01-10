class Solution {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;
    }
    void backtrack(int[] nums,int start){
        res.add(new ArrayList<>(track));
        for(int i=start;i<nums.length;i++){
            track.add(nums[i]);
            backtrack(nums,i+1);
            track.remove(track.size()-1);
        }
    }
}

// 算法一样，只是语法不同
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return res;
    }

    private void dfs(int[] nums,int start){
        res.add(new ArrayList<>(stack));
        for(int i=start ;i<nums.length;i++){
            stack.push(nums[i]);
            dfs(nums,i+1);
            stack.pop();
        }
    }
}
