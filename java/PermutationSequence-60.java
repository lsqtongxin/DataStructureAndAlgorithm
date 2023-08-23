class Solution {
    ArrayList<Integer> track = new ArrayList<>();
    List<Integer> res;
    boolean[] visited;
    int nth;
    public String getPermutation(int n, int k) {
        visited = new boolean[n+1];
        nth =0;
        backtrack(n,k);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<res.size();i++){
            sb.append(res.get(i).toString());
        }
        return sb.toString();
    }
    public void backtrack(int n, int k){
        if(track.size()==n){
            nth++;
            if(nth == k){
                res = new ArrayList<>(track);
            };
            return;
        }
        for(int i=1;i<=n;i++){
            if(visited[i])continue;
            visited[i]=true;
            track.add(i);
            backtrack(n,k);
            visited[i]=false;
            track.remove(track.size()-1);
        }

    }
}
