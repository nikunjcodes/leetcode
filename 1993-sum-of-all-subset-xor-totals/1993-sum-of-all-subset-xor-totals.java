class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums , 0 ,0);
    }
    int helper(int[] nums , int idx , int ans){
        if(idx == nums.length)
            return ans;
        int with = helper(nums , idx+1 , ans^nums[idx]);
        int without = helper(nums , idx+1 , ans);
        return with + without;
    }
}