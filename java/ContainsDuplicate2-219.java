//  1. 固定窗口的滑动
//     先形成固定窗口，再依次滑动   
//     先左后右
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0)return false;
        int left=0,right=0;
        Set<Integer> set = new HashSet<Integer>();
        int cur = k+1;
        // 固定窗口已形成，窗口大小最大为 k+1
        while(right<nums.length && cur>0){
            boolean temp = set.add(nums[right]);
            if(temp==false)return true;
            cur--;
            right++;
        }
        // 逐步滑动,先左后右
        while(right<nums.length){
            set.remove(nums[left]);
            left++;
            if(!set.add(nums[right])){
                return true;
            };
            right++;
        }
        return false;
    }
}

// 2. 滑动窗口
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0)return false;
        int left=0;
        int right=0;
        Set<Integer> set = new HashSet<>();
        while(right<nums.length){
            boolean temp = set.add(nums[right]);
            if(temp==false && right-left<=k)return true;
            if(set.size()>k){
                set.remove(nums[left]);
                left++;
            }
            right++;
        }
        return false; 
    }
}
