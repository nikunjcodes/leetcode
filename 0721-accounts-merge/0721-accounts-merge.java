class Solution {
    Map<String , Integer> map = new HashMap<>();
    class DSU{
        int[] parent;
        DSU(int n ){
            parent = new int[n];
            for(int i=0 ; i<n ; i++){
                parent[i] = i;
            }
        }
        void union( int x , int y){
            int parX = find(x);
            int parY = find(y);
            if(parX!=parY)
                parent[parY] = parX;
        }
        int find(int x){
            if(parent[x]!=x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        List<List<String>> ans = new ArrayList<>();
        DSU dsu  = new DSU(n);
        for(int i=0 ; i<n ; i++){
            List<String> account = accounts.get(i);
            for(int j=1; j<account.size() ; j++){
                if(map.containsKey(account.get(j)))
                    dsu.union(map.get(account.get(j)) , i);
                else
                    map.put(account.get(j) , i);
            }
        }
        Map<Integer , Set<String>> grouped = new HashMap<>();
        for(String mail : map.keySet()){
            int root = dsu.find(map.get(mail));
            grouped.computeIfAbsent(root , k-> new TreeSet<>()).add(mail);
        }
    
        grouped.forEach((root, emails) -> {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(root).get(0)); 
            list.addAll(emails);
            ans.add(list);
        });

        return ans;
    }
}