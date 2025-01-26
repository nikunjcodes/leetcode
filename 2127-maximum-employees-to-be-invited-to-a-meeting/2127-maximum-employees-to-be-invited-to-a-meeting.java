class Solution {
    public int maximumInvitations(int[] favorite) {
        int max=0;
        int maxc=0;
        int n = favorite.length;
        List[] graph = new List[n];
        List<Integer> pairs = new ArrayList<>();
        boolean[] flag = new boolean[n];
        for(int i=0 ; i<n ;i++)
            graph[i] = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            if(flag[i])
                continue;
            if(i==favorite[favorite[i]]){
                pairs.add(i);
                flag[favorite[i]] = true;
            }
            else
                graph[favorite[i]].add(i);
        }
        for(int pair : pairs){
            max+=helper(graph , pair , flag) + helper(graph , favorite[pair] , flag);
        }
        int[] curr = new int[n];
        int[] round = new int[n];
        int currR = 1; 
        for(int i=0 ; i<n ; i++){
            if(flag[i])
                continue;
            if(round[i]!=0)
                continue;
            int tracker = 1;
            int cur = i;
            while(curr[cur]==0){
                round[cur] = currR;
                curr[cur] = tracker++;
                cur = favorite[cur];
            }
            if(round[cur]== currR)
                maxc = Math.max(maxc , tracker - curr[cur]);
            currR++;
            
        }
        return Math.max(maxc , max);
    }
    private int helper(List[] graph , int node , boolean[] visited){
        visited[node] = true;
        int max =0;
        for(int neighbour : (List<Integer>)graph[node])
            max  = Math.max(max , helper(graph , neighbour , visited));
        return max+1;
    }
}