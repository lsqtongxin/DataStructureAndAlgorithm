// 0. 动态规划
//    dp[i]代表从[0,i]的这个区间进行打家劫舍的最大值
//    dp[i] = max( nums[i] + dp[i-2] , dp[i-1]   )
//    上面的公式也就是说 每个房屋只有  被抢劫和未抢劫 这两种状态
//    如果抢劫了第i个房屋，同时为了不自动报警，只能是选择前面的区间[0,i-2]的最大值
//    如果不抢劫第i个房屋，那么只需要选择前面的[0,i-1]的最大值即可
//    我们只求这两种状态下的最大值即可。 
class Solution {
    public int rob(int[] nums) {
	// 特殊情况： 如果只有一个房屋，那么进行抢劫即可。
        if(nums.length==1)return nums[0];
        // dp[i] = max( nums[i]+dp[i-2]  ,  dp[i-1] )
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1]>dp[0]?nums[1]:dp[0];
        int maxValue = dp[0]>dp[1]?dp[0]:dp[1];
	// 特殊情况: 如果只有两个房屋，抢其中一个值最大的即可
        if(nums.length==2)return maxValue;
        for(int i=2;i<nums.length;i++){
            int temp = nums[i]+dp[i-2];
            dp[i] =  temp>dp[i-1]?temp:dp[i-1];
            maxValue = dp[i]>maxValue?dp[i]:maxValue;
        }
        return maxValue;
    }
}

// 1. 记忆化搜索
class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return houseRobber(nums,0);
    }
    // 状态函数： 从x开始至最后的节点的可以偷取不报警的最大值
    //            可以选择x节点，亦或是不选择x节点
    private int houseRobber(int[] nums,int x){
        if(x>=nums.length)return 0;
        if(memo[x]!=-1){
            return memo[x];
        }
        int res = 0;
	// 当我们去偷取的时候，选择x这个节点，并从x+2位置进行选择
        res = Math.max(res,nums[x] + houseRobber(nums,x+2));
	// 或者 我们不选择x这个节点，并从x+1位置进行选择
        res = Math.max(res,houseRobber(nums,x+1));
	// 总结：求上面最大值	
        memo[x] = res;
        return memo[x];
    }
}

// 这个答案也能AC,但是这个就演变为一棵递归树了,通过for循环横向遍历这一整棵递归树进行寻找最大值
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
	    // 这个都按照 选择当前的i节点进行操作的
            res = Math.max(res,nums[i] + houseRobber(nums,i+2));
        }
        memo[x] = res;
        return memo[x];
    }
} 

