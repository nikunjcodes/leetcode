class Solution {
    public int maximumCandies(int[] candies, long k) {
        int l = 0, r = (int)1e7;
        while (l < r) {
            int m = (l + r + 1) / 2;
            long s = 0;
            for (int p : candies) s += p / m;
            if (s < k) r = m - 1;
            else l = m;
        }
        return l;
    }
}