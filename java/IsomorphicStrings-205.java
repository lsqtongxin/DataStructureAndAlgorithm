// 1. map和set配合
//  x -> y 是一一映射的
// map对x进行去重，set对y进行去重
// 保证的是一一对应
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Character> m = new HashMap<>();
        Set<Character> ss = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char tempS = s.charAt(i);
            char tempT = t.charAt(i);
            if(m.containsKey(tempS)){
                if(!m.get(tempS).equals(tempT))return false;
            }else{
                if(ss.contains(tempT))return false;
                m.put(tempS,tempT);
                ss.add(tempT);
            }
        }
        return true;
    }
}
// 2. map
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Character> m = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char tempS = s.charAt(i);
            char tempT = t.charAt(i);
            if(m.containsKey(tempS)){
                if(!m.get(tempS).equals(tempT))return false;
            }else{
                if(m.containsValue(tempT))return false;
                m.put(tempS,tempT);
            }
        }
        return true;
    }
}
