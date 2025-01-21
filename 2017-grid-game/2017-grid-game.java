class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] p1 =  new long[n];
        long[] p2 = new long[n];
        p1[0] = grid[0][0];
        p2[0] = grid[1][0];
        for(int i=1 ; i<n ; i++){
            p1[i]=grid[0][i] + p1[i-1] ;
            p2[i]=grid[1][i] + p2[i-1];
        }
        long ans =Long.MAX_VALUE;
        for(int i=0 ; i<n ; i++){
            long bottom = (i>0)? p2[i-1] : 0;
           long temp = Math.max(p1[n-1] - p1[i],bottom);
           ans = Math.min(ans , temp);
        }
        return ans;
    }
}