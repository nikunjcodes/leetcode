class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] ans = new int[k][k];
        int[] row = helper( k , rowConditions);
        int[] col = helper(k , colConditions);
        if(row ==null || col==null)
            return new int[0][0];
        int[] rowPos = new int[k+1];
        int[] colPos = new int[k+1];
        for(int i=0 ; i<k  ; i++){
            rowPos[row[i]]=i;
            colPos[col[i]]=i;
        }
        for(int i=1 ; i<=k ; i++){
            int r = rowPos[i];
            int c = colPos[i];
            ans[r][c] = i;
        }
        return ans;
    }
    int[] helper(int k , int[][] conditions){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<=k ; i++)
            adj.add(new ArrayList<>());
        for(int[] cond : conditions){
            adj.get(cond[0]).add(cond[1]);
        }
        int[] vis =new int[k+1];
        Stack<Integer> st = new Stack<>();
        for(int i=1 ; i<=k ; i++){
            if(vis[i]==0){
                if(!dfs(i , adj , vis , st))
                    return null;
            }
        

    }
    int[] ans = new int[k];
    int idx=0;
    while(!st.isEmpty()){
        ans[idx++] = st.pop();
    }
    return ans;
}
boolean dfs(int node , List<List<Integer>> adj , int[] vis ,Stack<Integer> st){
    vis[node]=1;
    for(int neigh : adj.get(node)){
        if(vis[neigh]==1)
            return false;
        if(vis[neigh]==0){
            if(!dfs(neigh , adj , vis , st))
                return false;
        }
    }
    vis[node]=2;
    st.push(node);
    return true;
}
}