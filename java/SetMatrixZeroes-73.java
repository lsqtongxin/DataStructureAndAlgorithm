class Solution {
    int row;
    int col;
    public void setZeroes(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    res.add(i);
                    res.add(j);
                }
            }
        }
        for(int count=0;count < res.size()/2;count++){
            // row
            for(int j=0;j<col;j++){
                matrix[res.get(count*2)][j]=0;
            }
            // col
            for(int i=0;i<row;i++){
                matrix[i][res.get(count*2+1)]=0;
            }
        }
        
    }
}