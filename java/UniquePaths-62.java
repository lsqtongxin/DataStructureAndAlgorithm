// 1. 在自己的笔记本上能正常运行，而leetcode显示超时
class Solution {
    int[][] d = {{0,1},{1,0}};
    // 与正常的直角坐标系不同，这里的坐标系 垂直向下指向的是x正极，水平向右指向的是y正极，符合数组及遍历。
    // String[] ins = {"Right","Down"};
    boolean[][] visited;
    int ans,row,col;
    public int uniquePaths(int m, int n) {
        visited = new boolean[m][n];
        row = m;
        col = n;
        backtrack(0,0);
        return ans;
    }
    void backtrack(int x,int y){
        if(x == this.row-1 && y == this.col-1){
            this.ans++;
            return;
        }
        if(!isValid(x,y) || visited[x][y])return;
        visited[x][y]=true;
        for(int i=0;i<2;i++){
            backtrack(x+d[i][0],y+d[i][1]);
        }
        visited[x][y]=false;
    }
    boolean isValid(int x,int y){
        return (x>=0 && x<this.row && y>=0 && y<this.col);
    }
}

// 2. 基于第1种方法，添加路径信息，并输出相关路径
// 重点是对 backtrack函数的定义以及step变量的定义
// 同时需要剔除从哪个方向来到起始点的信息,因为一开始就在起始点，无需记录。
class Solution {
    int[][] d = {{0,1},{1,0}};
    // 与正常的直角坐标系不同，这里的坐标系 垂直向下指向的是x正极，水平向右指向的是y正极，符合数组及遍历。
    String[] ins = {"Right","Down"};
    boolean[][] visited;
    int ans,row,col;
    List<List<String>> res = new ArrayList<>();
    ArrayList<String> track = new ArrayList<>();
    public int uniquePaths(int m, int n) {
        visited = new boolean[m][n];
        row = m;
        col = n;
        backtrack(0,0,0);
        System.out.println(res.toString());
        System.out.println("res.size() :"+res.size());
        System.out.println("ans length :"+ans);
        return ans;
    }
    //  开始访问(x,y)节点，并从step知道是从哪个方向访问到(x,y)节点
    //  x,y为坐标，step代表从哪个方向访问到这个x,y节点
    void backtrack(int x,int y,int step){
        if(x == this.row-1 && y == this.col-1){
            this.ans++;
            //记录一下从哪个方向访问到最后的节点的 路径
            track.add(ins[step]);
            res.add(new ArrayList<String>(track));
            return;
        }
        if(!isValid(x,y) || visited[x][y])return;
        visited[x][y]=true;
        // 剔除(0,0)这个点，因为是从这个点开始，所以无需记录路径
        if(x!=0 || y!=0){
            track.add(ins[step]);
        }
        for(int i=0;i<2;i++){
            backtrack(x+d[i][0],y+d[i][1],i);
        }
        visited[x][y]=false;
        track.remove(track.size()-1);
    }
    boolean isValid(int x,int y){
        return (x>=0 && x<this.row && y>=0 && y<this.col);
    }
}

// 3. 动态规划方法，这种方法只能算出具体的路径数量，而无法得知路径信息
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] count = new int[m][n];
        for(int i=0;i<m;i++){
            count[i][0]=1;
        }
        for(int j=0;j<n;j++){
            count[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                count[i][j]=count[i-1][j]+count[i][j-1];
            }
        }
        return count[m-1][n-1];
    }
}
