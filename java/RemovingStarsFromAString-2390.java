// 1. 使用Deque来模拟栈操作
class Solution {
    public String removeStars(String s) {
        char[] sArr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<sArr.length;i++){
            if(sArr[i]!='*'){
                stack.push(sArr[i]);
            }else {
                stack.pop();
            }
        }
        if(stack.size()==0)return "";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            char temp = stack.pop();
            sb.insert(0,temp);
        }
        return sb.toString();
    }
}
// 2. 使用ArrayList来模拟栈操作
class Solution {
    public String removeStars(String s) {
        char[] sArr = s.toCharArray();
        List<Character> stack = new ArrayList<>();
        for(int i=0;i<sArr.length;i++){
            if(sArr[i]!='*'){
                stack.add(sArr[i]);
            }else {
                stack.remove(stack.size()-1);
            }
        }
        if(stack.size()==0)return "";
        StringBuilder sb = new StringBuilder();
	// 这里注意 forEach 的使用
        stack.forEach(c -> sb.append(c));
        return sb.toString();
    }
}
