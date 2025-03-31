class Solution {
    public long putMarbles(int[] weights, int k) {
        long[] sum = new long[weights.length-1];
        long ans=0;
        for(int i=0 ; i<sum.length;  i++){
            sum[i] = weights[i] + weights[i+1];

        }
        Arrays.sort(sum);
        for(int i=0 ; i<k-1 ; i++)
            ans += sum[weights.length-2-i] - sum[i];
        return ans;
    }
}