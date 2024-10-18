class Solution {
    public String sortSentence(String s) {
        String[] ci = s.split(" ");
        int length = ci.length;
        Map<Integer,String> map = new HashMap<>();
        for(int i=0;i<length;i++){
            int l = ci[i].length();
            map.put(Integer.parseInt(ci[i].substring(l-1)),ci[i].substring(0,l-1));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;i++){
            sb.append(map.get(i+1));
            if(i!=length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
