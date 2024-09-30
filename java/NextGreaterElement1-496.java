// 1. 暴力法寻找下一个更大的元素1
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[len1];
        Arrays.fill(ans,-1);
        for(int i=0;i<len1;i++){
            int j = 0;
            for(;j<len2;j++){
                if(nums1[i]==nums2[j])break;
            }
            // 找j右边下一个更大的元素
            int k = j+1;
            for(;k<len2;k++){
                if(nums2[k]>nums2[j]){
                    ans[i] = nums2[k];
                    break;
                }
            }
        }
        return ans;
    }
}
