class Solution  {
    Integer[][] dp;
    public int largestPathValue(String s, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = s.length();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
        }
        dp = new Integer[n][];

        int max = 0;
        boolean[] set = new boolean[n];
        for(int i=0; i<n; i++){
            Integer[] ans = dfs(adj, s, set, i);
            if(ans.length == 1) return -1;
        }

        for(int i=0; i<n; i++){
            if(dp[i] != null){
                for(int j=0; j<26; j++){
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    Integer[] dfs(List<List<Integer>> adj, String s, boolean[] set, int node){
        if(dp[node] != null){
            return dp[node];
        }
        dp[node] = new Integer[26];
        Arrays.fill(dp[node], 0);
        set[node] = true;
        for(int it : adj.get(node)){
            if(set[it]){
                return new Integer[]{-1};
            }else{
                Integer[] x = dfs(adj, s, set, it);
                if(x.length == 1) return x;
                for(int j=0; j<26; j++){
                    dp[node][j] = Math.max(dp[node][j], x[j]);
                }
            }
        }
        set[node] = false;
        dp[node][s.charAt(node) - 'a']++;
        return dp[node];
    }
}