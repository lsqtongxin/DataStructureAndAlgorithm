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
	    // 这是一个优化，因为如果三个已排序的数字的和为0
	    // 那么最小的数，即第一个数一定是负数，否则找不到三个数字的和为0的情况
	    if(nums[i]>0)break;
            // skip duplicates
	    // 这个去重需要重点理解，与其他不同的是
	    // nums[i-1]后面所查找的范围是[i,nums.length-1]
	    // nums[i]  后面所查找的范围是[i+1,nums.length-1]
	    // 因为 nums[i-1]和nums[i]相等，其余两个数字的和也是相同的
	    // 唯一不同的就是 后面的查找范围
	    // 而 [i+1,nums.length-1]范围内查找的数字组合的集合是[i,nums.length-1]的子集
	    // 也就是在[i,nums.length-1]的结果已经包括了[i+1,nums.length-1]的结果
	    // 所以这样能去除重复
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
		    // 当第一个数字固定，则第二个和第三个的和就是固定的
		    // 同时数组是排序的，所以相同的数字都是相邻的
		    // 当left前进和right后退，进行夹逼的过程中
		    // 如果有相同的数字就进行略过，这样避免了和首次找到的值重复
                    while(left < right && nums[left] == nums[left - 1])left++;
                    // moving right pointer to left to skip duplicates 
                    while(left < right && nums[right] == nums[right + 1])right--;
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
