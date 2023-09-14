// 双指针之前后指针
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null)return 0;
        int cur = 1;
        int index = 0;
        while(cur<nums.length){
            if(nums[cur]==nums[index]){
                cur++;
            }else if(nums[cur]>nums[index]){
                index++;
                nums[index]=nums[cur];
                cur++;
            }
        }
        return index+1;
    }
}
