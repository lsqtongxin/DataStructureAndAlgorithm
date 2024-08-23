// 荷兰国旗问题
// 这个题目有两个方法
// 1. 三路排序： 将双路排序和单路排序相融合，使得区域为
//   通过随机取索引，得到随机的pivot，并swap到l
//   所以 l 是 pivot
//   [l+1,lt] < pivot
//   [lt+1,i) == pivot
//   [gt,r]  > pivot
//   通过不断的判断 i 和pivot的大小关系来实现排序
//   它和 双路和单独快排不一样的是，三路快排的pivot可能是一个区域 
class Solution {
    public void sortColors(int[] nums) {
        if(nums.length==1)return;
        if(nums.length==2){
            if(nums[0]>nums[1]){
                swap(nums,0,1);
                return;
            }
        }
        quickSort3Ways(nums,0,nums.length-1);
    }
    public void quickSort3Ways(int[] nums,int l,int r){
        if(l>=r)return;
        Random rand = new Random();
        int pivot_index = l + rand.nextInt(r-l+1);
        int pivot = nums[pivot_index];
        swap(nums,l,pivot_index);
        // [l+1,lt] < pivot
        // [lt+1,i) = pivot
        // [gt,r] > pivot
        int lt = l, gt = r+1;
        int i = l+1;
        while(i < gt){
            if(nums[i]==pivot){
                i++;
            }else if(nums[i]<pivot){
                lt++;
                swap(nums,i,lt);
                i++;
            }else{ //nums[i]>pivot
                gt--;
                swap(nums,i,gt);
            }
        }
        swap(nums,l,lt);
        quickSort3Ways(nums,l,lt-1);
        quickSort3Ways(nums,gt,r);
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// 2. 通过遍历一遍得出结果
//    这种方法充分利用了这个数组只有3个数值(只有0，1，2),这是最特殊的条件
//    和第一种方法的 区间也近乎一样
//    [0,lt] == 0
//    [lt+1,i) == 1 
//    [gt,nums.length-1] == 2
class Solution {
    public void sortColors(int[] nums) {
        if(nums.length==1)return;
        if(nums.length==2){
            if(nums[0]>nums[1]){
                swap(nums,0,1);
                return;
            }
        }
        //  [0,lt] == 0
        //  [lt+1,i) == 1
        //  [gt,nums.length-1] == 2
        int lt = -1, gt = nums.length;
        for(int i =0;i<gt;){
            if(nums[i]==0){
                lt++;
                swap(nums,lt,i);
                i++;
            }else if(nums[i]==1){
                i++;
            }else{ // nums[i]==2
                gt--;
                swap(nums,i,gt);
            }
        }
        return;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
