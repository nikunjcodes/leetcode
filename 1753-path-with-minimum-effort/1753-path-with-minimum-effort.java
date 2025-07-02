class Solution {
    class Pair{
        int row;
        int col;
        int diff;
        public Pair(int row , int col, int diff){
            this.row = row;
            this.col = col;
            this.diff=  diff;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = new int[][] {{-1,0} , {0,-1} , {1,0} , {0,1}};
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] vis = new boolean[heights.length][heights[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.diff- b.diff);
        pq.offer(new Pair(0,0,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int row = p.row;
            int col = p.col;
            int abs  = p.diff;
            if(row==n-1 && col == m-1)
                return abs;
            if(!vis[row][col]){
                vis[row][col] = true;
            for(int[] dir : dirs){
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                if(nRow >=0 && nCol >=0 && nRow < n && nCol < m && !vis[nRow][nCol]){
                    int diff = Math.abs(heights[row][col] - heights[nRow][nCol]);
                    int nweE = Math.max(diff , abs);
                    pq.add(new Pair(nRow , nCol , nweE));

                }
            }
            }
        }
        return 0;

    }
}