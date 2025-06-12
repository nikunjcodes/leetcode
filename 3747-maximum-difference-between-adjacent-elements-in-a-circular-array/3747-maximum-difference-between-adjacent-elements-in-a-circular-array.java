class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int first=nums[0];
        int ans=Integer.MIN_VALUE;
        for(int i=0 ;i<nums.length-1 ; i++){
            ans = Math.max(Math.abs(nums[i]-nums[i+1]) , ans);
        }
        ans =  Math.max(ans , Math.abs(first - nums[nums.length-1]));
        return ans;
    }
}