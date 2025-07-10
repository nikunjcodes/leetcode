class Solution {
    public int minDifference(int[] nums) {
        int prev = nums[0];
        int hi = Integer.MIN_VALUE;
        int lo = Integer.MAX_VALUE;
        int diff = 0;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr == -1) {
                if (prev != -1) {
                    hi = Math.max(prev, hi);
                    lo = Math.min(prev, lo);
                }
            } else if (prev == -1) {
                hi = Math.max(curr, hi);
                lo = Math.min(curr, lo);
            } else {
                diff = Math.max(Math.abs(curr - prev), diff);
            }
            prev = curr;
        }

        if (hi == Integer.MIN_VALUE) return diff;

        int span = ((hi - lo + 2) / 3) * 2;
        int maxSeg = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == -1) {
                int l = i;
                while (l >= 0 && nums[l] == -1) l--;
                int r = i;
                while (r < nums.length && nums[r] == -1) r++;

                int lv, rv;
                if (l == -1) {
                    lv = rv = nums[r];
                } else if (r == nums.length) {
                    lv = rv = nums[l];
                } else {
                    lv = Math.min(nums[l], nums[r]);
                    rv = Math.max(nums[l], nums[r]);
                }

                int cur;
                if (l + 2 == r) {
                    cur = Math.min(rv - lo, hi - lv);
                } else {
                    cur = Math.min(Math.min(rv - lo, hi - lv), span);
                }

                maxSeg = Math.max(cur, maxSeg);
                i = r + 1;
            } else {
                i++;
            }
        }

        return Math.max((maxSeg + 1) / 2, diff);
    }
}
