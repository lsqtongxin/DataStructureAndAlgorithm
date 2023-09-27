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