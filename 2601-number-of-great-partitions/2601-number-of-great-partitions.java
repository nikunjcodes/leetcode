class Solution {
    public int countPartitions(int[] nums, int k) {
        long mod = (long)1e9 + 7;
        long tota=0;
        long res=1;
        long[] dp = new long[k];
        dp[0] =1;
        for(int num : nums){
            for(int i=k-num-1 ; i>=0 ; i--){
                dp[num + i] = (dp[num+i] + dp[i])%mod;
            }
            res = res*2 %mod;
            tota+=num;
        }
        for(int i=0 ; i<k; i++){
            res-= tota-i <k ? dp[i] : dp[i]*2;
        }
        return (int)((res%mod + mod)%mod);
    }
}