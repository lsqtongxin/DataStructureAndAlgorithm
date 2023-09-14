class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null)return 0;
        int cur = 0;
        int index = 0;
        while(cur<nums.length){
            if(nums[cur]==val){
                cur++;
            }else{
                nums[index]=nums[cur];
                index++;
                cur++;
            }
        }
        return index;
    }
}
