//  双路指针
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length==0)return nums;
        int s = 0,e = nums.length-1;
        while(s<e){
            while(s<nums.length && nums[s]%2==0)s++;
            while(e>=0 && nums[e]%2==1)e--;
            if(s>=e)break;
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
        return nums;
    }
}
