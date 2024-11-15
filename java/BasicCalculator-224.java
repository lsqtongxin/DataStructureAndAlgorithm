// 1.
class Solution {
    public int calculate(String s) {
        Deque<Integer> operands = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        String ss = s.replaceAll("\\s","");
    char[] ch = ss.toCharArray();

    for(int i = 0; i < ch.length; i++) {
        char c = ch[i];
        if(Character.isDigit(c)){
            //operands can be one or more digits long
            int num = 0;
            while (i < ch.length && Character.isDigit(ch[i])) {
                num = num * 10 + (ch[i] - '0');
                i++;
            }
            i--;
            operands.push(num);
        }
        else if( c == '('){
            operators.push(c);
        }
        else if(c == ')') {
            // calculate the whole expression surrounded by the closing and corresponding braces
            while(operators.peek() != '('){
                int ans = calculate2(operands, operators);
                operands.push(ans);
            }
            operators.pop();
        }
        else if(isOperator(c)){
            if(c=='-' && i>0 && ch[i-1]=='('){
                operands.push(0);
            }
            while(!operators.isEmpty() && precedence(c) <= precedence(operators.peek())){
                int ans = calculate2(operands, operators);
                operands.push(ans);
            }
            operators.push(c);
        }
    }
    while(!operators.isEmpty()){
        int ans = calculate2(operands, operators);
        operands.push(ans);
    }
    return operands.pop();
        
    }
    private boolean isOperator(char c) {
    return (c=='+'||c=='-'||c=='/'||c=='*'||c=='^');
}

private int precedence(char c) {
    switch (c){
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
    }
    return -1;
}

private int calculate2(Deque<Integer> operands, Deque<Character> operators) {
    if(operands.size()==0 || operators.size()==0)return 0;
    int a = 0,b=0;
    if(operands.size()<2){
        a = operands.pop();
    }else {
        a = operands.pop();
        b = operands.pop();
    }
    char operator = operators.pop();

    switch (operator) {
        case '+':
            return a + b;
        case '-':
            return b - a; // not a - b since evaluation is done from left to right.
        case '*':
            return a * b;
        case '^':
            return  (int) Math.pow(b, a);
        case '/':
            return b / a; // not a / b since evaluation is done from left to right.
    }
    return 0;
}
}


//2. 
class Solution {
    public int calculate(String s) {
        String ss = s.replaceAll("\\s","");
        if(ss.length()==0)return 0;
        Deque<Integer> operand = new ArrayDeque<>();
        Deque<Character> operator = new ArrayDeque<>();
        int length = ss.length();
        char[] ssArr = ss.toCharArray();
        for(int i=0;i<length;i++){
            if(ssArr[i]>='0' && ssArr[i]<='9'){
                int num = 0;
                while(i<length && ssArr[i]>='0' && ssArr[i]<='9'){
                    num = num * 10 + (ssArr[i]-'0');
                    i++;
                }
                i--;
                operand.push(num);
            }else if(ssArr[i]=='('){
                operator.push(ssArr[i]);
            }else if(ssArr[i]==')'){
                while(operator.peek()!='('){
                    int temp = calculateValue(operand,operator);
                    operand.push(temp);
                }
                // 把 ( 弹出
                operator.pop();
            }else if(ssArr[i]=='+' ||
                    ssArr[i]=='-'){
                if(i>0 && ssArr[i-1]=='('){
                    operand.push(0);
                }
                if(i==0){
                    operand.push(0);
                }
                while(!operator.isEmpty() && precedence(ssArr[i]) <= precedence(operator.peek())){
                    int temp = calculateValue(operand,operator);
                    operand.push(temp);
                }
                operator.push(ssArr[i]);
            }
        }
        if(!operator.isEmpty()){
            while(!operator.isEmpty()){
                int temp = calculateValue(operand,operator);
                operand.push(temp);
            }
        }
        return operand.pop();
    }
    public int calculateValue(Deque<Integer> operand,Deque<Character> operator){
        int temp1 = operand.pop();
        int temp2 = operand.pop();
        char op = operator.pop();
        switch(op){
            case '+':
                return temp1+temp2;
            case '-':
                return temp2-temp1;
        }
        return 0;
    }
    private int precedence(char c) {
    switch (c){
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
    }
    return -1;
    }
}
