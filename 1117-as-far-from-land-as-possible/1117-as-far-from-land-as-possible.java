class Solution {
    class Pair{
        int x;
        int y;
        public Pair(int x , int y){
            this.x = x;
            this.y =y;
        }
    }
    public int maxDistance(int[][] grid) {
        int[][] dirs = new int[][] {{0,1} , {1,0} , {-1,0} , {0,-1}};
        int n = grid.length;
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0 ; i<n  ;i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j]==1)
                    queue.offer(new Pair(i,j));
            }
        }
        if(queue.size()==n*n)
            return -1;
            int dist=0;
        while(!queue.isEmpty()){
                dist++;
                int size = queue.size();
                for(int i=0 ; i<size ; i++){
                    Pair curr = queue.poll();
                    for(int[] dir : dirs){
                        int newX = curr.x + dir[0];
                        int newY = curr.y + dir[1];
                        if(newX >=0 && newY >=0 && newX<n && newY<n && grid[newX][newY]==0){
                            grid[newX][newY]=1;
                            queue.offer(new Pair(newX , newY));
                        }
                    }
                }
        }
        return dist-1;
    }
}