class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = {{1,0} , {0,1} , {-1,0} , {0,-1}};
        if(grid ==null || grid.length ==0)
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh=0;
        for(int i=0 ; i<n  ; i++){
            for(int j =0; j<m ; j++){
                if(grid[i][j]==2)
                    q.offer(new int[] {i,j});
                else if (grid[i][j]==1)
                    fresh++;
            }
        }
        if(fresh==0)
            return 0;
        int cnt =0 ;
        while(!q.isEmpty()){
            cnt++;
            int size = q.size();
            for(int i=0 ; i<size ; i++){
                int[] rot = q.poll();
                for(int[] dir : dirs){
                    int  x = rot[0] + dir[0];
                    int y = rot[1] + dir[1];
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1){
                        grid[x][y]=2;
                        q.offer(new int[] {x,y});
                        fresh--;
                    }
                    else
                        continue;
                }
            }
  
        }
                  if(fresh==0)
                return cnt-1;
            return -1;
    }
}