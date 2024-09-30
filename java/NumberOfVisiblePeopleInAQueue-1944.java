//1. 暴力求解
//   较长的数组的测试用例无法通过
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] ans = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            int num = 0;
            for(int j=i+1;j<heights.length;j++){
                if(j==i+1)num++;
                int tempMin = heights[i]>heights[j]?heights[j]:heights[i];
                if(tempMin>achiveMax(heights,i+1,j-1)){
                    num++;
                }
            }
            ans[i]=num;
        }
        return ans;
    }
    public int achiveMax(int[] heights,int l,int r){
        int maxTemp = heights[l];
        for(int i=l+1;i<=r;i++){
            if(heights[i]>maxTemp){
                maxTemp = heights[i];
            }
        }
        return maxTemp;
    }
}
