// 切换方向即可
// 我一开始写这个饶了一个大弯，想把字符串写到一个二维数组，然后再读出来
class Solution {
    public String convert(String s, int numRows) {
        if(numRows<2)return s;
        List<StringBuilder> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ans.add(new StringBuilder());
        }
        char[] cArr = s.toCharArray();
        int n=0,flag=-1;
        for(int i=0;i<cArr.length;i++){
            ans.get(n).append(cArr[i]);
            if(n==0 || n==numRows-1){
                flag = -flag;
            }
            n=n+flag;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ans.size();i++){
            sb.append(ans.get(i));
        }
        return sb.toString();
    }
}
