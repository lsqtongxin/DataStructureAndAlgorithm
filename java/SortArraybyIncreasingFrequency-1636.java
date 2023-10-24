// 学习一下排序吧，尤其是Arrays.sort
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Integer[] arr = new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            arr[i] = nums[i];
        }
        Arrays.sort(arr,(a,b)->{
            if(map.get(a)==map.get(b)){
                return b - a;
            }else if(map.get(a)<map.get(b)){
                return -1;
            }else {
                return 1;
            }
        });
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i]=arr[i];
        }
        return res;
    }
}
