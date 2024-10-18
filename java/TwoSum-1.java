//
// 前提：每种输入只会对应一个答案，并且你不能使用两次相同的元素
//       也就是说 有一个答案，没有重复的返回
// 暴力: O(n^2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++)
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    return res;
                }
        }
        return res;
    }
}
// 2. hashmap tc: O(n)  sc: O(n)
// 这种方法不适合一个数组中存在重复数字，虽然这种方法也能AC
// 但是这种方法不可靠
// nums = [3,3], target = 6

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);         // 当数组中出现重复数字后，会覆盖之前的下标值
        }
        for(int i=0;i<nums.length;i++){
            int temp = target - nums[i];
            if(map.containsKey(temp) && map.get(temp)!=i){
                res[0]=i;
                res[1]=map.get(temp);
                return res;
            }
        }
        return res;
    }
}

// 3. hashmap tc: O(n)  sc: O(n)
// 前提：每种输入只会对应一个答案，并且你不能使用两次相同的元素
// 如何控制不能使用两次相同的元素呢？
// 通过逐个判断，将一个数组划分为两个部分
// [0,i-1] 这一段里面需要使用map统计元素和索引
// [i,nums.length-1]在这个区域逐步查找
// 返回的结果是这两个部分的组合，自然不会重复使用相同的元素。
// 还有一点是[0,i-1]这一段里面，可能会有重复数据，导致后面的数据的索引会覆盖前面数据的索引
// 因为只有一个答案，覆盖这种情况可以不用操心，因为如果前面能找到早就返回结果了。
// 1 2 4 7 7 9 寻找16，那么只能是第二个7和9

// 逐渐向后扫描的方法
// i向后进行扫描，在i的前面找补充数字，这样依次走得到结果
// 特殊情况： 1 2 4 7 7 9  寻找14，
// 当i指向第2个7时候，找另外一个7此时在map中就能找到
// 而使用上面第2中方式，前一个7的索引会被第二个7进行覆盖，且无法找到14结果就错误了
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int com = target - nums[i];
            if(m.containsKey(com)){
                return new int[]{i,m.get(com)};
            }else{
                m.put(nums[i],i);
            }
        }
        return null;
    }
}
