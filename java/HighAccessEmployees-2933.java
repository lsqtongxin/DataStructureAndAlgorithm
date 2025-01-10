class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> accessTimes) {
        Map<String, List<Integer>> groups = new HashMap<>();
        //for (var entry : accessTimes) {
        //    String name = entry.get(0), s = entry.get(1);
        //    int t = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(2));
	//    k：形式上是函数的参数，它接收的就是当前传入 computeIfAbsent 方法中那个不存在的键（也就是前面提到的 name）
	//    不过在这里其实并没有在 Lambda 表达式内部真正使用这个 k 参数（因为只需要创建一个新的空 ArrayList，不需要依赖具体的键内容
        //    groups.computeIfAbsent(name, k -> new ArrayList<>()).add(t);
        //}
        for(int i=0;i<accessTimes.size();i++){
            String name = accessTimes.get(i).get(0);
            String time = accessTimes.get(i).get(1);
            int t = Integer.parseInt(time.substring(0,2))*60 + Integer.parseInt(time.substring(2));
            List<Integer> temp = groups.getOrDefault(name,new ArrayList<Integer>());
            temp.add(t);
            groups.put(name,temp);
        }

        List<String> ans = new ArrayList<>();
        for (var entry : groups.entrySet()) {
            List<Integer> a = entry.getValue();
            Collections.sort(a);
            for (int i = 2; i < a.size(); i++) {
                if (a.get(i) - a.get(i - 2) < 60) {
                    ans.add(entry.getKey());
                    break;
                }
            }
        }
        return ans;
    }
}
