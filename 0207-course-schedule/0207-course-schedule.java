class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0 ; i<prerequisites.length;  i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] ind = new int[numCourses];
        for(int i=0 ; i<numCourses ; i++){
            for(int node : adj.get(i))
                ind[node]++;
        }
        Queue<Integer> q=  new LinkedList<>();
        for(int i=0 ; i<ind.length;  i++){
            if(ind[i]==0)  
                q.add(i);
        }
        List<Integer> ts = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ts.add(node);
            for(int nbr : adj.get(node)){
                ind[nbr]--;
                if(ind[nbr]==0)
                    q.add(nbr);
            }
        }
        return ts.size()== numCourses ? true : false;
    }
}