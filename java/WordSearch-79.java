class Solution {
    int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};
    int[][] used;
    public boolean exist(char[][] board, String word) {
        if(board.length==0 || word.length()==0)return true;
        used = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,String word,int i,int j,int k){
        if(k==word.length()-1 && used[i][j]==0){
            return board[i][j]==word.charAt(k);
        }
        if(used[i][j]==1)return false;
        if(board[i][j]!=word.charAt(k))return false;
        used[i][j] = 1;
        k++;
        for(int x=0;x<4;x++){
            int newi = i + direct[x][0];
            int newj = j + direct[x][1];
            if(validArea(board,newi,newj)==0)continue;
            if(dfs(board,word,newi,newj,k)){
                return true;
            }
        }
        used[i][j] = 0;
        k--;
        return false;
    }
    private int validArea(char[][] board,int i,int j){
        if(i>=board.length || j>=board[0].length || i<0 || j<0){
            return 0;
        }else if(used[i][j]==1){
            return 0;
        }else{
            return 1;
        }
    }
}
