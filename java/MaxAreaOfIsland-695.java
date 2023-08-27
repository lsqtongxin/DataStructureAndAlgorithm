class Solution {
    
    int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] visited;
    int row,col;
    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null)return 0;
        this.row = grid.length;
        this.col = grid[0].length;
        int res = 0;
        visited = new boolean[this.row][this.col];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    area = 0;
                    backtrack(grid,i,j);
                    if(area>res)res=area;
                }
            }
        }
        return res;
    }
    void backtrack(int[][] grid,int x, int y){
        if(!isValid(x,y) || visited[x][y])return;
        if(grid[x][y]!=1)return;
        visited[x][y]=true;
        this.area++;
        for(int i=0;i<4;i++){
            backtrack(grid,x+d[i][0],y+d[i][1]);
        }        
    }
    boolean isValid(int x,int y){
        return (x>=0 && x<this.row && y>=0 && y<this.col);
    }
}