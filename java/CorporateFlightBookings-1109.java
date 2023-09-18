// 差分数组
class Solution {
    int[] diff;
    public int[] corpFlightBookings(int[][] bookings, int n) {
        diff = new int[n];
        for(int i=0;i<bookings.length;i++){
            add(bookings[i][0]-1,bookings[i][1]-1,bookings[i][2]);
        }
        int[] res = new int[n];
        res[0]=diff[0];
        for(int i=1;i<n;i++){
            res[i] = diff[i] + res[i-1];
        }
        return res;
    }
    private void add(int l,int r,int k){
        diff[l]+=k;
        if(r+1 < diff.length){
            diff[r+1]-=k;
        }
    }
}
