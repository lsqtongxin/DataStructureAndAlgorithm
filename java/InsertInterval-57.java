// 1. 这个实现比较简单，是采用了和56一样的套路
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            int[][] ans = new int[1][2];
            ans[0]= newInterval;
            return ans;
        }
        int length = intervals.length;
        List<int[]> ans = new ArrayList<>();
        // insertPosition 即 ip
        // 寻找插入点
        int ip = 0;
        for(;ip<length;ip++){
            if(intervals[ip][1]<newInterval[0]){
                continue;
            }else{
                break;
            }
        }
        // 将插入点前面部分添加到结果集
        for(int i=0;i<ip;i++){
            ans.add(intervals[i]);
        }

        // 然后将插入点和插入点之后的源值加入到src中
        List<int[]> src = new ArrayList<>();
        for(int i=ip;i<length;i++){
            src.add(intervals[i]);
        }
        // 把新增区间也加入到src中
        src.add(newInterval);
        // 对src进行排序操作，按照每个数组的首部进行排序
        Collections.sort(src,new Comparator<int[]>(){
                public int compare(int[] arr1,int[] arr2){
                    return arr1[0]-arr2[0];
                }
            }
        );
        // 后续与56题一样，进行合并插入即可
        for(int i=0;i<src.size();i++){
            if(ans.isEmpty()){
                ans.add(src.get(i));
            }else {
                int[] tempAns = ans.get(ans.size()-1);
                int[] tempSrc = src.get(i);
                if(tempAns[1]< tempSrc[0]){
                    ans.add(tempSrc);
                }else{ // tempAns[1]>=tempSrc[0]
                    tempAns[1] = Math.max(tempAns[1],tempSrc[1]);
                    ans.remove(ans.size()-1);
                    ans.add(tempAns);
                }

            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
// 2. 这个有点复杂
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
