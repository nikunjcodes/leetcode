class Solution {
    class DSU{
        int[] parent;
        int[] size;
        public DSU(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0 ; i<n ; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int x){
            if(x!=parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];

        }
        public void union(int x , int y){
            int xr = find(x);
            int yr = find(y);
            if(xr==yr)
                return;
            if(size[xr] >=size[yr]){
                parent[yr] = xr;
                size[xr] += size[yr];
            }
            else{
                parent[xr] = yr;
                size[yr] += size[xr];
            }
        }
        int getSizeOfRoot(int root){
            return size[root];
        }
    }
    boolean isValid(int i ,int j , int n){
        if(i>=0 && j>=0 && i<n && j<n)
            return true;
        return false;
    }
    int getCell(int i , int j , int n){
         return n*i + j;
    }
    public int largestIsland(int[][] grid) {
        int[][] dirs = new int[][]{{0,1} , {1,0}  , {-1,0} ,  {0,-1}};
        int n = grid.length;
        DSU dsu = new DSU(n*n);
        for(int i=0 ; i<n  ; i++){
            for(int j=0 ; j<n ; j++){
            if(grid[i][j]==1){
                int curr = getCell(i ,  j , n);
                for(int[] dir : dirs){
                    int newX = i + dir[0];
                    int newY  = j+ dir[1];
                    if(isValid(newX , newY , n)&& grid[newX][newY] ==1){
                        dsu.union(curr , getCell(newX , newY  ,n));
                    }
                }
            }
            }
        }
        boolean hasZero = false;
        int ans=0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j]==0){
                    hasZero = true;
                    Set<Integer> vis =new HashSet<>();
                    int temp=1;
                    for(int[] dir :  dirs){
                        int newX = dir[0] + i;
                        int newY = dir[1] + j;
                        if(isValid(newX, newY,n) && grid[newX][newY]==1){
                            int root = dsu.find(getCell(newX , newY , n));
                            if(vis.add(root))
                                temp+=dsu.getSizeOfRoot(root);
                        }
                    }
                 ans = Math.max(temp  ,ans);

                }
            }
        }
        if(!hasZero)
            return n*n;
        return ans;
    }
}