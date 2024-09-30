//1.  暴力求解，双for求解
//    简单粗暴，但是有的测试用例无法通过
//    只能通过202/212个通过的测试用例
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n= prices.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int temp = prices[j]-prices[i];
                if(temp>ans)ans=temp;
            }
        }
        return ans;
    }
}

//2. 一次遍历
//   i 为卖出股票的那一天，依次遍历，同时保存走过来的区域[0,i)的最小值
//   如果 prices[i] > minValue ,则求一下差价，并与maxPro比较一下
//   如果 prices[i] <= minValue,则更新minValue值
//   [0,     i)     ,n-1] 整体分为了[0,i)已走过  和 [i,n-1]为继续要探索的区域
//   这是两个不同的区域
class Solution {
    public int maxProfit(int[] prices) {
        // 股票净利润
        int maxPro = 0;
        // [0,i)区域的最小值
        int minValue = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>minValue){
                int temp = prices[i] - minValue;
                maxPro = maxPro>temp?maxPro:temp;
            }else {
                minValue= prices[i];
            }
        }
        return maxPro;
    }
}
