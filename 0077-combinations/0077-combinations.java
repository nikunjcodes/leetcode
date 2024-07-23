class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(ans,temp ,1, n ,k);
        return ans;
    }
    static void helper(List<List<Integer>> ans , List<Integer> temp, int i , int n , int k){
        if(k==0){
            ans.add(new ArrayList<>(temp));
                return;
        }
        for(int j=i; j<=n ; j++){
            temp.add(j);
            helper(ans,temp,j+1, n , k-1);
            temp.remove(temp.size()-1);
        }
    }
}