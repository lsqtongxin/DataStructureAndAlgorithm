class Solution {
    int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] visited;
    int row,col;
    public void solve(char[][] board) {
        if(board==null)return;
        this.row = board.length;
        this.col = board[0].length;
        visited = new boolean[this.row][this.col];
        for(int i=0;i<this.row;i++){
            backtrack(board,i,0);
            backtrack(board,i,this.col-1);
        }
        for(int j=0;j<this.col;j++){
            backtrack(board,0,j);
            backtrack(board,this.row-1,j);
        }
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                if(board[i][j]=='O' && !visited[i][j] ){
                    board[i][j]='X';
                }
            }
        }
    }
    void backtrack(char[][] board,int x,int y){
        if(!isValid(x,y) || visited[x][y])return;
        if(board[x][y]!='O')return;
        visited[x][y]=true;
        for(int i=0;i<4;i++){
            backtrack(board,x+d[i][0],y+d[i][1]);
        }
    }
    boolean isValid(int x,int y){
        return (x>=0 && x<this.row && y>=0 && y<this.col);
    }
}