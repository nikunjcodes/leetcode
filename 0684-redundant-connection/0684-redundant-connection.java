class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] nodes = new int[2001];
        for(int i=0  ; i<nodes.length ; i++)
            nodes[i] =i;
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            if(find(from,nodes) == find(to,nodes))
                return edge;
            union(from , to , nodes);
        }
        return null;
    }
    int find(int node , int[] nodes){
        while(node!=nodes[node])
            node = nodes[node];
        return node;
    }
    void union(int a , int b , int[] nodes){
        int root1 = find(a,nodes);
        int root2=  find(b,nodes);
        if(root1 == root2)
            return;
        nodes[root1] = root2;
    }
}