class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0)return res;
        int[] used = new int[nums.length];
        List<Integer> ans = new ArrayList<>();
        dfs(nums,res,used,ans);
        return res;
    }
    void dfs(int[] nums,List<List<Integer>> res,int[] used,List<Integer> ans){
        if(ans.size()==nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=0;i<nums.length;i++){
						// 如果这个数字已使用,则跳过
            if(used[i]==1)continue;

						// 说明当前这个数字nums[i]还没有使用过
						// 那么我们需要看一下与这个nums[i]相等的元素是否使用过，如果使用了则跳过。
						// 由于nums数字已经被排序，从小到大，而相同的元素紧紧挨着
						// 我们要过滤相同的元素，即 i>0 && nums[i]==nums[i-1]
						// 且之前的i-1被使用过，则这个i将进行过滤，即 used[i-1]=1 说明相同元素的第一个数字已经被使用过，过滤当前这个数字
            if(i>0 && nums[i]==nums[i-1] && used[i-1]==1)continue;
            ans.add(nums[i]);
            used[i]=1;
            dfs(nums,res,used,ans);
            used[i]=0;
            ans.remove(ans.size()-1);
        }

    }
}
