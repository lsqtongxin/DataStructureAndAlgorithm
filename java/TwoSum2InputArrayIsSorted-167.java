// 注意点：
//    1. 这题有唯一解
//    2. 数据是已经排好序的
//    3. 不能多次使用同一个元素,可以通过索引控制不是同一个元素
//    4. 以索引为1开始
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;
        while(l<r){
            if(numbers[l]+numbers[r]==target){
                return new int[]{l+1,r+1};
            }else if(numbers[l]+numbers[r]<target){
                l++;
            }else{
                r--;
            }
        }
        return new int[]{0,0};
    }
}

//    假设这题给定的数组有重复数字怎么办?
//    1. 这题有多个解
//    2. 数据已排好序，或如果乱序我们直接程序排序一下即可
//    3. 不能同时使用同一个元素
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;
        while(l<r){
            if(numbers[l]+numbers[r]==target){
                return new int[]{l+1,r+1};
            }else if(numbers[l]+numbers[r]<target){
                l++;
            }else{
                r--;
            }
        }
        return new int[]{0,0};
    }
}
