// 这题注意点：
//    1. 返回的二维数组不能包括 重复的解
//    2. 但是每个解中可以包括相同的元素
// 例如：
//  Input: nums = [-1,0,1,2,-1,-4]
//  Output: [[-1,-1,2],[-1,0,1]]
//  
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return results;
        }
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2; i++){
            // skip duplicates
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    results.add(result);
                    left++;
                    right--;
                    // moving left pointer to right to skip duplicates
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    // moving right pointer to left to skip duplicates 
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                    
                } else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                } else{
                    right--;
                } 
            } 
        }
        return results;
    }
}
