// 1. 记忆化搜索
class Solution {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j]=-1;
            }
        }
	// 写一下最后一列的数值
	// 因为最后一列只能向下走，不能向右走了
        int sum = 0;
        for(int i=m-1;i>=0;i--){
            sum+=grid[i][n-1];
            memo[i][n-1] = sum;
        }
        sum=0;
	// 写一下最后一行的数值
	// 因为我最后一行只能向右走，不能向下走了
        for(int j=n-1;j>=0;j--){
            sum+=grid[m-1][j];
            memo[m-1][j] = sum;
        }
        return minPath(grid,0,0);
    }
    private int minPath(int[][] grid,int i,int j){
        if(i>=grid.length || j>=grid[0].length)return 0;
        if(i==grid.length-1 && j==grid[0].length-1)return grid[i][j];
        if(memo[i][j]!=-1)return memo[i][j];
        int temp = Math.min(minPath(grid,i,j+1),minPath(grid,i+1,j));
        memo[i][j] = temp + grid[i][j];
        return memo[i][j];
    }
}
