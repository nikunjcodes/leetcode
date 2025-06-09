class Solution {
    int[] dp;
    public int rob(int[] nums) {
     dp = new int[nums.length];
        Arrays.fill(dp , -1);
        return helper(nums , nums.length-1 );
    }
    int helper(int[] nums   , int idx){
        if(idx<0)
            return 0;
        if(idx==0)
            return nums[0];
        if(dp[idx]!=-1)
            return dp[idx];
        int pick = nums[idx] + helper(nums , idx-2);
        int notPick = helper(nums , idx-1);
        dp[idx] = Math.max(pick , notPick);
        return dp[idx];
    }
}