class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int ans=0;
        for(int i=2 ; i<n ; i++){
            int left =0 ;
            int right = i-1;
            while(left < right){
                int sum = arr[left] + arr[right];
                if(sum > arr[i])
                    right--;
                else if (sum < arr[i])
                    left++;
                else{
                    dp[right][i] = dp[left][right] + 1;
                    ans = Math.max(dp[right][i]  , ans);
                    right--;
                    left++;
                }
            }
        }
        return ans==0 ? 0 : ans+2;
    }
}