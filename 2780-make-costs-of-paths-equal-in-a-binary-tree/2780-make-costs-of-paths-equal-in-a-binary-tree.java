class Solution {
    int ans=0;
    int i=0;
    public int minIncrements(int n, int[] cost) {
        helper( i , n , cost);
        return ans;
    }
    int helper(int i , int n , int[] cost){
        if(i >=n)
            return 0;
        int left = helper( 2*i+1 , n , cost);
        int right = helper( 2*i+2 , n  , cost);
        if(left!=right){
            ans+=Math.abs(left-right);
        }
        return cost[i] + Math.max(left ,right);
    }
}