class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] onesR = new int[n];
        int[] onesC = new int[m];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]==1){
                    onesR[i]++;
                    onesC[j]++;
                }
            }
        }
        for(int i=0 ; i<n ; i++){
            for(int j=0  ; j<m ; j++){
                grid[i][j] = onesR[i]  + onesC[j] - (n - onesR[i]) - (m-onesC[j]) ;
            }
        }
        return grid;
    }
}