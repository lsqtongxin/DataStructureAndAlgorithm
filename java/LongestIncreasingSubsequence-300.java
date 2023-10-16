// 递归方式，这种方法重复计算了很多值
class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = lengthRecursion(nums,0);
        for(int i=1;i<nums.length;i++){
            int temp = lengthRecursion(nums,i);
            if( temp>max){
                max = temp;
            }
        }
        return max;
    }
    private int lengthRecursion(int[] nums,int start){
        if(start==nums.length-1)return 1;
        int max = 1;
        for(int i=start+1;i<nums.length;i++){
            if(nums[start]<nums[i]){
                max = Math.max(max,1+lengthRecursion(nums,i));
            }
        }
        return max;
    }
}



// 2. 记忆化搜索 
//    其实可以理解为： 递归的减枝 或 带备忘录的递归
//    与递归非常类似，只是在第一种纯递归上增加了存储，以空间换时间
class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = lengthRecursion(nums,0);
        for(int i=1;i<nums.length;i++){
            int temp = lengthRecursion(nums,i);
            if( temp>max){
                max = temp;
            }
        }
        return max;
    }
    private int lengthRecursion(int[] nums,int start){
        if(start==nums.length-1)return 1;
	// 这里为1，是因为最差的情况是 nums[start] 独自1个数字成为最长上升子序列 
        int max = 1;
	// 然后按顺序依次寻找后续的最长然后+1得到自己的最长
        for(int i=start+1;i<nums.length;i++){
            if(nums[start]<nums[i]){
                max = Math.max(max,1+lengthRecursion(nums,i));
            }
        }
        return max;
    }
}

// 3. 动态规划，则改变计算方向，直接从递归改为了迭代
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,1);
        for(int i=nums.length-1;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    res[i] = Math.max(res[i],1+res[j]);
                }
            }
        }
        int max = res[0];
        for(int i=1;i<nums.length;i++){
            if(max<res[i]){
                max = res[i];
            }
        }
        return max;
    }
}
