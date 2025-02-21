class Solution {
        int[][] dirs = {{1,1},{1,0},{0,1},{1,-1},{-1,1},{-1,0},{0,-1},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> map = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        if(grid[0][0]==1)
            return -1;
        map.offer(new int[] {0,0,1});
        while(!map.isEmpty()){
            int[] pos = map.poll();
            int r = pos[0];
            int c = pos[1];
            int len = pos[2];
            if(r==row-1 && c==col-1)
                return len;
            for(int[] dir : dirs){
                int newR = r+dir[0];
                int newC = c + dir[1];
                if(newR<row && newR>=0 && newC<col && newC>=0 && grid[newR][newC]==0){
                    map.offer(new int[] {newR, newC , len+1});
                    grid[newR][newC]= 1;
                }
            }
        }
        return -1;
    }
}