class Solution {
    public int totalNQueens(int n) {
        int[] leftRow = new int[n];
        int[] upperD = new int[2 * n - 1];
        int[] lowerD = new int[2 * n - 1];
        return solve(0, leftRow, upperD, lowerD, n);
    }
    private int solve(int col, int[] leftRow, int[] upperD, int[] lowerD, int n) {
        if (col == n) {
            return 1; 
        }

        int count = 0;
        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerD[row + col] == 0 && upperD[n - 1 + col - row] == 0) {
                leftRow[row] = 1;
                lowerD[row + col] = 1;
                upperD[n - 1 + col - row] = 1;
                count += solve(col + 1, leftRow, upperD, lowerD, n);
                leftRow[row] = 0;
                lowerD[row + col] = 0;
                upperD[n - 1 + col - row] = 0;
            }
        }

        return count;
    }
}
