class Solution {
    public int[][] updateMatrix(int[][] isWater) {
                int m = isWater.length;
        int n = isWater[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(isWater[i][j] ==0){
                    queue.offer(new int[]{i,j});
                    ans[i][j]=0;
                }
                else
                    ans[i][j]=-1;
            }
        }
        int[][] dir = {{-1,0} , {0,-1} , {1,0} , {0,1}};
        while(!queue.isEmpty()){
            int N = queue.size();
            while(N-->0){
                int[] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];
                for(int[] d : dir){
                    int i_ = i+d[0];
                    int j_ = j+d[1];
                    if(i_>=0 && i_<m && j_>=0 && j_<n && ans[i_][j_]==-1){
                        ans[i_][j_] = ans[i][j] +1;
                        queue.offer(new int[]{i_,j_});
                    }
                }
            }
        }
        return ans;
    }
}