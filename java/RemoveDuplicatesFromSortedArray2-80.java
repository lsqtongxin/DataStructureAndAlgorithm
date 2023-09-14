// 滑动窗口
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<3)return nums.length;
        int slow = 2;
        for(int fast=2;fast<nums.length;fast++){
            if(nums[slow-2]!=nums[fast]){
                nums[slow++]=nums[fast];
            }
        }
        return slow;
    }
}

// 双指针
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<3)return nums.length;
        int left = 0,right =0;
        int step = 0;
        while(right<nums.length){
            // 增大窗口
            while(right<nums.length && nums[right]==nums[left])right++;
            
            // 此时nums[right]!=nums[left] 开始缩小窗口
            if(right-left>=2){
                nums[step]=nums[left];
                nums[step+1]=nums[left];
                step+=2;
                left=right;
            }else {
                nums[step]=nums[left];
                step++;
                left++;
            }
        }
        return step;
    }
}

// 双指针
class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        int step = 0;
        while(right<nums.length){
            while(right<nums.length && nums[left]==nums[right])right++;
            if(right-left>=2){
                nums[step]=nums[left];
                nums[step+1]=nums[left];
                step+=2;
            }else{
                nums[step]=nums[left];
                step++;
            }
            left=right;
        }
        return step;
    }
}

// 这题会演变成保存3个相同的，或4个相同的，或5个相同的等等，都是换汤不换药
