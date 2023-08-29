class Solution {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null)return res;
        Arrays.sort(candidates);
        backtrack(candidates,target,0,0);
        return res;
    }

    void backtrack(int[] candidates,int target,int pathSum,int index){  
        if(pathSum == target){
            res.add(new ArrayList<>(track));
            return;
        }
        if(pathSum > target)return;
        for(int i=index;i<candidates.length;i++){
            // 减枝操作
            if(i>index && candidates[i]==candidates[i-1])continue;
            track.add(candidates[i]);
            pathSum+=candidates[i];
            backtrack(candidates,target,pathSum,i+1);
            track.remove(track.size()-1);
            pathSum-=candidates[i];
        }
    }
}
