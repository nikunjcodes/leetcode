class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] minTime = new int[n][m];
        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){
                minTime[i][j] = Integer.MAX_VALUE;
            }
        }


        PriorityQueue<int[]> pq = new PriorityQueue(new PQComparator());

        pq.add(new int[]{0,0,0,1});
        minTime[0][0] = 0;

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currenti= current[1];
            int currentj = current[2];
            int time = current[0];
            int steps = current[3];

            List<int[]> adjC = getAdjacent(current, n, m);

            for(int[] ajd : adjC){
                int adji= ajd[0];
                int adjj = ajd[1];
                
                int timeForAdj = steps + Math.max(time, moveTime[adji][adjj]);

                int newSteps = steps == 1 ? 2: 1;
                if(timeForAdj <
                 minTime[adji][adjj]){
                    minTime[adji][adjj] = timeForAdj;
                    pq.offer(new int[]{minTime[adji][adjj],adji,adjj,newSteps});
                }
            }

        }

        return minTime[n-1][m-1];
        
    }


    public List<int[]> getAdjacent(int[] current, int n, int m){
        int i= current[1];
        int j = current[2];

        List<int[]> ajd = new ArrayList();

       if(j-1>=0 ){
            ajd.add(new int[]{i,j-1});
        }


        if(j+1 <= m-1 ){
            ajd.add(new int[]{i,j+1});
        }

       if(i-1>=0 ){
            ajd.add(new int[]{i-1,j});
        }

        if(i+1 <= n-1 ){
            ajd.add(new int[]{i+1,j});
        }

        return ajd;
    }
}


class PQComparator implements Comparator<int[]>{

  @Override
  public int compare(int[] a, int[] b){
    return Integer.compare(a[0],b[0]);
  }
}






