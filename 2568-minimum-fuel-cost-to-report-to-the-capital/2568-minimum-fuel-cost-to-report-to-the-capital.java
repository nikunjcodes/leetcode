class Solution {
    long ans;
    int s;
    public long minimumFuelCost(int[][] roads, int seats) {
        ans=0;
        s=seats;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i<=roads.length ; i++)
            graph.add(new ArrayList<>());
        for(int[] edge : roads){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0,0,graph);
        return ans;
    }
    int dfs(int i , int prev , List<List<Integer>> graph){
        int people=1;
        for(int neigh : graph.get(i)){
        if(neigh==prev)
                continue;
            people+=dfs(neigh , i , graph);
        }
        if(i!=0)
            ans +=(people+s -1)/s;
        return people;

    }
}
