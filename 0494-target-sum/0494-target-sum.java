class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        if (sum < target || target < -sum)
            return 0;

        return helper(nums, 0, target, 0);
    }

    public int helper(int[] nums, int idx, int target, int currSum) {
        if (idx == nums.length) {
            return currSum == target ? 1 : 0;
        }

        int add = helper(nums, idx + 1, target, currSum + nums[idx]);
        int subtract = helper(nums, idx + 1, target, currSum - nums[idx]);

        return add + subtract;
    }
}
