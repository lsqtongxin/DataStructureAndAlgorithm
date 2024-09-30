//1.  归并排序：关键点是需要额外的数组进行盛放一些临时结果，并且还要把结果复制到原有的数组中
//           额外数组一直是从0开始索引，而原始数组在不停的递归中是从某一个索引开始的,一定注意其偏差量offset
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    void mergeSort(int[] nums,int l,int r){
        if(l>=r)return;
        int mid = l + (r-l)/2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        merge(nums,l,mid,r);
    }
    void merge(int[] nums,int l,int mid,int r){
        int[] temp = new int[r-l+1];
        int cur1=l;
        int cur2=mid+1;
        int cur = 0;
        while(cur1<=mid && cur2<=r){
            if(nums[cur1]<=nums[cur2]){
                temp[cur]=nums[cur1];
                cur++;
                cur1++;
            }else{
                temp[cur]=nums[cur2];
                cur++;
                cur2++;
            }
        }
        while(cur1<=mid){
            temp[cur]=nums[cur1];
            cur++;
            cur1++;
        }
        while(cur2<=r){
            temp[cur]=nums[cur2];
            cur++;
            cur2++;
        }
	// 将临时的结果顺序，逐步复制到原有数组，注意偏移量offset
        for(int i=0,j=l;i<temp.length;i++,j++){
            nums[j]=temp[i];
        }
    }
}

// 2. quickSort
class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length==0)return nums;
        _sort(nums,0,nums.length-1);
        return nums;
    }
    // 
    public void _sort(int[] nums,int left,int right){
        if(left>=right)return;
        int pivot = partition(nums,left,right);
        _sort(nums,left,pivot-1);
        _sort(nums,pivot+1,right);
    }
    public int partition(int[] nums,int left,int right){
        Random r = new Random();
        int randPivot = r.nextInt(right-left + 1) + left;
        int pivot = nums[randPivot];
        swap(nums,randPivot,right);
        int s = left, e = right-1;
        while(s<=e){
            while(s<right && nums[s]<pivot)s++;
            while(e>=left && nums[e]>pivot)e--;
            if(s>e)break;
            swap(nums,s,e);
            s++;
            e--;
        }
        swap(nums,s,right);
        return s;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
