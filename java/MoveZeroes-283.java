// 双指针-前后指针
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==1)return;
        int cur = 0;
        int index = 0;
        while(cur<nums.length){
            if(nums[cur]==0){
                cur++;
            }else{
                nums[index]=nums[cur];
                index++;
                cur++;
            }
        }
        while(index<nums.length){
            nums[index]=0;
            index++;
        }
    }
}
