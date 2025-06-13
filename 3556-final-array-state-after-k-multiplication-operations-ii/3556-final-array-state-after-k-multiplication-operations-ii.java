class Solution {
    int MOD = 1_000_000_007;

    long fastPower(long x, long y) {
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % MOD;
            x = (x * x) % MOD;
            y /= 2;
        }
        return res;
    }

    public int[] getFinalState(int[] nums, int k, int m) {
        if (m == 1)
            return nums;
        int n = nums.length;
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new int[] { nums[i], i });
            max = Math.max(max, nums[i]);
        }

        while (k > 0 && max / minHeap.peek()[0] >= m) {
            int[] min = minHeap.poll();
            min[0] *= m;
            minHeap.add(min);
            --k;
        }

        int times = k / n;
        int rem = k % n;

        long first = fastPower(m, times);
      
        long second = fastPower(m, times + 1);

        while (!minHeap.isEmpty()) {
            int[] min = minHeap.poll();
            long mul = rem-- > 0 ? second : first;
            long val = (mul * min[0]) % MOD;
            nums[min[1]] = (int)val;
        }
        return nums;
    }
}