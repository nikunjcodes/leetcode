class Solution {
    int[] dir = {0,1,0,-1,0};
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans =0 ;
         for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]>0)
                    ans=  Math.max(ans , dfs(i,j,grid,n,m));
            }
         }
         return ans;
    }
    int dfs(int i , int j , int[][] grid , int n , int m ){
        int fish = grid[i][j];
        grid[i][j]=0;
        for(int k=0 ; k<4 ; k++){
            int nr = i+dir[k];
            int nc = j+dir[k+1];
            if(nr<n && nr>=0 && nc<m && nc>=0 && grid[nr][nc]>0)
                fish+=dfs(nr,nc,grid,n,m);
        }
        return fish;
    }

}