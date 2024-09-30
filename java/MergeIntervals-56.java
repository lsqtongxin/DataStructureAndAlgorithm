// 1. 一个一个的合并，按顺序合并，注意l和r的赋值
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)return new int[0][2];
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] interval1,int[] interval2){
                return interval1[0]-interval2[0];
            }
        });
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int l = intervals[0][0];
        int r = intervals[0][1];
        int cur = 1;
        while(cur<n){
            if(intervals[cur][0]<=r){
                r = Math.max(intervals[cur][1],r);
            }else {  // intervals[cur][0] > r
                ans.add(new int[]{l,r});
                l = intervals[cur][0];
                r = intervals[cur][1];
            }
            cur++;    
        }
        ans.add(new int[]{l,r});
        return ans.toArray(new int[ans.size()][]);
    }
}



// 2. 
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)return new int[0][2];
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] interval1,int[] interval2){
                return interval1[0]-interval2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for(int[] p: intervals){
            int size = ans.size();
            if(size == 0 || ans.get(size-1)[1] < p[0]){
                ans.add(p);
            }else{
                ans.get(size-1)[1] = Math.max(p[1],ans.get(size-1)[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
