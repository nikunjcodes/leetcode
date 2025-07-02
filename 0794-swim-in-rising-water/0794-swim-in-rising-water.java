class Solution {
    class Pair{
        int row;
        int col;
        int diff;
        public Pair(int row , int col , int diff){
            this.row = row;
            this.col = col;
            this.diff = diff;
        }
    }
    public int swimInWater(int[][] grid) {
        int[][] dirs = new int[][] {{-1,0} , {0,-1} , {1,0} , {0,1}};
        int n = grid.length;
        int m = grid.length;
        boolean[][] vis = new boolean[n][m];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.diff - b.diff);
        pq.offer(new Pair(0,0,grid[0][0]));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int row = p.row;
            int col = p.col;
            int diff  = p.diff;
            if(row==n-1 && col == n-1)
                return diff;
            if(!vis[row][col]){
                vis[row][col]  = true;
                for(int[] dir : dirs){
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];
                    if(nRow >=0 && nCol >=0 && nRow <n && nCol < n && !vis[nRow][nCol]){
                        int ndiff = Math.max(grid[nRow][nCol] , diff);
                        pq.offer(new Pair(nRow , nCol , ndiff));                    }
                }
            }
        }
        return 0;
    }
}