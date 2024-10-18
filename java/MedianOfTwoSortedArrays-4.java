// 合并排序的翻版
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int mid = (len1+len2)/2;
        int[] temp = new int[len1+len2];
        int ji = (len1+len2)%2;
        int i=0,j=0,k=0;
        while(i<len1 && j<len2){
            if(nums1[i]<nums2[j]){
                temp[k]=nums1[i];
                i++;
            }else{
                temp[k]=nums2[j];
                j++;
            }
            k++;
        }
        if(i==len1){
            for(;j<len2;j++){
                temp[k]=nums2[j];
                k++;
            }
        }
        if(j==len2){
            for(;i<len1;i++){
                temp[k]=nums1[i];
                k++;
            }
        }
        if(ji==1)return temp[mid];
        else return (double)(temp[mid-1]+temp[mid])/2;
    }
}
