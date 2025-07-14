class Solution {
    class Pair{
        int x;
        int y;
        int diff;
        public Pair(int x , int y, int diff){
            this.x = x;
            this.y = y;
            this.diff = diff;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = new int[][] {{1,0} , {0,1} , {-1,0}  , {0,-1}};
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] vis = new boolean[rows][cols];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.diff - b.diff);
        pq.offer(new Pair(0,0,0));
        vis[0][0] = true;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int x = p.x;
            int y = p.y;
            int diff = p.diff;
            vis[x][y] = true;
            if(x==rows-1 && y==cols-1)
                return diff;
            for(int[] dir : dirs){
                int newX = x+dir[0];
                int newY = y+dir[1];
                if(newX >=0 && newY >=0 && newX<rows && newY<cols && !vis[newX][newY]){
                    int eff =Math.abs(heights[newX][newY] - heights[x][y]);
                    eff  = Math.max(eff , diff);
                    pq.offer(new Pair(newX , newY , eff));
                }
            }
        }
        return 0;

    }
}