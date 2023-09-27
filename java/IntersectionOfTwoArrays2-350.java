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
