class Solution {
    class Pair{
        int v;
        int wt;
        public Pair(int  v , int wt){
            this.v = v;
            this.wt = wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0 ; i< n ; i++)
            adj.add(new ArrayList<>());
        for(int[] time : times){
            int u = time[0];
            int v= time[1];
            int wt = time[2];
            Pair p  = new Pair(v ,wt);
            adj.get(u-1).add(p);
        }
        int[] wt= new int[n];
        Arrays.fill(wt , Integer.MAX_VALUE);
        wt[k-1]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a-> a[1]));
        pq.offer(new int[] {k,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int source = curr[0];
            int cost = curr[1];
            for(Pair p  : adj.get(source-1)){
                int v = p.v;
                int wgt = p.wt;
                if(wt[v-1] > wgt + cost){
                    wt[v-1] = wgt  + cost;
                    pq.offer(new int[] {v , wt[v-1]});
                }
            }
        }
        int ans=0;
        for(int i=0 ; i<n ; i++){
            if(wt[i]==Integer.MAX_VALUE)
                return -1;
            else
                ans=Math.max(ans , wt[i]);
        }
        return ans;
    }
}