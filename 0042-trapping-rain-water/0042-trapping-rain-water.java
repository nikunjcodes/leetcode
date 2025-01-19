class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = height[0];
        for(int i=1 ; i<n ; i++)
            prefixMax[i] = Math.max(height[i] , prefixMax[i-1]);
        suffixMax[n-1] = height[n-1];
        for(int i= n-2 ; i>=0 ; i--)
            suffixMax[i] = Math.max(height[i] , suffixMax[i+1]);
        int ans=0;
        for(int i=0 ; i<n-1 ; i++){
            if(height[i] < prefixMax[i] && height[i] < suffixMax[i])
                ans+= Math.min(prefixMax[i] , suffixMax[i]) - height[i];
        }
        return ans;
    }
}