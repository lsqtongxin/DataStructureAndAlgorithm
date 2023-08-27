class Solution {
    int res = 0;
    int row,col;
    boolean[][] visited;
    int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numEnclaves(int[][] grid) {
        if(grid==null)return 0;
        this.row = grid.length;
        this.col = grid[0].length;
        visited = new boolean[this.row][this.col];
        for(int i=0;i<this.row;i++){
            backtrack(grid,i,0);
            backtrack(grid,i,this.col-1);
        }
        for(int j=0;j<this.col;j++){
            backtrack(grid,0,j);
            backtrack(grid,this.row-1,j);
        }
        int res = 0;
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                if(grid[i][j]==1 && !visited[i][j])res++;
            }
        }
        return res;
    }
    void backtrack(int[][] grid,int x,int y){
        if(!isValid(x,y) || visited[x][y])return;
        if(grid[x][y]==0)return;
        visited[x][y]=true;
        for(int i=0;i<4;i++){
            backtrack(grid,x+d[i][0],y+d[i][1]);
        }
    }
    boolean isValid(int x,int y){
        return (x>=0 && x<this.row && y>=0 && y<this.col);
    }
}