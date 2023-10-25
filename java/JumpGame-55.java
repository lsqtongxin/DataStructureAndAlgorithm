// 1. 动态规划方法，这个时间和空间复杂度有点高
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1)return true;
        boolean[] memo = new boolean[nums.length];
        Arrays.fill(memo,false);
        memo[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;i--){
            for(int j=1;j<=Math.min(nums[i],nums.length-1-i);j++){
                boolean temp = false;
                if(nums[i]>=j){
                    temp = true;
                    temp = temp && memo[i+j];
                }
                memo[i] = memo[i] || temp;
            }
        }
        return memo[0];
    }
}
// 2.
class Solution {
    public boolean canJump(int[] nums) {
       int reachable = 0;
       for(int i = 0; i < nums.length; i ++) {
           if(i > reachable) return false;
           reachable = Math.max(reachable, i + nums[i]);
       } 
       return true;
    }
}
