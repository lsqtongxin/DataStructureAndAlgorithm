class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n==1)return n;
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int l = intervals[0][0];
        int r = intervals[0][1];
        int cur = 1;
        int res = n;
        while(cur<n){
            int s = intervals[cur][0];
            int e = intervals[cur][1];
            if(  l<s && r>=e ){
                res--;
            }else if(l==s && r<e){
                res--;
                r = e;
            }else if(l==s && r>=e){
                res--;
            }else{
                l = s;
                r = e;
            }
            cur++;
        }
        return res;
    }
}