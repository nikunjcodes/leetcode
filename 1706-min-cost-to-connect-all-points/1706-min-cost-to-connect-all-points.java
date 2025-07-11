class Solution {
    class DSU{
        int[] parent , rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0 ; i<n ; i++){
                rank[i] = 1;
                parent[i] = i;
            }
        }
        int find(int x){
            if(x!=parent[x])
                parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int x , int y){
            int xr = find(x);
            int yr = find(y);
            if(xr==yr)
                return false;
            if(rank[xr] < rank[yr]){
                parent[xr] = yr;
            }
            else if(rank[xr] > rank[yr])
                parent[yr] = xr;
            else{
                parent[yr] = xr;
                rank[xr]++;
            }
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int ans=0;
        int n =points.length;
        List<int[]> edges = new ArrayList<>();
        for(int i=0 ; i<points.length ; i++){
            for(int j=i+1 ; j<points.length ; j++){
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i,j,cost});
            }
        }
        edges.sort(Comparator.comparingInt(a-> a[2]));
        DSU dsu = new DSU(n);
        int count=0;
        for(int[] edge  :edges){
            if(dsu.union(edge[0]  , edge[1])){
                count++;
                ans+=edge[2];
                if(count==n-1)
                    break;
            }
        }
        return ans;
    }
}