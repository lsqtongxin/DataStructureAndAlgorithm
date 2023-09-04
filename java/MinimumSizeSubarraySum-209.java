class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length+1;
        int l = 0;
        int r = 0;
        int sum = 0;
        while(r < nums.length){
            sum+=nums[r];
            while(sum>=target){
                sum-=nums[l];
                res = Math.min(res,r-l+1);
                l++;
            }
            r++;
        }
        if(res == nums.length+1)return 0;
        return res;
    }
}