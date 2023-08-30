class Solution {
    int row,col;
    int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        int res = 0;
        if(row==1 && col==1)return 1;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int temp =backtrack(matrix,i,j,-1,memo);
                if(temp>res)res=temp;
            }
        }
        return res;
    }
    int backtrack(int[][] matrix,int x,int y,int pre,int[][] memo){
        if(!isValid(x,y) || pre >= matrix[x][y])return 0;
        if(memo[x][y]!=0)return memo[x][y];
        int ans = 0;
        for(int i=0;i<4;i++){
            int temp = 1 + backtrack(matrix,x+d[i][0],y+d[i][1],matrix[x][y],memo);
            if(temp>ans)ans=temp;
        }
        memo[x][y]=ans;
        return ans;
    }
    boolean isValid(int x,int y){
        return (x>=0 && x<this.row && y>=0 && y<this.col);
    }

}