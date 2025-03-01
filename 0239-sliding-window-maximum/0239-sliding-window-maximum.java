class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans  = new int[nums.length-k+1];
        int f=0;
        for(int i=0 ; i<=nums.length-k ; i++){
            int max=nums[i];
            for(int j=i ; j<i+k ; j++){
                max = Math.max(max , nums[j]);
            }
            ans[f++] = max;
        }
        return ans;
    }
}