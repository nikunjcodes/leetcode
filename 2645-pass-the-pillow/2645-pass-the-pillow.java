class Solution {
    public int passThePillow(int n, int time) {
        int m = time % (2 * n - 2) + 1;
        return m <= n ? m : 2 * n - m;
    }
}