class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,  int second){
            this.first = first;
            this.second = second;
        }
    }
    class Tuple{
        int first;
        int second;
        int third;
        public Tuple(int first ,int  second ,int third){
            this.first=  first;
            this.second = second;
            this.third = third;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0 ; i<n ; i++)
            adj.add(new ArrayList<>());
        for(int[] flight : flights){
            adj.get(flight[0]).add(new Pair(flight[1] , flight[2]));
        }
        Queue<Tuple> q =new LinkedList<>();
        q.offer(new Tuple(0,src,0));
        int[] dist = new int[n];
        Arrays.fill(dist ,Integer.MAX_VALUE);
        dist[src]=0;
        while(!q.isEmpty()){
            Tuple node = q.poll();
            int stops = node.first;
            int u  = node.second;
            int distt = node.third;
            if(stops >k)
                continue;
            for(Pair neigh : adj.get(u)){
                int adjNode = neigh.first;
                int distance = neigh.second;
            if(dist[adjNode] > distance  + distt){
                dist[adjNode] = distance + distt;
                q.offer(new Tuple(stops+1 , adjNode , dist[adjNode]));
            }

            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}