class Solution {
    int[][] dir = {{0,-1} , {0,1} , {1,0} , {-1,0}};
    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        int col = heightMap[0].length;
        int total = rows*col;
        boolean[][] visited = new boolean[rows][col];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0] - b[0]));
        for(int i=0 ; i<rows ; i++){
            pq.offer(new int[]{heightMap[i][0], i , 0});
            pq.offer(new int[]{heightMap[i][col-1] , i , col-1});
            visited[i][0] = true;
            visited[i][col-1] = true;
            total-=2;
        }
        for(int i=1 ; i<col-1 ; i++){
            pq.offer(new int[]{heightMap[0][i] , 0 , i});
            pq.offer(new int[]{heightMap[rows-1][i] , rows-1 , i});
            visited[0][i] = true;
            visited[rows-1][i] = true;
            total-=2;

        }
        int ans= 0 ;
        int level =0;
        while(!pq.isEmpty() && total >0){
            int[] curr = pq.poll();
            int currH = curr[0];
            int currR = curr[1];
            int currC = curr[2];
            level = Math.max(level , currH);
            for(int i=0 ; i<4 ; i++){
                int nR = currR + dir[i][0];
                int nC = currC + dir[i][1];
            
            if(nR >=0 && nC >=0 && nR <rows && nC <col && !visited[nR][nC]){
                int nH = heightMap[nR][nC];
                if(nH <level)
                    ans+=level - nH;
                pq.offer(new int[]{nH , nR , nC });
                visited[nR][nC] = true;
                total--;
            }
            }
        }
        return ans;
    }
}