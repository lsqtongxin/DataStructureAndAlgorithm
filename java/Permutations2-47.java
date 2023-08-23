class Solution {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();
    boolean[] selected;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        selected = new boolean[nums.length];
        backtrack(nums);
        return res;
    }
    void backtrack(int[] nums){
        if(track.size() == nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(selected[i])continue;
	    // 减值方法，重要的一行代码
            if(i>0 && nums[i]==nums[i-1] && !selected[i-1])continue;
            track.add(nums[i]);
            selected[i]=true;
            backtrack(nums);
            track.remove(track.size()-1);
            selected[i]=false;
        }
    }
}
