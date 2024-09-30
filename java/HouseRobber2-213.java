// 1. 这个比198题多了一个限制，就是环形的房屋结构
//    第198题的关键是 0 和 n-1 不挨着
//    第213题的关键是 0 和 n-1 挨着
//    通过 关键的第0号房屋，来进行分隔和截断
//    我们是否可以先将 第0个房屋摧毁掉,让他们本身环型的房屋断开
//    如果第0个房屋不抢劫，那么问题转化为求[1,n-1]这个区间的最大值，与198题一模一样，区间少了第0个房屋而已
//    如果第0个房屋要抢劫，那么问题转化为求[2,n-2]这个区间的最大值, 与198题一模一样，区间少了0、1、n-1这三个房屋而已，最终再加上第0个房屋的值
//    将上述两个情况进行比较，求最大值即可
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        if(nums.length==2)return nums[0]>nums[1]?nums[0]:nums[1];
        int temp1 = robInterval(nums,1,nums.length-1);
        int temp2 = nums[0] + robInterval(nums,2,nums.length-2);
        return temp1>temp2?temp1:temp2;
    }
    public int robInterval(int[] nums,int l,int r){
        if(l>r)return 0;
        if(r==l)return nums[l];
        if(r-l==1)return nums[l]>nums[r]?nums[l]:nums[r];
        int size = r-l+1;
        int[] other = new int[size];
        for(int i=0,j=l;i<size;i++,j++){
            other[i] = nums[j];
        }
        // dp[i] = max( nums[i] + dp[i-2] , dp[i-1])
        int[] dp = new int[size];
        dp[0] = other[0];
        dp[1] = other[0]>other[1]?other[0]:other[1];
        for(int i=2;i<size;i++){
            int temp = other[i] + dp[i-2];
            dp[i] = temp>dp[i-1]?temp:dp[i-1];
        }
        return dp[size-1];
    }
}

//2.
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
