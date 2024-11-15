//
// 1. 统计词频，超时了
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        char[] pArr = p.toCharArray();
        Map<Character,Integer> pMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<pLen;i++){
            pMap.put(pArr[i],pMap.getOrDefault(pArr[i],0)+1);
        }
        for(int i=0;i<s.length()-pLen+1;i++){
            String tempStr = s.substring(i,i+pLen);
            char[] tempArr = tempStr.toCharArray();
            Map<Character,Integer> tempMap = new HashMap<>();
            for(int j=0;j<pLen;j++){
                tempMap.put(tempArr[j],tempMap.getOrDefault(tempArr[j],0)+1);
            }
            if(tempMap.equals(pMap)){
                ans.add(i);
            }
        }
        return ans;
    }
}
// 2. 通过全排列这个字符串p，然后在s中截取部分字符串进行set查找，同样也会导致超时

// 3. 滑动窗口
//    通过 使用数组来模拟Map的使用，进行词频统计
//    然后 通过固定窗口的长度，不断采集窗口的词频
//    最后判断字符串p的词频与滑动窗口的词频是否一致即可
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if(sLen<pLen)return res;
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for(int i=0;i<pLen;i++){
            sArr[s.charAt(i)-'a']++;
            pArr[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(sArr,pArr)){
            res.add(0);
        }
        for(int i=pLen;i<sLen;i++){
            sArr[s.charAt(i)-'a']++;
            sArr[s.charAt(i-pLen)-'a']--;
            if(Arrays.equals(sArr,pArr))res.add(i-pLen+1);
        }
        return res;
    }
}
