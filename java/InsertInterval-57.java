class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        List<int[]> ans = new ArrayList<>();
        if(length==0){
            ans.add(newInterval);
            return ans.toArray(new int[ans.size()][]);
        }
        // 判断 新区间和老区间数组的重叠情况
        // 确认 新区间和老区间里面的谁有重叠
        int cur;
        for(cur=0;cur<length;cur++){
            if(newInterval[1]<intervals[cur][0] 
            || intervals[cur][1]< newInterval[0]){
                continue;
            }else{
                break;
            }
        }
        if(length==cur){
            // 没有重叠
            // 直接插入即可，但是需要重新寻找插入位置
            int i;
            for(i=0;i<length;i++){
                if(intervals[i][0]<newInterval[0]){
                    continue;
                }else {
                    break;
                }
            }
            for(int s=0;s<i;s++){
                ans.add(intervals[s]);
            }
            ans.add(newInterval);
            for(int s=i;s<length;s++){
                ans.add(intervals[s]);
            }
            return ans.toArray(new int[ans.size()][]);
        }else{
            // 重叠了，在cur位置重叠了
            // 下面继续分析
            //  
            for(int i=0;i<cur;i++){
                ans.add(intervals[i]);
            }
            int[] temp = new int[2];
            temp[0] = Math.min(intervals[cur][0],newInterval[0]);
            temp[1] = Math.max(intervals[cur][1],newInterval[1]);
            if(cur+1<length && temp[1]<intervals[cur+1][0]){
                    ans.add(temp);
                    for(int i=cur+1;i<length;i++){
                        ans.add(intervals[i]);
                    }
                    return ans.toArray(new int[ans.size()][]);
            }else {
                int i;
                for(i=cur+1;i<length;i++){
                    if(temp[1]>=intervals[i][0]){
                        temp[1] = Math.max(temp[1],intervals[i][1]);
                    }else {
                        break;
                    }
                }
                ans.add(temp);
                for(int j=i;j<length;j++){
                    ans.add(intervals[j]);
                }
                return ans.toArray(new int[ans.size()][]);
            }
        }
    }
}
