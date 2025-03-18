class Solution {
    public int longestNiceSubarray(int[] nums) {
        int and=0 , i=0 , ans=0;
        for(int j=0 ; j<nums.length ; j++){
            while((and & nums[j]) >0)
                and^=nums[i++];
            and |= nums[i];
            ans = Math.max(ans , j-i+1);
        }
        return ans;
    }
}