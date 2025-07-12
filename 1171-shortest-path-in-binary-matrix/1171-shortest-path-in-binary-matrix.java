class Solution {
    class Node{
        int x;
        int y;
        public Node(int x , int y){
            this.x = x;
            this.y=y;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = new int[][] {{0,1} , {1,0} , {0,-1} , {-1,0} , {-1,-1} , {1,1} , {-1,1} , {1,-1}};
        int ans=0;
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
            return -1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        grid[0][0] = 1;
        while(!q.isEmpty()){
            ans++;
            int size= q.size();
            for(int i=0 ; i<size ; i++){
                Node node = q.poll();
                if(node.x == n-1 && node.y == n-1)
                    return ans;
                else{
                    for(int[] dir : dirs){
                        int newX = node.x + dir[0];
                        int newY = node.y  +dir[1];
                        if(newX >=0 && newX<n && newY>=0 && newY<n && grid[newX][newY]==0){
                            q.add(new Node(newX , newY));
                            grid[newX][newY] = 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}