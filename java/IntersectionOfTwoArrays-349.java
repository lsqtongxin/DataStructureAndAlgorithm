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
// set的使用
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //  第一个set用于去重某个数组中的值
	//  这里对nums1进行去重
        Set<Integer> nSet = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            nSet.add(nums1[i]);
        }
	//  第二个set用于存放结果集
	//  关键是这个结果为什么用set这个容器，而不用list/ArrayList容器呢？
	//  因为 nums2里面也有可能会存在重复数据，如果使用list/ArrayList导致多次添加重复数据到list中
	//  导致结果不正确
        Set<Integer> ans = new HashSet<>();
        for(int i=0;i<nums2.length;i++){
            if(nSet.contains(nums2[i])){
                ans.add(nums2[i]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
        // return ans.toArray(new int[ans.size()]);
    }
}
