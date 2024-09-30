// 1. 利用栈去暂存 第一个值和第二个值以及中间的结果值
class Solution {
    public int evalRPN(String[] tokens) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") 
                || tokens[i].equals("-") 
                || tokens[i].equals("*") 
                || tokens[i].equals("/")){
                if(stack.isEmpty())return ans;
                int i1 = stack.pop();
                int i2 = stack.pop();
                if(tokens[i].equals("+")){
                    stack.push(i1+i2);
                }else if(tokens[i].equals("-")){
                    stack.push(i2-i1);
                }else if(tokens[i].equals("*")){
                    stack.push(i1*i2);
                }else {
                    stack.push(i2/i1);
                }        
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}

// 2.

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int x=0;x<tokens.length;x++){
            if(tokens[x].equals("+")){
                int i = stack.pop();
                int j = stack.pop();
                stack.push(i+j);
            }else if(tokens[x].equals("-")){
                int i = stack.pop();
                int j = stack.pop();
                stack.push(j-i);

            }else if(tokens[x].equals("*")){
                int i = stack.pop();
                int j = stack.pop();
                stack.push(i*j);

            }else if(tokens[x].equals("/")){
                int i = stack.pop();
                int j = stack.pop();
                stack.push(j/i);
            }else {
                stack.push(Integer.parseInt(tokens[x]));
            }
        }
        return stack.pop();
    }
}
