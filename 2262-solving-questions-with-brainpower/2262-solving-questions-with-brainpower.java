class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp,-1);
        return helper(0,dp,questions);
    }
    public long helper(int idx , long[] dp , int[][] questions){
        if(idx >=questions.length)
            return 0;
        if(dp[idx]!=-1l)
            return dp[idx];
        long ans = questions[idx][0] + helper(idx + questions[idx][1] + 1 , dp , questions);
        long notans = helper(idx+1 , dp , questions);
        dp[idx]= Math.max(ans , notans);
        return dp[idx];
    }
}