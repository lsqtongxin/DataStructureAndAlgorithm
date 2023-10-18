// 1.记忆化搜索方法
class Solution {
    int row,col;
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.row = obstacleGrid.length;
        this.col = obstacleGrid[0].length;
        if(obstacleGrid[this.row-1][this.col-1]==1)return 0;
        memo = new int[this.row][this.col];
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                if(obstacleGrid[i][j]==1){
                    memo[i][j] = 0;
                }else{
                    memo[i][j] = -1;
                }
            }
        }
        return uniquePaths(obstacleGrid,0,0);
    }
    private int uniquePaths(int[][] obstacleGrid,int x,int y){
        if(x>=this.row || y>=this.col){
            return 0;
        }
        if(x==this.row-1 && y==this.col-1)return 1;
        if(obstacleGrid[x][y]==1)return 0;
        if(memo[x][y]!=-1){
            return memo[x][y];
        }
        int res = 1 * uniquePaths(obstacleGrid,x+1,y) + 1 * uniquePaths(obstacleGrid,x,y+1);
        memo[x][y] = res;
        return res;
    }
}
