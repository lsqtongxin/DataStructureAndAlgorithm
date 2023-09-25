// o(n^2)
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i-1] + nums[i];
      
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++  ){
                if(sum[j]-sum[i]==k){
                    count++;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(sum[i]==k)count++;
        }
        return count;
    }
}

//
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int[] preSum = new int[nums.length];
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(i==0)preSum[i]=nums[i];
            else preSum[i]=preSum[i-1]+nums[i];
            
            if(map.containsKey(preSum[i]-k)){
                count+=map.get(preSum[i]-k);
            }
            map.put(preSum[i],map.getOrDefault(preSum[i],0)+1);
        }
        return count;
    }
}

//
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
