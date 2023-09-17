class Solution {
    int[][] d;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==1)return nums;
        int e = (int)(Math.log(nums.length)/Math.log(2));
        d = new int[nums.length][e+1];
        RMQInit(nums);
        int[] res = new int[nums.length-k+1];
        for(int i=0;i+k-1<nums.length;i++){
            res[i]= RMQ(i,i+k-1);
        }
        return res;
    }
    private void RMQInit(int[] nums){

        for(int i=0;i<nums.length;i++){
            d[i][0]=nums[i];
        }
        for(int j=1; (1<<j)<=nums.length;j++ ){
            for(int i=0;i+(1<<j)-1<nums.length;i++){
                d[i][j]=Math.max(d[i][j-1],d[i+(1<<(j-1))][j-1]);
            }
        }
    }
    private int RMQ(int l,int r){
        int e = (int)(Math.log(r-l+1)/Math.log(2));
        return Math.max(d[l][e],d[r-(1<<e)+1][e]);
    }
}