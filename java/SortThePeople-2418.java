// 
//  逆序排序，需要把int[]转换为Integer[]吗？？？难以置信
//  为什么顺序排序就可以直接使用int[]进行呢？
//  2024.10.10
//  豆包答案是：
//  是因为 Java 的Arrays.sort()方法在对基本数据类型数组（如int[]）进行排序时，是按照自然升序进行排序的，这是由底层实现所决定的，无需额外的比较器。
//  然而，当要进行逆序排序时，没有直接对基本数据类型数组进行逆序排序的方法。如果想要逆序排序，通常需要借助比较器。
//  而比较器是针对对象进行操作的，对于基本数据类型，Java 提供了对应的包装类（如Integer对应int）。
//  所以将int[]转换为Integer[]后，可以使用针对Integer对象的比较器来实现逆序排序，如Comparator.reverseOrder()。
//  总的来说，这是由于 Java 对基本数据类型和对象的处理方式不同以及Arrays.sort()的设计所导致的。

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,Integer> mapArr = new HashMap<>();
        for(int i=0;i<heights.length;i++){
            mapArr.put(heights[i],i);
        }
        Integer[] heightsObj = new Integer[heights.length];
        for(int i=0;i<heights.length;i++){
            heightsObj[i]= heights[i];
        }
        Arrays.sort(heightsObj,Comparator.reverseOrder());
        String[] ans = new String[heights.length];
        for(int i=0;i<heights.length;i++){
            Integer index = mapArr.get(heightsObj[i]);
            ans[i] = names[index];
        }
        return ans;
    }
}
// 2. 这个可以进行逆序排序，采用的是lamda表达式

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n=names.length;
        Integer[] indices=new Integer[n];

        for(int i=0;i<n;i++){
            indices[i]=i;
        }
        Arrays.sort(indices,(a,b)->heights[b]-heights[a]);

        String [] res=new String[n];
        for(int i=0;i<n;i++){
            res[i]=names[indices[i]];
        }
        return res;
    }
}
