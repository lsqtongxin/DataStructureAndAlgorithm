//  这题和438、30是一样的

// 1.
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

// 2. 滑动窗口，长度固定的滑动窗口
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        Map<Character,Integer> s1Fre = new HashMap<>();
        for(int i=0;i<s1Len;i++){
            char c = s1.charAt(i);
            s1Fre.put(c,s1Fre.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> window = new HashMap<>();
        int start = 0,cur = 0;
        while(cur < s2Len){
            char cc = s2.charAt(cur);
            window.put(cc,window.getOrDefault(cc,0)+1);
            cur++;
            while(cur-start>s1Len){
                char cs = s2.charAt(start);
                if(window.get(cs)==1){
		    // 因为当某个字符的频率为0时候，此时window和s1Fre进行判断就会出错，必须删除这个Entry
                    window.remove(cs);
                }else {
                    window.put(cs,window.get(cs)-1);
                }
                start++;
            }
            if(window.equals(s1Fre))return true;
        }
        return false;
    }
}

// 3. 滑动窗口，通过数组存储词频信息(模拟HashMap的使用),长度固定的滑动窗口
//    学习了 Arrays.equals()方法，能判断数组相等。
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1>len2)return false;
        int[] sArr1 = new int[26];
        int[] sArr2 = new int[26];
        for(int i=0;i<len1;i++){
            sArr1[s1.charAt(i)-'a']++;
            sArr2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(sArr1,sArr2))return true;
        for(int i=len1;i<len2;i++){
            sArr2[s2.charAt(i)-'a']++;
            sArr2[s2.charAt(i-len1)-'a']--;
            if(Arrays.equals(sArr1,sArr2))return true;
        }
        return false;
    }
}
