// 1. 直接套用 79 的解题方法，通过循环依次查找
//    但有的案例因超时无法通过，只通过了43/65个案例
class Solution {
    int[][] direct = {{1,0},{-1,0},{0,1},{0,-1}};
    int[][] used;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(words.length==0)return res;
        for(int i=0;i<words.length;i++){
            if(exist(board,words[i])){
                res.add(words[i]);
            }
        }
        return res;    
    }
    private boolean exist(char[][] board,String word){
    
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                used = new int[board.length][board[0].length];
                if(dfs(board,word,i,j,0)){
                    return true;
                }

            }
        }
        return false;
    }
    private boolean dfs(char[][] board,String word,int i,int j,int k){
        if(k==word.length()-1){
            return board[i][j]==word.charAt(k);
        }
        if(validArea(board,i,j)==0)return false;
        if(board[i][j]!=word.charAt(k))return false;
        k++;
        used[i][j]=1;
        for(int x=0;x<4;x++){
            int newi = i + direct[x][0];
            int newj = j + direct[x][1];
            if(validArea(board,newi,newj)==0)continue;
            if(dfs(board,word,newi,newj,k)){
                return true;
            };
        }
        k--;
        used[i][j]=0;
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

// 2.

