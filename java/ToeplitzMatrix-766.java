class Solution {
    int row;
    int col;
    public boolean isToeplitzMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        if(row==1 || col==1)return true;
        for(int j=0;j<col;j++){
            int temp = matrix[0][j];
            int x = 0;
            int y = j;
            while(isValid(x,y)){
                if(temp!=matrix[x][y])return false;
                x++;
                y++;
            }
        }
        for(int i=1;i<row;i++){
            int temp = matrix[i][0];
            int x = i;
            int y = 0;
            while(isValid(x,y)){
                if(temp!=matrix[x][y])return false;
                x++;
                y++;
            }
        }
        return true;
    }
    boolean isValid(int x,int y){
        return (x>=0 && x < this.row && y>=0 && y< this.col);
    }
}