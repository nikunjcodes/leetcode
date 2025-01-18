class Solution {
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int minCost(int[][] grid) {
        int m = grid.length , n=grid[0].length , cost=0;
        int[][] dp = new int[m][n];
        for(int i=0 ; i<m ; i++)
            Arrays.fill(dp[i] , Integer.MAX_VALUE);
        Queue<int[]> bfs = new LinkedList<>();
        dfs(grid , 0 ,0 ,dp ,  cost , bfs);
        while(!bfs.isEmpty()){
            cost ++;
            for(int size = bfs.size() ; size>0 ; size--){
                int[] top = bfs.poll();
                int r= top[0];
                int c = top[1];
                for(int i=0 ; i<4 ; i++){
                    dfs(grid , r+dir[i][0] , c+dir[i][1] , dp , cost , bfs);
                }
            }
        }
                    return dp[m-1][n-1];

    }
    void dfs(int[][] grid , int r , int c , int[][]dp , int cost , Queue<int[]> bfs){
        int m= grid.length ;
        int n = grid[0].length;
        if(r<0 || r>=m || c<0 || c>=n || dp[r][c]!=Integer.MAX_VALUE)
            return;
        dp[r][c] = cost;
        bfs.offer(new int[]{r,c});
        int next = grid[r][c]-1;
        dfs(grid , r + dir[next][0] , c + dir[next][1] , dp , cost , bfs);
    }
}