class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minI = -1, maxI = -1, badI = -1;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                badI = i;
            }
            if (nums[i] == minK) minI = i;
            if (nums[i] == maxK) maxI = i;
            int validStart = Math.min(minI, maxI);
            if (validStart > badI) {
                ans += validStart - badI;
            }
        }

        return ans;
    }
}
