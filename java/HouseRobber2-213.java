class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        if(nums.length==2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        int[] memo = new int[nums.length];
        // 整体算两次
        Arrays.fill(memo,-1);
        // 从0开始算一次最大值，注意不能取最后一个值
        int result = houseRobber2(nums,memo,0,0);
        Arrays.fill(memo,-1);
        // 从1开始算一次最大值
        return Math.max(result,houseRobber2(nums,memo,1,1));
    }
    private int houseRobber2(int[] nums,int[] memo,int start,int index){
        if(index>=nums.length)return 0;
        // 区分当开始是0的情况，那么最后一个肯定不能取，否则会报警
        if(index==nums.length-1&&start==0)return 0;
        if(memo[index]!=-1){
            return memo[index];
        }
        int res = 0;
        res = Math.max(res,houseRobber2(nums,memo,start,index+1));
        res = Math.max(res,nums[index]+houseRobber2(nums,memo,start,index+2));
        memo[index] = res;
        return res;
    }
}