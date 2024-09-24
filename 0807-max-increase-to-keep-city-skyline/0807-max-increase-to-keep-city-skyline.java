class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] maxRow = new int[n];
        int[] maxCol = new int[m];
        for(int i =0  ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                maxRow[i] = Math.max(maxRow[i] , grid[i][j]);
                maxCol[j] = Math.max(maxCol[j] , grid[i][j]);
                
            }
        }
        int ans =0;
        for(int i =0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                ans = ans + (Math.min(maxRow[i],maxCol[j]) - grid[i][j]);
            }
        }
        return ans;
    }
}