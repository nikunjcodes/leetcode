class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for(int i=0 ; i<n ; i++){
            if(colors[i] == 0 ){
                if (dfs(i , 1 ,colors , graph) == false) return false;
        }
        }
        return true;
    }
    boolean dfs(int node, int color , int[] colors , int[][]graph){
        if(colors[node]!=0)
            return colors[node] == color;
        colors[node] = color;
        for(int nod : graph[node]){
            if(!dfs(nod , -color , colors , graph))
                return false;
        }
        return true;
    }
}