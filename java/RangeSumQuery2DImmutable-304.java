// sumMatrix[i][j] 是从 matrix[0][0]到matrix[i][j]的和
class NumMatrix {
    int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(row==0 || col==0)return;
        sumMatrix = new int[row][col];
        sumMatrix[0][0] = matrix[0][0];
        for(int i=1;i<row;i++){
            sumMatrix[i][0] = matrix[i][0]+sumMatrix[i-1][0]; 
        }
        for(int j=1;j<col;j++){
            sumMatrix[0][j] = matrix[0][j]+ sumMatrix[0][j-1];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                sumMatrix[i][j] = matrix[i][j]+ sumMatrix[i-1][j]+sumMatrix[i][j-1]-sumMatrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1==0 || col1==0){
            if(row1==0 && col1!=0){
                return sumMatrix[row2][col2]-sumMatrix[row2][col1-1];
            }
            if(row1!=0 && col1==0 ){
                return sumMatrix[row2][col2]-sumMatrix[row1-1][col2];
            }
            return sumMatrix[row2][col2];
        }
        return sumMatrix[row2][col2]-sumMatrix[row1-1][col2]-sumMatrix[row2][col1-1]+sumMatrix[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
