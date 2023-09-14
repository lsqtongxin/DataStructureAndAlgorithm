class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0)return null;
        int length = s.length();
        String res = "";
        for(int i=0;i<s.length();i++){
            String res1 = palindrome(s,i,i);
            String res2 = palindrome(s,i,i+1);
            res = res.length()>res1.length()?res:res1;
            res = res.length()>res2.length()?res:res2;
        }
        return res;        
    }
    private String palindrome(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }

    private boolean isPalindrome(String s){
        if(s==null)return true;
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))return false;
            left++;
            right--;
        }
        return true;
    } 
}
