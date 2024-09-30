// 1. 暴力方法
//    双for循环，时间复杂度在O(n2)
//    能通过 47 / 48 个通过的测试用例，最后一个测试用例无法通过
//    因为数组太长，超出时间限制
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            for(int j=i+1;j<temperatures.length;j++){
                if(temperatures[j]>temperatures[i]){
                    res[i] = j - i ;
                    break;
                }
            }
        }
        return res;
    }
}
// 2. 使用单调栈进行求解,逆序的单调栈
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int preInd = stack.pop();
                ans[preInd] = i - preInd;
            }
            stack.push(i);
        }
        return ans;
    }
}
