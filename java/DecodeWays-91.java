class Solution {
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return decodeWays(s,0);
    }
    private int decodeWays(String s,int index){
	// 终止条件是重点，应该返回1，而不是0
        if(index>=s.length())return 1;
	// 前导是0的是无效的，返回0
        if(s.charAt(index)=='0')return 0;
        // 除去0，剩下是1-9,返回1
        if(index==s.length()-1){
            return 1;
        }
        if(memo[index]!=-1){
            return memo[index];
        }
        int result = decodeWays(s,index+1);
        if(index+1<s.length() && (s.charAt(index)-'0')*10 + (s.charAt(index+1)-'0')<27){
            result += decodeWays(s,index+2);
        }
        memo[index]=result;
        return result;
    }
}
