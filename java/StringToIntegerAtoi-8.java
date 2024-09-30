// 1. 这个题太恶心了，光一个一个测试用例去改bug就耗费了一个小时
//    测试用例太多了，一共1094个测试用例
//    让我奇怪的是"  + 42" 这种的正确答案是0,而不是42
//    words and 987  这种的正确答案是0,而不是987
//    +-12  这种的正确答案是0,而不是-12
//    还要对32位有符号数进行范围判断
//    

class Solution {
    public int myAtoi(String s) {
        if(s.length()==0)return 0;
        char[] cArr = s.toCharArray();
        // 标记已经取到了数字
        boolean flag = false;
        // 标记正负
        int sign = 1;
        // 结果
        int ans = 0;
        for(int i=0;i<cArr.length;i++){
            // 遇到空格，继续
            if(!flag && cArr[i]==' '){
                if(i>0 && cArr[i-1]!=' '){
                    return ans;
                }
                continue;
            };
            // 遇到加号，继续
            if(!flag && cArr[i]=='+'){
                if(i>0 && cArr[i-1]!=' '){
                    return ans;
                }else {
                    continue;
                }
            };
            // 遇到减号，变更为负
            if(!flag && cArr[i]=='-'){
                if(i>0 && cArr[i-1]!=' '){
                    return ans;
                }
                sign = -1;
                continue;
            }
            // 但是字符，直接返回
            if(cArr[i]<'0' || cArr[i]>'9'){
                return ans;
            }

            // 已遇到数字的标记
            if(cArr[i]>='0'&&cArr[i]<='9')flag=true;

            // 判断当前的ans乘以10加上当前字符的值是否超范围
            if(ans > Integer.MAX_VALUE/10){
                return Integer.MAX_VALUE;
            }else if(ans == Integer.MAX_VALUE/10 && (cArr[i]-'0')> Integer.MAX_VALUE%10){
                return Integer.MAX_VALUE;
            }else if(ans<Integer.MIN_VALUE/10){
                return Integer.MIN_VALUE;
            }else if(ans == Integer.MIN_VALUE/10 && (cArr[i]-'0')> (Integer.MIN_VALUE%10)*(-1)){
                return Integer.MIN_VALUE;
            }
            ans = ans*10+ sign*(cArr[i]-'0');
        }
        return ans;
    }
}
