// 70题和509题是同一道题
class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n== 1)return 1;
        int a = 1;
        int b = 1;
        for(int i=2;i<=n;i++){
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }
}
