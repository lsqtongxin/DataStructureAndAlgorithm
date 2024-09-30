// 1.滑动窗口
//   空间复杂度为O(1)
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        if(nums.length==0)return nums;
        int s = 0;
        while(s<nums.length){
            if(nums[s]%2 == s%2){
                s++;
                continue;
            }else {
                int i;
                for(i=s+1;i<nums.length;i++){
                    if(s%2 == nums[i]%2)break;
                }
                int temp = nums[i];
                nums[i] = nums[s];
                nums[s] = temp;
                s++;
            }
        }
        return nums;
    }
}

// 2. 直接进行放置，这个就是比较清晰，空间复杂度为O(n)
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        if(nums.length==0)return nums;
        int[] ans = new int[nums.length];
        int ji=1,ou=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                // ji
                ans[ji] = nums[i];
                ji+=2;
            }else{
                // ou
                ans[ou] = nums[i];
                ou+=2;
            }
        }
        return ans;
    }
}
