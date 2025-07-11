class Solution {
    class DSU{
        int[] parent;
        public DSU(int n ){
            parent = new int[n+1];
            for(int i=0 ; i<=n ; i++){
                parent[i] = i;
            }
        }
        int find(int x){
            if(parent[x]!=x)
                parent[x] = find(parent[x]);
            return parent[x];

        }
        boolean union(int x , int y){
            int xr = find(x);
            int yr = find(y);
            if(xr==yr)
                return false;
            parent[yr] = xr;
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);
        for(int[] edge : edges){
            int to = edge[1];
            int from = edge[0];
            if(!dsu.union(to,from))
                return edge;
        }
        return edges[0];
    }
}