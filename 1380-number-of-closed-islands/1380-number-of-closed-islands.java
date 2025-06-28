class Solution {
    public int closedIsland(int[][] grid) {
        int ans=0;
        int m =grid.length;
        int n = grid[0].length;
    
        for(int i=0  ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j]==0 ){
                       ans+= helper(i , j , grid , m , n);
                            
                }
            }
        }
        return ans;
    }
    int helper(int i , int j , int[][] grid  , int m , int n){
        if(i<0 || i>=m || j<0 || j>=n)
            return 0;
        if(grid[i][j]==1)
            return 1;
        grid[i][j]=1;
        int temp = helper(i-1 , j  , grid , m , n) + helper(i , j+1  , grid , m , n) + helper(i+1 , j  , grid , m , n) + helper(i , j-1  , grid , m , n);
         if(temp==4)
            return 1;
        else 
            return 0;       
        
    }
}