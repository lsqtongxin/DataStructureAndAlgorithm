// 这题两个关键点：
//     1. 如何数一个数字里面1的个数
//     2. 如何排序,按照某个维度进行排序
class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                int xBit = numberOfBits(x);
                int yBit = numberOfBits(y);
                if (xBit != yBit) {
                    return xBit - yBit;
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    int numberOfBits(int val){
        int count = 0;
        while(val!=0){
            count++;
            val = val&(val-1);
        }
        return count;
    }
}
