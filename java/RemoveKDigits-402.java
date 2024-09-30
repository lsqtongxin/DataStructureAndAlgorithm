//1.
class Solution {
    public String removeKdigits(String num, int k) {
        if(k>=num.length())return "0";
        Deque<Character> stack = new ArrayDeque<>();
        char[] numArr = num.toCharArray();
        for(int i=0;i<numArr.length;i++){
            while(!stack.isEmpty() && k>0 && numArr[i]<stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(numArr[i]);
        }
        // 放置出现 num=”112“ k=1 这种情况
        if(k!=0){
            while(k>0){
                stack.pop();
                k--;
            }
        }
        // 将栈中的所有字符取出来并组成字符串
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            char tmp = stack.pop();
            sb.insert(0,tmp);
        }
        // 剔除前导0
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}

//2.
class Solution {
    public String removeKdigits(String num, int k) {
        if(k==0)return num;
        int length = num.length();
        if(k>=length)return "0";
        Deque<Integer> stack = new ArrayDeque<>();
        char[] numArr = num.toCharArray();
        int i=0;
        for(;i<length;i++){
            while(!stack.isEmpty() && k>0 && numArr[i]< numArr[stack.peek()]){
                stack.pop();
                k--;
            }
            stack.push(i);
        }
        while(k>0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(numArr[stack.pop()]);
        }
        sb.reverse();
        int j=0;
        while(j<sb.length() && sb.charAt(j)=='0'){
            j++;
        }
        if(j==sb.length()){
            return "0";
        }
        return sb.substring(j);
    }
}

