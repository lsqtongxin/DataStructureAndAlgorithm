// 通过 map.containsKey来进行去重操作
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] array = Arrays.copyOf(arr,arr.length);
        Arrays.sort(array);
        int k=1;
        for(int i=0;i<array.length;i++){
            // 将相同的值去重
            if(!map.containsKey(array[i])){
                map.put(array[i],k);
                k++;
            }
        }
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i]=map.get(arr[i]);
        }
        return res;
    }
}
