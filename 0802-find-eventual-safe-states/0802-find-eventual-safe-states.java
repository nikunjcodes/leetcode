class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<Integer>();
        int[] visited = new int[graph.length];
        for(int i=0 ; i<graph.length ; i++){
            if(helper(i,graph , visited))
                ans.add(i);
        }
        return ans;
    }
    boolean helper(int i , int[][]graph , int[] visited){
        if(visited[i] ==2)
            return true;
        if(visited[i] ==1)
            return false;
        visited[i] = 1;
        int[] nodes = graph[i];
        for(int node : nodes){
            if(!helper(node , graph , visited))
                return false;
        }
        visited[i] = 2;
        return true;
    }
}