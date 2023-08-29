class Solution {
    private int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
    private boolean[][] visited;
    private int rowNum;
    private int colNum;
    private boolean isValid(int x,int y){
        return (x>=0 && x<this.rowNum && y>=0 && y< this.colNum);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image ==null)return null;
        this.rowNum = image.length;
        this.colNum = image[0].length;
        visited = new boolean[this.rowNum][this.colNum];
        backtrack(image,sr,sc,image[sr][sc],color);
        return image;
    }
    void backtrack(int[][] image,int x,int y,int old,int color){
        if( !isValid(x,y) || visited[x][y])return;
        if( image[x][y]!=old)return;
        image[x][y]=color;
        visited[x][y]=true;
        for(int i=0;i<4;i++){
            backtrack(image,x+d[i][0],y+d[i][1],old,color);
        }
    }
}
