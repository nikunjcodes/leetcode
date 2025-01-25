class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] sorted = Arrays.copyOf(nums , nums.length);
        Arrays.sort(sorted);
        UnionFind uf = new UnionFind(sorted);
        for(int i=1 ; i<sorted.length ; i++){
            if(sorted[i] - sorted[i-1] <=limit)
                uf.union(sorted[i]  , sorted[i-1]);
        }
        Map<Integer , Queue<Integer>> gMap = new HashMap<>();
        for(int num  : sorted){
            int root = uf.find(num);
            gMap.putIfAbsent(root , new LinkedList<>());
            gMap.get(root).offer(num);
        }

        int[] ans = new int[nums.length];
        for(int i=0 ; i<nums.length ; i++){
            int root = uf.find(nums[i]);
            ans[i]= gMap.get(root).poll(); 
        }
        return ans;
    }
}
class UnionFind{
    private Map<Integer , Integer> parent;
    public UnionFind(int[] nums){
        parent = new HashMap<>();
        for(int num : nums)
            parent.put(num , num);
    }
    public int find(int x ){
        if(parent.get(x)!=x)
            parent.put(x,  find(parent.get(x)));
        return parent.get(x);
    }
    public void union(int x,  int y){
        int rX = find(x);
        int rY = find(y);
        if(rX!=rY)
            parent.put(rY,rX);
    }
}