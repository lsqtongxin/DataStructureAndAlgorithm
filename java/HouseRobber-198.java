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

