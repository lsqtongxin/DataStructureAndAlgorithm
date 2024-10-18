// map的使用
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> nums1Map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            nums1Map.put(nums1[i],nums1Map.getOrDefault(nums1[i],0)+1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(nums1Map.containsKey(nums2[i])){
                res.add(nums2[i]);
                if(nums1Map.get(nums2[i])==1)nums1Map.remove(nums2[i]);
                else nums1Map.put(nums2[i],nums1Map.get(nums2[i])-1);
            }
        }
        int[] resArr = new int[res.size()];
        for(int i=0;i<res.size();i++){
            resArr[i]=res.get(i);
        }
        return resArr;
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer,Integer> nMap = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            nMap.put(nums1[i],nMap.getOrDefault(nums1[i],0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
	    // 把判断写在一行进行处理
            if(nMap.containsKey(nums2[i]) && nMap.get(nums2[i])>0){
                ans.add(nums2[i]);
                nMap.put(nums2[i],nMap.get(nums2[i])-1);
            }

        }
	// 将 list 转化为数组
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
// 相当于自定义一个hashmap了
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] hash = new int[1001];
        for (int num: nums1) {
            hash[num] += 1;
        }

        List<Integer> list = new ArrayList<>();
        for (int num: nums2) {
            if (hash[num] > 0) {
                hash[num] -= 1;
                list.add(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0;i < res.length;i += 1) {
            res[i] = list.get(i);
        }
        return res;
    }
}
