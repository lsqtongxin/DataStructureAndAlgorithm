class Solution {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0);
        return res;
    }
    void backtrack(int[] nums,int start){
        res.add(new ArrayList<>(track));
        for(int i=start;i<nums.length;i++){
            // 减枝
            if(i > start && nums[i]==nums[i-1])continue;
            track.add(nums[i]);
            backtrack(nums,i+1);
            track.remove(track.size()-1);
        }
    }
}
