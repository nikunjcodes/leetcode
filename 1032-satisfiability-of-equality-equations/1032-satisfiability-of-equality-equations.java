class Solution {
    int[] parent = new int[26];
    
    public boolean equationsPossible(String[] equations) {
        for(int i=0; i<26 ; i++)
        parent[i] = i;
        for(String equation : equations){
            if(equation.charAt(1)=='=')
                union(equation.charAt(0)-'a' , equation.charAt(3)-'a');
        }
        for(String equation  : equations){
            if(equation.charAt(1)=='!')
            {
                int x = find(equation.charAt(0)-'a');
                int y=  find(equation.charAt(3)-'a');
                if(x==y)
                    return false;
            
        }
        }
        return true;
    }
    public int find(int x){
        if(parent[x]!=x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x , int y){
        int xr = find(x);
        int yr = find(y);
        if(xr!=yr)
            parent[yr] = xr;
    }
}