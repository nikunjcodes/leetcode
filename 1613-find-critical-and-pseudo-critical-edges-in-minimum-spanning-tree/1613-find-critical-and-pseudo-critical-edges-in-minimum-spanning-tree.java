class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int len =edges.length;
        int[][] graph= new int[len][4];
        for(int i=0 ; i<len  ; i++){
            graph[i] = new int[]{edges[i][0]  , edges[i][1] , edges[i][2] , i};
        }
        Arrays.sort(graph , (a,b)->(a[2] - b[2]));
        int min = helper(graph , n , -1 , -1);
        List<Integer> crit = new ArrayList<>();
        List<Integer> pse = new ArrayList<>();
        for(int i=0 ; i<len ; i++){
            if(min < helper(graph , n , i , -1))
                crit.add(graph[i][3]);
            else if(min == helper(graph , n , -1 , i))
                pse.add(graph[i][3]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(crit);
        ans.add(pse);
        return ans;
    }
    int helper(int[][] edges , int n  , int skip ,  int add){
        int ans=0;
        DSU dsu = new DSU(n);
        if(add!=-1){
            int[] edge = edges[add];
            dsu.union(edge[0] , edge[1]);
            ans+=edge[2];
        }
        for(int i=0 ; i<edges.length ; i++){
            if(i==skip)
                continue;
            int[] edge = edges[i];
            int p1 = dsu.find(edge[0]);
            int p2 = dsu.find(edge[1]);
            if(p1!=p2){
                dsu.union(edge[0] , edge[1]);
                ans+=edge[2];
            }
        }
        if(dsu.count!=1)
            return (int) 1e9;
        return ans;
    }

}
class DSU{
    int[] rank , parent;
    int count;
    public DSU(int n){
        rank = new int[n];
        parent = new int[n];
        count=n;
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
    void union(int x , int y){
        int xr = find(x);
        int yr = find(y);
        if(xr ==yr)
            return;
        if(rank[xr] > rank[yr]){
            parent[yr]  =xr;
        }
        else   if(rank[yr] > rank[xr]){
            parent[xr]  =yr;
        }
        else{
            parent[yr] = xr;
            rank[xr]+=rank[yr];
        }
        count--;
    }
}