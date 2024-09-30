//1. 贪心，只要让我挣就行，我不管全局
class Solution {
    public int maxProfit(int[] prices) {
        // 这个题其实没有限定，同一天是否可以先卖后买
        // 但通过常识来看， 同一天的先卖后买 其实 就是 没卖没买，因为成本一样
        // 那么我们怎么解决呢？
        // 我们将区间细化为买和卖只是区间差为1 即i,i+1
        int maxPro = 0;
        for(int i=0;i+1<prices.length;i++){
            if(prices[i+1]>prices[i]){
                maxPro += (prices[i+1]-prices[i]);
            }
            // prices[i+1]<=prices[i]则不卖，赔钱不符合贪心，
            // 因为有限制，所以更不能买
        }
        return maxPro;
    }
}

//2. 动态规划

