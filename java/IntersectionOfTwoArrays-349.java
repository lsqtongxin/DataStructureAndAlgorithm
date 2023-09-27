// 集合set的使用
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        Set<Integer> res = new HashSet<>();
        for(int i=0;i<nums2.length;i++){
            if(set1.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        int[] resArray = new int[res.size()];
        Iterator<Integer> it = res.iterator();
        int i =0;
        while(it.hasNext()){
            resArray[i]=it.next().intValue();
            i++;
        }
        return resArray;
    }
}
