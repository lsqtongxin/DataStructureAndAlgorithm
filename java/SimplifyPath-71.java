// 栈
class Solution {
    public String simplifyPath(String path) {
        String[] sArr = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(int i=0;i<sArr.length;i++){
            if(sArr[i].equals("") || sArr[i].equals("."))continue;
            if(sArr[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }
            stack.push(sArr[i]);
        }
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty())return "/";
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
            sb.insert(0,"/");
        }
        return sb.toString();
    }
}

// 
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] sArr = path.split("/");
        for(int i=0;i<sArr.length;i++){
            if(sArr[i].isEmpty() || sArr[i].equals("."))continue;
            if(sArr[i].equals("..")){
                if(!stack.isEmpty())stack.pop();
                continue;
            }
            stack.push(sArr[i]);
        }
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty())return "/";
        while(!stack.isEmpty()){
            String tmp = stack.pop();
            sb.insert(0,tmp);
            sb.insert(0,"/");
        }
        return sb.toString();
    }
}
