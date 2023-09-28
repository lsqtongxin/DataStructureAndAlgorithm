// 1. map和set
class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] pArr = pattern.toCharArray();
        String[] sArr = s.split("\\s+");
        if(pArr.length!=sArr.length)return false;
        Map<Character,String> m = new HashMap<>();
        Set<String> sSet = new HashSet<>();
        for(int i=0;i<pArr.length;i++){
            if(!m.containsKey(pArr[i]) && !sSet.contains(sArr[i])){
                m.put(pArr[i],sArr[i]);
                sSet.add(sArr[i]);
            }else{
                if(!m.containsKey(pArr[i]))return false;
                else if(!m.get(pArr[i]).equals(sArr[i]))return false;

            }
        }
        return true;
    }
}
// 2. map,只用map,这里是Java特有的利用JavaApi来进行解决
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split("\\s+");
        if(pattern.length()!=sArr.length)return false;
        Map<Character,String> m = new HashMap<>();
        for(int i=0;i<sArr.length;i++){
            char temp = pattern.charAt(i);
            if(!m.containsKey(temp)){
                if(m.containsValue(sArr[i]))return false;
                m.put(temp,sArr[i]);
            }else{
                if(!m.get(temp).equals(sArr[i]))return false;
            }
        }
        return true;
    }
}

// 3. 使用两个map
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> charToStr = new HashMap<Character,String>();
        HashMap<String,Character> strToChar = new HashMap<String,Character>();
        int pLen = pattern.length();
        String[] sArr = s.split("\\s+");
        int sLen = sArr.length;
        if(pLen!=sLen)return false;
        for(int i=0;i<pLen;i++){
            char temp = pattern.charAt(i);
            if(!charToStr.containsKey(temp)){
                if(strToChar.containsKey(sArr[i]))return false;
                charToStr.put(temp,sArr[i]);
                strToChar.put(sArr[i],temp);
            }else{
                if(!charToStr.get(temp).equals(sArr[i]))return false;
            }
        }
        return true;
    }
}
