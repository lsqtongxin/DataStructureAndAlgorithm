// 排序需要学习一下
// 
class Solution {
    public String frequencySort(String s) {
      Map<Character, Integer> hm = new HashMap<>();
      for(char ch : s.toCharArray()){
          hm.put(ch, hm.getOrDefault(ch,0) + 1);
      }
      List<Character> list = new ArrayList<>(hm.keySet());
      list.sort((ob1, ob2) -> hm.get(ob2) - hm.get(ob1));
      StringBuilder ans = new StringBuilder();
      for(char ch : list){
          for(int i = 0; i< hm.get(ch); i++){
           ans.append(ch);
          }
      }
    return ans.toString();
    }
}
// 这个也学习一下
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> m = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            m.put(c,m.getOrDefault(c,0)+1);
        }
        Queue<Map.Entry<Character,Integer>> qu=new PriorityQueue<>(
				(a,b)->{
					if(a.getValue() != b.getValue())
						return -a.getValue().compareTo(b.getValue());
					return a.getKey().compareTo(b.getKey());
				}
				);
		
		for(Map.Entry<Character,Integer> n : m.entrySet()) {
			qu.offer(n);
		}
		String str="";
		while(!qu.isEmpty()) {
			int n=qu.peek().getValue();
			char ch=qu.poll().getKey();
			while(n>0) {
				str=str+ch;
				n--;
			}
		}
        return str;
    }
}
