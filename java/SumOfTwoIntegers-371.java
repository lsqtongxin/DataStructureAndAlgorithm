// 通过位运算实现加法
class Solution {
    public int getSum(int a, int b) {
        if(b == 0) return a;
        int carry = (a & b) << 1;
        int sum = a ^ b;
        return getSum(sum, carry);
    }
}

// 与题意不符
class Solution {
    public int getSum(int a, int b) {
        return a+b;
    }
}