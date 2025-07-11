class Solution {
    public int numSimilarGroups(String[] strs) {
        int ans=0;
        for(int i=0 ; i<strs.length ; i++){
            if(strs[i]!=null){
                ans++;
                dfs(i , strs);
            }
        }
        return ans;
    }
    void dfs(int i , String[] strs){
        String s =strs[i];
        strs[i] = null;
        for(int j=0 ; j<strs.length ; j++){
            if(j==i)
                continue;
            if(strs[j]!=null && helper(s , strs[j]))
                dfs( j , strs);
        }
    }
    boolean helper(String s1 , String s2){
        int diff=0;
        for(int i=0 ; i<s1.length() ; i++){
            if(s1.charAt(i)!=s2.charAt(i))
                diff++;
            if(diff>2)
                return false;
        }
        return true;
    }
}