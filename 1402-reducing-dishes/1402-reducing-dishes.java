class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int suffix=0;
        int curr=0,ans=0;
        for(int i=satisfaction.length-1 ; i>=0 ; i--){
            suffix+=satisfaction[i];
            curr+=suffix;
            ans=Math.max(ans,curr);
        }
        return ans;
    }
}