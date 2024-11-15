//
// 1. 滑动窗口 + Set
//    通过Set保存当前滑动窗口的字符，每向前走一步，判断这个新的字符是否在滑动窗口中的Set中，
//    当滑动窗口中存在重复字符，则进行缩小窗口，即删除最左侧的字符，再看是否重复
//    直到不重复
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int sLen = s.length();
        if(sLen==1)return sLen;
        int res = 0;
        int start = 0,cur = 0;
        Set<Character> sc = new HashSet<>();
        while(cur<sLen){
            char c = s.charAt(cur);
            cur++;
            if(!sc.contains(c)){
                sc.add(c);
                res = sc.size()>res?sc.size():res;
            }else{ 
                // 如有重复,则进行滑动窗口缩小
                while(sc.contains(c)){
                    sc.remove(s.charAt(start));
                    start++;
                }
                sc.add(c);
                res = sc.size()>res?sc.size():res;
            }

        }
        return res;
    }
}
// 2. 同上，原理相同，只是进行简化上述代码结构而已
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int sLen = s.length();
        if(sLen==1)return sLen;
        int res = 0;
        int start = 0,cur = 0;
        Set<Character> sc = new HashSet<>();
        while(cur<sLen){
            char c = s.charAt(cur);
            cur++;
            // 如有重复,则进行滑动窗口缩小
            while(sc.contains(c)){
                sc.remove(s.charAt(start));
                start++;
            }
            sc.add(c);
            res = sc.size()>res?sc.size():res;
        }
        return res;
    }
}
