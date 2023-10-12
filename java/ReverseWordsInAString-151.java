class Solution {
    public String reverseWords(String s) {
        String ss = s.trim().replaceAll("\\s+"," ");
        char[] sArr = ss.toCharArray();
        int i=0;
        int j=sArr.length-1;
        while(i<j){
            char temp = sArr[i];
            sArr[i] = sArr[j];
            sArr[j] = temp;
            i++;
            j--;
        }
        int start = 0;
        for(int n=0;n<sArr.length;n++){
            if(sArr[n]==' '){
                reverseStr(sArr,start,n-1);
                start = n+1;
            }
        }
        reverseStr(sArr,start,sArr.length-1);
        return new String(sArr);
    }
    private void reverseStr(char[] arr,int i,int j){
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
