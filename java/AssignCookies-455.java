class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i=0,j=0;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        // 从小到大满足小朋友
        while(i<g.length && j<s.length){
            // 如果饼干的大小 大于 小朋友的期望值,则count加1
	    // 饼干和小朋友自增
            if(g[i]<=s[j]){
                count++;
                i++;
                j++;
            }else{
	    // 如果饼干大小 不满足 小朋友的期望值,则饼干增大
                j++;
            }
        }
        return count;
    }
}
