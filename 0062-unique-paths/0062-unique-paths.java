class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1)
            return 1;
        int[][] dp = new int[n][m];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(i==0)
                    dp[0][j]=1;
                if(j==0)
                    dp[i][0]=1;
                if(i!=0 && j!=0){
                    int u = dp[i-1][j];
                    int l = dp[i][j-1];
                    dp[i][j] = u+l;
                }
            }
        }
        return dp[n-1][m-1];
    }
}