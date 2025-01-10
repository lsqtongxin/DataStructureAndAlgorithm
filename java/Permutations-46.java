//1.
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        backtrack(nums);
        return res;
    }
    void backtrack(int[] nums){
        if(track.size()==nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i])continue;
            visited[i]=true;
            track.add(nums[i]);
            backtrack(nums);
            visited[i]=false;
            track.remove(track.size()-1);
        }
    }
}
//2.
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0)return res;
        int[] used = new int[nums.length];
        List<Integer> ans = new ArrayList<>();
        dfs(nums,used,res,ans);
        return res;
    }
    private  void dfs(int[] nums,int[] used,List<List<Integer>> res,
        List<Integer> ans){
        if(ans.size()==nums.length){
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==1)continue;
            ans.add(nums[i]);
            used[i]=1;
            dfs(nums,used,res,ans);
            ans.remove(ans.size()-1);
            used[i]=0;
        }
    }
}
//3.
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len==0)return res;
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums,len,0,path,used,res);
        return res;
    }
    private void dfs(
        int[] nums,
        int len,
        int depth,
        Deque<Integer> path,
        boolean[] used,
        List<List<Integer>> res){
        if(depth==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<len;i++){
            if(used[i])continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1,path,used,res);
            used[i] = false;
            path.removeLast();
        }
    }
}
