// 1. 原来的题解
class Solution {
    public String minWindow(String s, String t) {
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    for (char c : t.toCharArray()) 
        need.put(c, need.getOrDefault(c, 0) + 1);

    int left = 0, right = 0;
    int valid = 0;
    int start = 0, len = Integer.MAX_VALUE;
    while (right < s.length()) {
        char c = s.charAt(right);
        right++;
        if (need.containsKey(c)) {
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).equals(need.get(c)))
                valid++;
        }
        while (valid == need.size()) {
            if (right - left < len) {
                start = left;
                len = right - left;
            }
            char d = s.charAt(left);
            left++;
            if (need.containsKey(d)) {
                if (window.get(d).equals(need.get(d)))
                    valid--;
                window.put(d, window.get(d) - 1);
            }
        }
    }
    return len == Integer.MAX_VALUE ?
        "" : s.substring(start, start + len);
    }
}


// 2. 2024年11月15日题解
//    我一直以为只是求t在s中的最短的字符串，也就是说t字符词频和s中某个字符串的词频一样，且s的这个字符串最短即可完成任务

//    当我看到了这个测试用例，发现之前的理解有错误
//    s = "aaaaaaaaaaaabbbbbcdd"
//    t = "abcdd"
//    预期结果居然是 "abbbbbcdd"
//    而我当前程序给出的答案是""

//    分为几种情况：
//	1. 如果是在s中找t的异位串,类似题目438或567,那么就可以使用 固定的滑动窗口 + 统计词频的方法进行
//      2. 如果是在s中找t的异位串且每个字符可以不连续,词频相同，求最小的字符串
//      3. 如果是在s中找t的异位串且每个字符可以不连续,词频可以不同，只是包含即可，求最小字符串是什么
//         这种情况就是 这个测试用例所表达的意思。

//我一直按照第二种情况进行理解题意，并编写代码的，但是只通过了194/268个测试用例，
//针对第二种情况：我的代码如下：
//    什么时候缩小窗口呢？
//    当cur前进到某个字符，且字符属于t字符串中存在的字符，且滑动窗口的词频大于等于t字符串的这个字符的词频
//    缩小到这个滑动窗口的词频小于t字符串这个字符的词频 
//    然后将其加入到滑动窗口中。
//    s="ADOBECODEBANC" t="ABC" 
//    此时窗口为[ECODEB]
//    有因为E不属于t字符串字符，所以窗口的start可以继续移动
//    为 [CODEB]
//    最后继续即可
class Solution {
    public String minWindow(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        String resStr = "";
        if(tLen==0 || sLen==0 || sLen < tLen)return resStr;
        int[] fre = new int[58];
        for(int i=0;i<tLen;i++){
            fre[t.charAt(i)-'A']++;
        }
        int start = 0,cur = 0;
        int[] window = new int[58];
        while(cur<sLen){
            char c = s.charAt(cur);
            cur++;
            if(fre[c-'A']==0)continue;
            //该缩小窗口了
            while(start<cur && fre[c-'A'] <= window[c-'A']){
                char cc = s.charAt(start);
                if(fre[cc-'A']!=0){
                    window[cc-'A']--;
                }
                start++;    
            }
            // 去除无用的多余字符串
            while( start< cur && fre[s.charAt(start)-'A']==0)start++;
            window[c-'A']++;
            if(!Arrays.equals(window,fre))continue;
            String temp = s.substring(start,cur);
            if(resStr.length()==0){
                resStr = temp;
            }else{
                resStr = temp.length()<resStr.length()?temp:resStr;
            }
        }
        return resStr;        
    }
}



// 3. 
//    我们来处理上述的第三种情况:
//      如果是在s中找t的异位串且每个字符可以不连续,词频可以不同，只是包含即可，求最小字符串是什么
//      其中最小字符串的词频可以大于等于t的字符串的词频。
//      对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量
//      所以无法直接比较两个字符串的词频是否相等了,即无法使用Arrays.equals(xxx,yyy)
//      所以需要自己建设一个 isEqual(int[] a,int[] b)来比较 被找到的字符串 和 t字符串 是否匹配
//      依次比较两个数组的各个数字，如果所有数字都是 a[i]>=b[i]则匹配
//      否则就是不匹配

//    咱们处理这个测试用例
//    s = "aaaaaaaaaaaabbbbbcdd"
//    t = "abcdd"
//    预期结果居然是 "abbbbbcdd"
//    而我当前程序给出的答案是""
class Solution {
    public String minWindow(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        String resStr = "";
        if(tLen==0 || sLen==0 || sLen < tLen)return resStr;
        int[] fre = new int[58];
        for(int i=0;i<tLen;i++){
            fre[t.charAt(i)-'A']++;
        }
        int start = 0,cur = 0;
        int[] window = new int[58];
        while(cur<sLen){
            char c = s.charAt(cur);
            cur++;
            // 不是t中的字符则继续，否则进行加一
            if(fre[c-'A']==0)continue;
            else window[c-'A']++; 
            // 不满足，则继续 
            if(!isEqual(window,fre))continue;

            // 满足题意，该缩小窗口了，找最小长度
            while(start<cur && isEqual(window,fre)){
                char cc = s.charAt(start);
                if(fre[cc-'A']!=0){
                    window[cc-'A']--;
                }
                start++;    
            }
            // 将最小长度字符串进行比较，并保存起来
            String temp = s.substring(start-1,cur);
            if(resStr.length()==0){
                resStr = temp;
            }else{
                resStr = temp.length()<resStr.length()?temp:resStr;
            }
        }
        return resStr;        
    }
    // a: founded str
    // b: t str
    private boolean isEqual(int[] a,int[] b){
        int len = a.length;
        for(int i=0;i<len;i++){
            if(a[i]<b[i])return false;
            else continue;
        }
        return true;
    }
}
