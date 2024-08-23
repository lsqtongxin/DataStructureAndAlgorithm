// 1. 这采用了快速排序里面的分区的算法，通过每次找第几名得出结果
//    但是这个解决方法只能通过40/41个测试用例，而第41个测试用例的数组长度很长，导致超时无法通过leetcode
//    其实这是单路快排，
//    Time Complexity:
//	Best and Average Case: O(N)
//	Worst Case: O(N2)  退化
class Solution {
    // 求最终有序的逆序数组的坐标为k-1的值是多少
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length-1; 
        while(start<=end){
            int temp = partition(nums,start,end);
            if(temp == k-1){
                return nums[temp];
            }else if(temp > k-1){
                end = temp - 1;
            }else{//temp < k-1 逆序
                start = temp + 1;
            }
        }
        return -1;
    }
    public int partition(int[] nums,int l,int r){
        int pivot = nums[r];
        int i = l-1,j;
        for(j=l;j<r;j++){
            if(nums[j]>pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        i++;
        int temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
        return i;
    }
}
// 2. 优化为双路快排
//    通过首尾进行向中间移动
//    双路快排
//    这是最优的解决方案
//    这个能通过第41个测试用例
//    双路快排对于包含大量重复元素的数组，性能比单路快速排序更好，因为它能更有效地处理重复元素，减少分区不平衡的情况
class Solution {
    // 求最终有序的逆序数组的坐标为k-1的值是多少
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length-1; 
        while(start<=end){
            int temp = partition(nums,start,end);
            if(temp == k-1){
                return nums[temp];
            }else if(temp > k-1){
                end = temp - 1;
            }else{//temp < k-1 逆序
                start = temp + 1;
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
	    //  一定是 > 这样能分为两个子树，否则将会变一个数组
            while(i<=r && nums[i]>pivot)i++;
	    //  一定是 < 这样能分为两个子树，否则将会变一个数组
            while(j>=l+1 && nums[j]<pivot)j--;
            if(i>j)break;
            swap(nums,i,j);
            i++;
            j--;
        }
	// 注意这个交换的是 j
        swap(nums,l,j);
        return j;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// 3. 三路排序
//    不适合pivot在数组中存在有很多的情况,在这个题中这种解法也能通过，但是耗时太长
class Solution {
    // 求最终有序的逆序数组的坐标为k-1的值是多少
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length-1; 
        while(start<=end){
            int temp = partition(nums,start,end);
            if(temp == k-1){
                return nums[temp];
            }else if(temp > k-1){
                end = temp - 1;
            }else{//temp < k-1 逆序
                start = temp + 1;
            }
        }
        return -1;
    }

    public int partition(int[] nums,int l,int r){
        Random rand = new Random();
        int pivot_index = l + rand.nextInt(r - l + 1);
        int pivot = nums[pivot_index];
        swap(nums,l,pivot_index);
        // [l+1,lt] > pivot
        // [lt+1,i) == pivot
        // [gt,r] < pivot
        int i=l+1,lt=l,gt=r+1;
        while(i<gt){
            if(nums[i]==pivot){
                i++;
            }else if(nums[i]>pivot){
                lt++;
                swap(nums,i,lt);
                i++;
            }else { // nums[i]<pivot
                gt--;
                swap(nums,i,gt);
            }
        }
        swap(nums,l,lt);
        return lt;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


// 4. 通过小顶堆进行遍历操作
//    也是通过Java本身的数据结构来实现的
//    PriorityQueue默认实现的是小顶堆
//    Time Complexity: O(nlogk)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
// 5. 通过排序实现，这里省略
//    排序，然后依次取第k大的数即可
//    Time Complexity: O(nlogn)
