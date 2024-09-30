// 这个题就是简单的统计并且排序，取前k个即可
// 但是这个题可以练习 Java语法
// 1. 排序
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> fre = new HashMap<>();
	// 第一步：统计词频
        for(int i=0;i<words.length;i++){
            fre.put(words[i],fre.getOrDefault(words[i],0)+1);
        }
        List<String> rec = new ArrayList<>();
	// 这里为什么取hashmap的keyset，是因为 原words数组中会有很多重复的字符粗
	// 而这里的keyset已经被上面的hashmap天然去重并且获得频率了
	// 第二步：得到所有的字符串唯一的数组
        for(Map.Entry<String,Integer> entry: fre.entrySet()){
            rec.add(entry.getKey());
        }
	// 第三步：对第二步得出的字符串唯一的数组根据词频进行排序
        Collections.sort(rec,new Comparator<String>(){
            public int compare(String str1,String str2){
                return fre.get(str1)==fre.get(str2)?str1.compareTo(str2):fre.get(str2)-fre.get(str1);
            }
        });
        return rec.subList(0,k);
    }
}
// 1.2 直接使用Entry进行排序
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        if(words.length==0)return ans;
        Map<String,Integer> fre = new HashMap<>();
        for(int i=0;i<words.length;i++){
            fre.put(words[i],fre.getOrDefault(words[i],0)+1);
        }
        List<Map.Entry<String,Integer>> ansEntry = new ArrayList<>(fre.entrySet());
        Collections.sort(ansEntry,new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> entry1,
                            Map.Entry<String,Integer> entry2){
                return entry1.getValue()==entry2.getValue()?
                        entry1.getKey().compareTo(entry2.getKey()):
                        entry2.getValue()-entry1.getValue();
            }
        });
        
        for(int i=0;i<k;i++){
            ans.add(ansEntry.get(i).getKey());
        }
        return ans;
    }
}


//2.
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> fre = new HashMap<>();
        for(int i=0;i<words.length;i++){
            fre.put(words[i],fre.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<String,Integer>>(){
                public int compare(Map.Entry<String,Integer> entry1,Map.Entry<String,Integer> entry2){
                    return entry1.getValue()==entry2.getValue()?entry2.getKey().compareTo(entry1.getKey()):entry1.getValue()-entry2.getValue();
                }
            }
        );
        for(Map.Entry<String,Integer> entry: fre.entrySet()){
            pq.offer(entry);
            if(pq.size()>k)pq.poll();
        }
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
    }
}
//3.
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if(words.length==0)return new ArrayList<>();
        Map<String,Integer> fre = new HashMap<>();
        for(int i=0;i<words.length;i++){
            fre.put(words[i],fre.getOrDefault(words[i],0)+1);
        }
        ArrayList<String> ans = fre.keySet().stream()
               .collect(Collectors.toCollection(ArrayList::new));
        Collections.sort(ans,new Comparator<String>(){
            public int compare(String str1,String str2){
                return fre.get(str1)==fre.get(str2)?
                    str1.compareTo(str2):
                    fre.get(str2)-fre.get(str1);
            }
        });
        return ans.subList(0,k);
    }
}

