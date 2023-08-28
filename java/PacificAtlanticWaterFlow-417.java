// 此题的重点，不是水从高处像低处流，而是水从低处留下高处
// 将 流向太平洋的方块和流向大西洋的方块分开
// 正常逻辑：1.流向太平洋的水，最后的一步只能是左侧和上侧的方块
//          2.流向大西洋的水，最后的一步只能是右侧和下侧的方块
//          也就是说 去太平洋，左侧和上侧是必经之路
//                  去大西洋，右侧和下侧是必经之路
//  水一般是从高处流向低处，我们反其道而行，让水从低处流向高处，只是水流的方向不同
//  而路径都是一样的，也就是说 让水从大洋流向陆地，记录水流流过陆地的某个节点的记录

//  那我们从必经之路(四个边)开始floodfill，先运行左侧和上侧，遍历太平洋的水能否流向各个节点，
//  并记录能否流到这个节点。   也就是说能留到这个节点，相反，这个节点的水也能流向这个太平洋
//  再运行右侧和下侧，遍历大西洋的水能否流向各个节点，并记录能否流到这个节点
//  那么既能流向太平洋又能流向大西洋的节点就是他们两个的交集。
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    //boolean[][] visited;
    int row,col;
    int[][] d = {{1,0},{-1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights==null)return res;
        this.row = heights.length;
        this.col = heights[0].length;
        int[][] pacific = new int[this.row][this.col];
        int[][] atlantic= new int[this.row][this.col];
        //visited = new boolean[this.row][this.col];
        for(int i=0;i<this.row;i++){
            backtrack(heights,i,0,pacific,-1);
            backtrack(heights,i,this.col-1,atlantic,-1);
        }
        for(int j=0;j<this.col;j++){
            backtrack(heights,0,j,pacific,-1);
            backtrack(heights,this.row-1,j,atlantic,-1);
        }
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    res.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return res;
    }

    void backtrack(int[][] heights,int x,int y,int[][] ans,int pre){
        if(!isValid(x,y) || pre > heights[x][y] || ans[x][y]==1)return;
        ans[x][y] = 1;
        for(int i=0;i<4;i++){
            int m = x+d[i][0];
            int n = y+d[i][1];
            backtrack(heights,m,n,ans,heights[x][y]);
        }
    }
    boolean isValid(int x,int y){
        return (x>=0 && x<this.row && y>=0 && y<this.col);
    }
}