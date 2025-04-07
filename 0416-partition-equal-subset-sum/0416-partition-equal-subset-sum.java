class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return helper(nums, 0, target, memo);
    }
    
    private boolean helper(int[] nums, int pos, int target, Boolean[][] memo) {
        if (target == 0) {
            return true;
        }
        if (pos == nums.length || target < 0) {
            return false;
        }
        if (memo[pos][target] != null) {
            return memo[pos][target];
        }
        
        if (helper(nums, pos + 1, target, memo)
            || helper(nums, pos + 1, target - nums[pos], memo)) {
            memo[pos][target] = true;
            return true;
        }
        memo[pos][target] = false;
        return false;
    }
}