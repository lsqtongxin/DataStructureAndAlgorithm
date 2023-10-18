// 1. 递归调用，导致大量的重叠子问题
class Solution {
    public int integerBreak(int n) {
        return breakInteger(n);
    }
    private int breakInteger(int n){
        if(n==1)return 1;    
        // i*(n-i)
        int res = -1;
        for(int i=1;i<n;i++){
            res = Math.max(res,Math.max(i*(n-i),i*breakInteger(n-i)));
        }
        return res;
    }
}

// 2. 记忆化搜索
class Solution {
    int[] memo;
    public int integerBreak(int n) {
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        return breakInteger(n);
    }
    private int breakInteger(int n){
        if(n==1)return 1;    
        // i*(n-i)
        if(memo[n]!=-1){
            return memo[n];
        }
        int res = -1;
        for(int i=1;i<n;i++){
	    // res , i*(n-i) , i*breakInteger(n-i) 分为三部分，取三部分的最大值  
            res = Math.max(res,Math.max(i*(n-i),i*breakInteger(n-i)));
        }
        memo[n]=res;
        return res;
    }
}

// 3. 动态规划
class Solution {
    public int integerBreak(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        memo[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                memo[i] = Math.max(memo[i],Math.max(j*(i-j),j*memo[i-j]));
            }
        }
        return memo[n];
    }
}
