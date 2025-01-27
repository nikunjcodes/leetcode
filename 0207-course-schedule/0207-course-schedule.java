class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new List[n];
        int[] deg = new int[n];
        List<Integer> ans = new ArrayList<>();
        for(int[] p : prerequisites){
            int c = p[0];
            int pre = p[1];
            if(adj[pre]==null)
                adj[pre] = new ArrayList<>();
            adj[pre].add(c);
            deg[c]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<n ; i++){
            if(deg[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();
            ans.add(curr);
            if(adj[curr]!=null){
                for(int next : adj[curr]){
                    deg[next]--;
                    if(deg[next]==0)
                        queue.offer(next);
                }
            }
        }
        return ans.size()==n;
    }
}