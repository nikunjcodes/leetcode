class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items  , (a,b)-> (a[0] - b[0]));
        for(int i=1 ; i<items.length ; i++)
            items[i][1] = Math.max(items[i][1], items[i-1][1]);
        for(int i=0 ; i<queries.length ; i++)
            queries[i] = helper(items , queries[i]);
        return queries;    
    }
    int helper(int[][] items , int tar){
        int left =0 ;
        int right = items.length-1;
        int ans=0;
        while(left  <=right){
            int mid  = (right-left)/2 + left;
            if(items[mid][0] <= tar){
                left = mid+1;
                ans = items[mid][1];
            }
            else
                right  = mid-1;
        }
        return ans;
    }
}