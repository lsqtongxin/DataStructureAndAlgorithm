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
