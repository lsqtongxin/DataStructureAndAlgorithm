// 游程编码
// 按个数去数和拼接
class Solution {
    public String countAndSay(int n) {
        String s = "1";
        if(n==1)return s;
        int i=2;
        while(i<=n){
            s = rle(s);
            i++;
        }
        return s;
    }
    private String rle(String s){
        char[] sArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<sArr.length;i++){
            char tempVal = sArr[i];
            int count = 0;
            while(i<sArr.length && tempVal == sArr[i]){
                count++;
                i++;
            }
	    // 此时while中的i++和for循环的i++重叠
	    // 所以需要减一下
            i--;
            sb.append(Integer.toString(count));
            sb.append(tempVal);
        }
        return sb.toString();
    }
}
