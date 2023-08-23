

// 这是将s1字符串进行遍历，然后通过s2的contains进行判断
// 这是稍微笨一点的方法，在本地的电脑上能跑出来
// 而LeetCode显示超时，所以这种方法不是最好的方法。
class Solution {
    ArrayList<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean[] visited;
    public boolean checkInclusion(String s1, String s2) {
        visited = new boolean[s1.length()];
        backtrack(s1);
        for(int i=0;i<res.size();i++){
            if(s2.contains(res.get(i))){
                return true;
            }
        }
        return false;
    }
    void backtrack(String s1){
        if(sb.toString().length() == s1.length()){
            res.add(new StringBuilder(sb).toString());
            return;
        }
        for(int i=0;i<s1.length();i++){
            if(visited[i])continue;
            if(i>0 && s1.charAt(i)==s1.charAt(i-1) && !visited[i-1])continue;
            visited[i]=true;
            sb.append(s1.charAt(i));
            backtrack(s1);
            visited[i]=false;
            sb.delete(sb.length()-1,sb.length());
        }
    }
}
