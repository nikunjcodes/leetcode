class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        Arrays.fill(dp , -1);
        int ans = helper(coins , amount);
        return ans == Integer.MAX_VALUE ? -1  : ans;
    }
    int helper(int[] coins , int amount ){
        if(amount<0)
            return Integer.MAX_VALUE;
        if(amount==0)
            return 0;
        if(dp[amount]!=-1)
            return dp[amount];
        int minCoins = Integer.MAX_VALUE;
        for(int i=0 ; i<coins.length ; i++){
            int temp = helper(coins , amount-coins[i]);
            if(temp!=Integer.MAX_VALUE)
                minCoins = Math.min(temp+1 , minCoins);
        }
        return dp[amount] = minCoins;
    }
}