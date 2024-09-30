// 注意几个点：
//     一、奇数肯定是不匹配
//     二、在pop的时候，一定要先看栈是否为空
//     三、最终的栈一定为空才是正确匹配的情况
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2==1)return false;
        char[] sArr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>(); 
        for(int i=0;i<sArr.length;i++){
            if(sArr[i]=='(' || sArr[i]=='[' || sArr[i]=='{'){
                stack.push(sArr[i]);
            }else {
                if(stack.isEmpty())return false;
                if(sArr[i]==')'){
                    char tmp = stack.pop();
                    if(tmp!='(')return false;
                }else if(sArr[i]=='}'){
                    char tmp = stack.pop();
                    if(tmp!='{')return false;
                }else {
                    char tmp = stack.pop();
                    if(tmp!='[')return false;
                }
            }
        }
        if(!stack.isEmpty())return false;
        return true;
    }
}
