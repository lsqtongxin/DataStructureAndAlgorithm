class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return houseRobber(nums,0);
    }
    private int houseRobber(int[] nums,int x){
        if(x>=nums.length)return 0;
        if(memo[x]!=-1){
            return memo[x];
        }
        int res = 0;
        for(int i=x;i<nums.length;i++){
            res = Math.max(res,nums[i] + houseRobber(nums,i+2));
        }
        memo[x] = res;
        return memo[x];
    }
} 
