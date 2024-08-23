// 这题类似于215找第k大的数
// 区别于 414这个题目需要去重
// 1. 第一种方法是通过快速排序中的分区方式
//    这里采用双路快排
class Solution {
    public int thirdMax(int[] nums) {
        // 去重
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for(Integer num:set){
            result[index++] = num;
        }
        // 看结果集的大小
        if(result.length<3){
            if(result.length==2){
                return result[0]>result[1]?result[0]:result[1];
            }else{
                return result[0];
            }
        }

        return findKthLargest(result, 3);
    }
    public int findKthLargest(int[] nums,int k){
        int start = 0,end = nums.length-1;
        while(start<=end){
            int temp = partition(nums,start,end);
            if(temp==k-1){
                return nums[temp];
            }else if(temp < k-1){
                start = temp + 1;
            }else { // temp > k-1
                end = temp -1;
            }
        }
        return -1;
    }
    public int partition(int[] nums,int l,int r){
        Random rand = new Random();
        int pivot_index = l + rand.nextInt(r - l + 1);
        int pivot = nums[pivot_index];
        swap(nums,l,pivot_index);
        int i=l+1,j=r;
        while(true){
            while(i<=r && nums[i]>pivot)i++;
            while(j>=l+1 && nums[j]<pivot)j--;
            if(i>j)break;
            swap(nums,i,j);
            i++;
            j--;
        }
        swap(nums,l,j);
        return j;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// 2. 通过找到三个更小值，来依次找第三大的值
class Solution {
    public int thirdMax(int[] nums) {
        // a, b, c: c 是第三大的数
        long a = Long.MIN_VALUE; 
        long b = Long.MIN_VALUE; 
        long c = Long.MIN_VALUE; 

        for(int num: nums){
            if(num > a){
                c = b;
                b = a;
                a = num;
            }else if(num < a && num > b){
                c = b;
                b = num;
            }else if(num < b && num > c){
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c; 
    }
}
// 3. 直接放到 TreeSet中又能去重又能排序
//    这个题直接使用了Java里面的数据结构
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> s = new TreeSet<Integer>();
        for (int num : nums) {
            s.add(num);
            if (s.size() > 3) {
                s.remove(s.first());
            }
        }
        return s.size() == 3 ? s.first() : s.last();
    }
}
