class Solution {
    private ArrayList<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<List<String>>();
        ArrayList<Integer> row = new ArrayList<>();
        putQueen(n, 0, row);
        return res;
    }

    // 尝试在一个n皇后问题中, 摆放第index行的皇后位置
    private void putQueen(int n, int index, List<Integer> row){
        if(index == n){
            res.add(generateBoard(n, row));
            return;
        }

        for(int i = 0 ; i < n ; i ++)
            // 尝试将第index行的皇后摆放在第i列， (index,i) 第Index行第i列
            if(validArea(row,index,i)==1){
                row.addLast(i);
                putQueen(n, index + 1, row);
                row.removeLast();
            }

        return;
    }

    private int validArea(List<Integer> row,int i,int j){
        int num = row.size();
        for(int m=0;m<num;m++){
            // (m,n)  (i,j)
            int n = row.get(m);
            if(j==n || Math.abs(i-m)==Math.abs(j-n)){
                return 0;
            }
        }
        return 1;
    }

    private List<String> generateBoard(int n, List<Integer> row){
        assert row.size() == n;
        ArrayList<String> board = new ArrayList<String>();
        for(int i = 0 ; i < n ; i ++){
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }
}
