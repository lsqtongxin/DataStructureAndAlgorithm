// 滑动窗口 [) 左闭右开
// 1.  sum+=nums[right]这一块是扩容，但此时区间变为[left,right]此时是左闭右闭的
//     while里面的是 right-left+1，也是左闭右闭的
//     最后right++将其变为[)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length+1;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right<nums.length){
            sum+=nums[right];
            while(sum >=target && left<=right){
                res = Math.min(res,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        if(res==nums.length+1)return 0;
        return res;
    }
}

// 2. 这种更好一些
//    if这一大块是扩容窗口
//    while这一块是缩容窗口
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length+1;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right<nums.length){
            if(sum < target){
                sum+=nums[right];
                right++;
            }
            while(sum >=target && left<right){
                res = Math.min(res,right-left);
                sum-=nums[left];
                left++;
            }  
        }
        if(res==nums.length+1)return 0;
        return res;
    }
}
