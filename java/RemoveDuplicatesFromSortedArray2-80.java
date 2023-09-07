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
