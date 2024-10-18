// 这个题是 leetcode自己出的面试题
// 面试题10.01.合并排序的数组
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        if(n==0)return;
        int length = m + n;
        int cur = length - 1;
        int curA= m-1;
        int curB= n-1;
        while(curA>=0 && curB>=0){
            if(A[curA]<B[curB]){
                A[cur] = B[curB];
                curB--;
                cur--;
            }else{ // A[curA]>=B[curB]
                A[cur] = A[curA];
                curA--;
                cur--;
            }
        }
        if(curA<0 && curB>=0){
            while(cur>=0){
                A[cur] = B[curB];
                cur--;
                curB--;
            }
        }
    }
}
