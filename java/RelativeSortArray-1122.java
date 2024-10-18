//1. 把大数组中的数据进行分离，在arr2中的数进行统计词频， 不在arr2中的数加到list中进行后续的排序
//   最后合成即可
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> aSet = new HashSet<>();
        List<Integer> otherNum = new ArrayList<>();
        for(int i=0;i<arr2.length;i++){
            aSet.add(arr2[i]);
        }
        Map<Integer,Integer> fre = new HashMap<>();
        for(int i=0;i<arr1.length;i++){
            if(aSet.contains(arr1[i])){
                fre.put(arr1[i],fre.getOrDefault(arr1[i],0)+1);
            }else{
                otherNum.add(arr1[i]);
            }
        }
        int[] ans = new int[arr1.length];
        int cur = 0;
        for(int i=0;i<arr2.length;i++){
            int num = fre.get(arr2[i]);
            for(int j=0;j<num;j++){
                ans[cur] = arr2[i];
                cur++;
            }
        }
        Collections.sort(otherNum,new Comparator<Integer>(){
            public int compare(Integer i1,Integer i2){
                return i1-i2;
            }
        });
        
        for(int i=0;i<otherNum.size();i++){
            ans[cur] = otherNum.get(i);
            cur++;
        }
        return ans;
    }
}

//2. 自定义排序机制，这个得学习一下子，很好的例子，拓展了思路
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : arr1) list.add(num);
        for(int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
        Collections.sort(list, (x, y) -> {
            if(map.containsKey(x) || map.containsKey(y)) return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            return x - y;
        });
        for(int i = 0; i < arr1.length; i++) arr1[i] = list.get(i);
        return arr1;
    }
}
