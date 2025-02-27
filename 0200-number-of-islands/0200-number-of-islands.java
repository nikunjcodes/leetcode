class Solution {
    public int numIslands(char[][] grid) {
        int ans =0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]=='1'){
                    helper(grid , i , j);
                    ans++;
                }
            }
        }
        return ans;
    }
    void helper(char[][] grid , int i , int j ){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j] =='1'){
            grid[i][j] = '0';
            helper(grid , i+1 , j);
            helper(grid , i , j+1);
            helper(grid , i-1 , j);
            helper(grid , i , j-1);
        }
        else
            return;
    }
}