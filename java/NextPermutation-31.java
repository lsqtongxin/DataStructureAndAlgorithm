// 1.
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(isJiangxu(nums)==1){
            reverse(nums,0,len-1);
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1,len-1);
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
    private void reverse(int[] nums,int start,int end){
        if(start>=end)return;
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
        return;
    }
    private int isJiangxu(int[] nums){
        for(int i=0;i+1<nums.length;i++){
            if(nums[i]<nums[i+1])return 0;
        }
        return 1;
    }
}
