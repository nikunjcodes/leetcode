class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }
    public int findpar(int n){
        if(n==parent.get(n)) return n;
        int ulp = findpar(parent.get(n));
        parent.set(n,ulp);
        return parent.get(n);
    }
    public void unionByRank(int u, int v) {
        int ulp_u = findpar(u);
        int ulp_v = findpar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }
    public void unionBySize(int u, int v) {
        int ulp_u = findpar(u);
        int ulp_v = findpar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    private boolean isvalid(int row, int col,int n){
        if(row>=0&&row<n &&col>=0&&col<n)return true;
        return false;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n); 
        for(int row=0;row<n;row++){
            for(int col = 0;col<n;col++){
                if(grid[row][col]==0)continue;
                int [] dr ={-1,0,1,0};
                int [] dc = {0,1,0,-1};
                for(int i=0;i<4;i++){
                    int newr = row+dr[i];
                    int newc = col + dc[i];
                    if(isvalid(newr,newc,n)&&grid[newr][newc]==1){
                        int nodeno= row*n+col;
                        int adjnode = newr*n+newc;
                        ds.unionBySize(nodeno,adjnode);
                    }
                } 
            }
        }
        int maxi=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1)continue;
                int [] dr ={-1,0,1,0};
                int [] dc = {0,1,0,-1};
                HashSet<Integer> hs = new HashSet<>();
                for(int i=0;i<4;i++){
                    int newr = row+dr[i];
                    int newc = col + dc[i];
                    if(isvalid(newr,newc,n)){
                        if(grid[newr][newc]==1){
                            hs.add(ds.findpar(newr*n+newc));
                        }
                    }
                }
                int totsize=0;
                for(int item: hs){
                    totsize+=ds.size.get(item);
                }
                maxi=Math.max(totsize+1,maxi);
            }
        }
        for(int cell =0;cell<n*n;cell++){
            maxi = Math.max(maxi,ds.size.get(ds.findpar(cell)));
        }
        return maxi;
    }
}