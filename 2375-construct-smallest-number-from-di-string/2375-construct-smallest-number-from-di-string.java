class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder ans = new StringBuilder();
        int n = pattern.length();
        int[] st = new int[n+1];
        int idx=0;
        for(int i=0 ; i<=n ; i++){
            st[idx++] = i+1;
            if(i==n || pattern.charAt(i)=='I'){
                while(idx>0)
                    ans.append(st[--idx]);
            }
        }
        return ans.toString();
    }
}