// 二分搜索，将数组分成两个部分，分别进行查找，然后返回结果
class Solution {
    public int search(int[] nums, int target) {
        if(nums==null)return -1;
        int i=0;
        while(i+1<nums.length && nums[i]<nums[i+1]){
            i++;
        }
        if(i+1>=nums.length){
            return binarySearch(nums,0,nums.length-1,target);
        }
        int first = binarySearch(nums,0,i,target);
        int second= binarySearch(nums,i+1,nums.length-1,target);
        if(first!=-1)return first;
        if(second!=-1)return second;
        return -1;
    }
    private int binarySearch(int[] nums,int start,int end,int target){

        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}
