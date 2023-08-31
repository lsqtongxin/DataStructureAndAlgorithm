class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null)return null;
        if(intervals.length==1)return intervals;
        int n = intervals.length;
        // 这个语法需要学习一下
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int l = intervals[0][0];
        int r = intervals[0][1];
        int cur = 1;
        // 这种语法需要学习一下
        ArrayList<int[]> res = new ArrayList<>();
        while(cur<n){
            int s = intervals[cur][0];
            int e = intervals[cur][1];
            if(r>=s){
                r = Math.max(r,e);
            }else{
                // 这种语法需要学习一下
                res.add(new int[]{l,r});
                l = s;
                r = e;
            }
            cur++;
        }
        res.add(new int[]{l,r});
        // 这种语法需要学习一下
        return res.toArray(new int[res.size()][]);
    }
}