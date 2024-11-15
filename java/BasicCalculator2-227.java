class Solution {
    public int calculate(String s) {
        if(s.length()==0)return 0;
        char[] sArr = s.toCharArray();
        Deque<Integer> operands = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        for(int i=0;i<sArr.length;i++){
            if(sArr[i]==' ')continue;
            if(sArr[i]>=48 && sArr[i]<=57){
                int num =0;
                while(i<sArr.length && sArr[i]>=48 && sArr[i]<=57){
                    num = num*10+(sArr[i]-48);
                    i++;
                }
                // 此时sArr[i]不是数字，而for有一个i++，此时先减去1，否则会漏掉一个字符
                i--;
                operands.push(num);
            }else if(sArr[i]=='('){
                operators.push(sArr[i]);
            }else if(sArr[i]==')'){
		// 当遇到最终的括号时候，按正常逻辑应该计算括号内的数值
		// 
                while(!operators.isEmpty() && operators.peek()!='('){
                    int ans = cal(operands,operators);
                    operands.push(ans);
                }
                // 把 '(' 最终弹出来
                operators.pop();
            }else if(sArr[i]=='+' || sArr[i]=='-'||sArr[i]=='*'||sArr[i]=='/'){
                if(operators.isEmpty()){
                    operators.push(sArr[i]);
                }
                else if(level(operators.peek()) <  level(sArr[i])){
                    operators.push(sArr[i]);
                }else { // >= 
                    while(!operators.isEmpty() && level(operators.peek()) >=  level(sArr[i])){
                        int ans = cal(operands,operators);
                        operands.push(ans);
                    }  
                    operators.push(sArr[i]);                    
                }
            }
        }
        while(!operators.isEmpty()){
            int ans = cal(operands, operators);
            operands.push(ans);
        }
        return operands.pop();
    }
    // 判断 +-*/()的算术优先级
    // 注意括号()的优先级为0,而不是最高
    // (4*3+2)
    // 如果括号优先级最高，则当遇到*后，进行弹出4和(这样没有任何意义
    private int level(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }
    // 进行实际的单步计算
    private int cal(Deque<Integer> operands ,Deque<Character> operators){
        int temp1 = operands.pop();
        int temp2 = operands.pop();
        char op = operators.pop();
        switch(op){
            case '+':
                return temp1+temp2;
            case '-':
                return temp2-temp1;
            case '*':
                return temp1*temp2;
            case '/':
		// 这里应该有对除0的检测
                return temp2/temp1;
        }
        return 0;
    }
}
