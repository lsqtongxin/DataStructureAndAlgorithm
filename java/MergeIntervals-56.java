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

// 2. 使用ArrayList是因为不知道最后结果是几个数组，所以是动态的，这个容器必须得使用。
//    当ArrayList为空的时候，把第一个直接加入即可
//    后续需要判断ArrayList最后一个元素，与新添加元素的关系
//    如果不重叠，则直接加入，如果有重叠，则判断最后的区间右侧的点
//    并移除之前的区间，把合并后的新区间进行添加即可
//    这里有一个排序，需要记忆，因为Java语言有其语法和专用的类

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)return new int[0][2];
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] arr1,int[] arr2){
                return arr1[0]-arr2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(ans.isEmpty()){
                ans.add(intervals[i]);
            }else {
                int[] temp = ans.get(ans.size()-1);
                if(temp[1]<intervals[i][0]){
                    ans.add(intervals[i]);
                }else{
                    temp[1] = Math.max(temp[1],intervals[i][1]);
                    ans.remove(ans.size()-1);
                    ans.add(temp);
                }
            }
        }

        //int[][] res = new int[ans.size()][2];
        //for(int i=0;i<ans.size();i++){
        //    res[i] = ans.get(i);
        //}
        //return res;
        return ans.toArray(new int[ans.size()][]);
        
    }
}


// 3. 
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
