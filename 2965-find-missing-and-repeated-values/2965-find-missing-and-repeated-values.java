class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int nsq = n * n;
        long expectSum = (long) nsq * (nsq + 1) / 2;
        long expectSumSq = (long) nsq * (nsq + 1) * (2 * nsq + 1) / 6;
        long actualSum = 0, actual = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                actualSum += grid[i][j];
                actual += (long) grid[i][j] * grid[i][j];
            }
        }
        long diffSum = actualSum - expectSum;
        long diffSumSquares = actual - expectSumSq;
        long sumAB = diffSumSquares / diffSum;
        int a = (int) ((sumAB + diffSum) / 2);
        int b = (int) ((sumAB - diffSum) / 2);
        
        return new int[]{a, b};
    }
}