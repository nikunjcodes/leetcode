class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        List<Integer> arr[] = new ArrayList[101];   

        for(int i=0;i<101;i++)
            arr[i] = new ArrayList<>();
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max = Math.max(max,grid.get(i).get(j));
                min = Math.min(min,grid.get(i).get(j));
                arr[grid.get(i).get(j)].add(i);
            }
        }

        Integer dp[][] = new Integer[101][(int)Math.pow(2,10) + 1];
        return helper(arr,max,min,0,dp);
    }

    private static int helper(List<Integer> arr[],int num,int min,int mask,Integer dp[][]){
        if(num < min)
            return 0;
        
        if(dp[num][mask] != null)
            return dp[num][mask];
        
        dp[num][mask] = 0;
        for(int r : arr[num]){
            if((mask&(1 << r))==0)
                dp[num][mask] = Math.max(dp[num][mask] , num + helper(arr,num-1,min,(mask|(1 << r)),dp));
        }

        dp[num][mask] = Math.max(dp[num][mask] , helper(arr,num-1,min,mask,dp));

        return dp[num][mask];
    }
}