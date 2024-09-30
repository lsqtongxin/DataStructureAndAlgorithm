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

// 
class Solution {
    public int climbStairs(int n) {
        int a=1,b=2;
        if(n==1)return a;
        if(n==2)return b;
        for(int i=3;i<=n;i++){
            int temp = a+b;
            a = b;
            b = temp;
        }
        return b;
    }
}
