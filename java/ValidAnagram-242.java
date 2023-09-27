// 这个题其实就是求字符和词频

// 1. 使用HashMap来存储字符及频率
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Integer> sMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++){
            if(!sMap.containsKey(t.charAt(i)))return false;
            int freq = sMap.get(t.charAt(i));
            if(freq==1){
                sMap.remove(t.charAt(i));
            }else{
                sMap.put(t.charAt(i),freq-1);
            }
        }
        return true;
    }
}

// 2. 使用数组来作为一种map，来实现词频的增加和减小
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}