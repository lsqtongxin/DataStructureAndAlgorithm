// 与题目438相似，但有很大差异
// 
// 差异分析：
//     一. 如果是按照字符的颗粒度来看，统计words的字符词频，然后在字符串s中按照 wordNum*wordLen的固定长度进行统计词频
//        无论是每次重复进行词频统计，还是滑动窗口式的词频统计，都无法完成任务，因为words中是字符串数组
//        如果 words = ["ab","cd","ef"], 那么 s="acebdf"也能满足，这样不符合题意。
//     二. 如果是按照字符串的颗粒度来看，统计words的字符串的词频，然后在字符串s中依次取出 固定长度wordNum*wordLen的字符串进行统计字符串词频
//        但这个步长是 1 还是 wordLen呢？ 这是一个很关键的问题，因为 假设s = "aabcdef" 按照这样是符合题意的，

// 那么最菜的方法是
//   首先对words进行字符串的词频统计
//   其次需要在字符串s中按照 步长为1 依次取出 固定长度wordNum*wordLen字符串
//   然后进行 字符串的词频统计，然后对比 固定长度的窗口的词频与 words字符串词频是否相等。
// 1. 比较words 和 s中挑选出来的字符串的词频
//    固定的窗口,依次进行统计词频
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int sLength = s.length();
        int wLength = words.length;
        int length = words[0].length();
        int end = sLength - wLength * length;
        List<Integer> ans = new ArrayList<>();
        Map<String,Integer> wordsMap = new HashMap<>();
        for(int i=0;i<words.length;i++){
            wordsMap.put(words[i],wordsMap.getOrDefault(words[i],0)+1);
        }
        for(int i=0;i<end+1;i++){
            String tempStr = s.substring(i,i+wLength*length);
            HashMap<String,Integer> tmpMap = new HashMap<>();
            for(int j=0;j<wLength*length;j+=length){
                String temp = tempStr.substring(j,j+length);
                tmpMap.put(temp,tmpMap.getOrDefault(temp,0)+1);
            }
            if(tmpMap.equals(wordsMap)){
                ans.add(i);
            }
        }
        return ans;
    }
}
// 2. 将words全排列放到Set中，然后从String s中依次按步长为1截取wordNum*wordLen的字符串进行判断是否存在于set中
//    全排列需要使用回溯方法，会需要较大的计算量，导致超时
//    题目提示有
//    1 <= words.length <= 5000
//    1 <= words[i].length <= 30
//    



// 3. 滑动窗口
//   基于第一种方法进行改进，使用滑动窗口方法解决问题:
//   滑动窗口内部只放与words各个字符串一致的字符串
//   例如 words = ["ab","cd","ef"], 那么窗口只能是 [] 或[ab,cd]，不能是[ba]
//   也就是说不是这个words中的字符串，不能进入到滑动窗口内。
//   这样做是为了后续比较滑动窗口的词频和words字符串的词频，
//   同时避免了这样的情况，滑动窗口[ba,ab,cd,ef]
//   这个滑动窗口的长度是随时变化的，而不是固定大小。

//   这里针对错位的问题，有一个小技巧，
//   针对 如果 words = ["abc","def","ghk"],s="aabcdefghk",这种情况需要移位3位，分别开展三次的滑动窗口进行查找。
//   words字符串有多少位，就进行多少次滑动窗口搜索。
//   步骤如下：
//   首先对words进行字符串的词频统计
//   其次需要错位依次比较,words中字符串的长度多少，就进行几次滑动窗口搜索
//   扩大滑动窗口，将符合条件的字符串加入window词频中，不符合的重新来过
//   缩小滑动窗口，因为滑动窗口内部都是符合条件的字符串，所以最大的滑动窗口值为wordLen*wordNum
//   当窗口大于wordLen*wordNum时候就进行缩小滑动窗口，同时减去window相应的词频
//   对于词频减到0的entry，直接删除，这样可以避免 =0的存在
//   然后进行对比 滑动窗口的词频与 words字符串词频是否相等。
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s==null || s.length()==0 || words.length==0)return res;
        int sLen = s.length();
        int wordLen = words[0].length();
        int wordNum = words.length;
        if(sLen< wordLen*wordNum)return res;
        Map<String,Integer> fre = new HashMap<>();
        for(String word:words){
            fre.put(word,fre.getOrDefault(word,0)+1);
        }
        for(int i=0;i<wordLen;i++){
            int start = i,cur = i;
            Map<String,Integer> window = new HashMap<>();
            while(cur+wordLen<=sLen){
                String tempStr = s.substring(cur,cur+wordLen);
                cur+=wordLen;
                if(fre.containsKey(tempStr)){
                    window.put(tempStr,window.getOrDefault(tempStr,0)+1);
                }else {
                    start = cur;
                    window.clear();
                }
                while(cur-start>wordLen*wordNum){
                    String stStr = s.substring(start,start+wordLen);
                    if(window.get(stStr)==1){
                        window.remove(stStr);
                    }else{
                        window.put(stStr,window.get(stStr)-1);
                    }
                    start+=wordLen;
                }
                if(window.equals(fre)){
                    res.add(start);
                }
            }
        }
        return res;
    }
}








