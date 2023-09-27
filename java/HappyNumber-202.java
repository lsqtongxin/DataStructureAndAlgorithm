// 这题的关键是在于如何判断是否有循环
// 也就是说 每计算一个 非愉快的数字，要加入到set中，当计算出一个新的数字要判断是否在set中
// 如果在set中，则认为是形成循环了，否则继续向下进行试探。
class Solution {
    public boolean isHappy(int n) {
        int happy = n;
        Set<Integer> set = new HashSet<>();
        while(happy!=1){
            set.add(happy);
            int[] res = split(happy);
            happy =0;
            for(int i=0;i<res.length;i++){
                happy= happy + res[i]*res[i];
            }
            if(set.contains(happy))return false;
        }
        if(happy==1)return true;
        return false;
    }
    int[] split(int n){
        int unit = (int)Math.log10(n)+1;
        int[] res = new int[unit];
        int i = 0;
        while(n>0){
            res[i]= n%10;
            n = n/10;
            i++;
        }
        return res;
    }
}