// 1. 这下面的是错误答案，但也能通过 95/214个测试用例
//    思维: 现在数组中找到一笔的最大值，类似于121题
//          不仅仅记下最大值，也把卖出的时间也就是索引记录下来
//          然后利用贪心思想，在上一笔卖出的时间后再买一笔,从[index+1,length-1]这段区域再买一笔最大的值
//          也就是 利用两次121题的思考方式来进行解决这个题
//          结论是这样思考没有全局进行选择，只是局部
class Solution {
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        int minValue = prices[0];
        int index = -1;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>minValue){
                int temp = prices[i]-minValue;
                maxPro = maxPro>temp?maxPro:temp;
                index = i;
            }else{
                minValue = prices[i];
            }
        }
        int second = maxSecond(prices,index+1,prices.length-1);
        return second + maxPro;
    }
    public int maxSecond(int[] prices,int l,int r){
        int maxPro = 0;
        if(l>=r)return maxPro;
        int minValue = prices[l];
        for(int i=l+1;i<=r;i++){
            if(prices[i]>minValue){
                int temp = prices[i] - minValue;
                maxPro = maxPro>temp?maxPro:temp;
            }else{
                minValue = prices[i];  
            }
        }
        return maxPro;
    }
}
