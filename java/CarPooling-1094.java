// 此题注意点：
//  1. [[2,1,5],[3,5,7]] 3  正确的应该是可以，注意从1到5，从5到7, 第一阶段的2人已经下车，第二阶段的3人才上车
//     那么乘客所占时间是[1,5) 是左闭右开的状态，而不是左闭右闭的情况，这样下一波人[5,7)同样可以上车
//     所以 [1,5) 也就是 [1,4] 所以下面add那一行会减去1
//  2. 注意车站是从0开始计数，所以无需减1，跟1109的航班不一样(它是从1开始计数的)
//  3. 此题不知道最大的站点是什么数字，所以需要遍历一遍求一下，又因为是从0开始的站点，所以需要max+=1  
//     而1109的航班题目已经给定了有多少个航班，此题没有给定多少站点。
//  4. [[9,0,1],[3,3,7]] 4 注意一开始就是9个人上车，而容量是4，无法承受，所以可以减枝，直接返回false
class Solution {
    int[] diff;
    public boolean carPooling(int[][] trips, int capacity) {
        int max = trips[0][2];
        for(int i=1;i<trips.length;i++){
            if(max<trips[i][2])max=trips[i][2];
        }
        max+=1;
        diff = new int[max];
        for(int i=0;i<trips.length;i++){
            if(trips[i][0]>capacity)return false;
            add(trips[i][0],trips[i][1],trips[i][2]-1);
        }
        int[] res = new int[max];
        res[0]=diff[0];
        for(int i=1;i<max;i++){
            res[i] = diff[i] + res[i-1];
            if(res[i]>capacity)return false;
        }
        return true;
    }
    private void add(int k,int l,int r){
        diff[l]+=k;
        if(r+1 < diff.length){
            diff[r+1]-=k;
        }
    }
}
