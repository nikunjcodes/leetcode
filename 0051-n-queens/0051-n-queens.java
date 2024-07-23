class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        String b = "";
        for(int i=0 ; i<n ;i++)
            b = b + ".";
        for(int i=0 ; i<n ; i++)
            temp.add(b);
        int[] leftRow = new int[n];
        int[] upperD = new int[2*n-1];
        int[] lowerD = new int[2*n-1];
        helper(0, temp, ans, leftRow, upperD, lowerD, n);
        return ans;
    }
    
    static void helper(int col, List<String> temp, List<List<String>> ans, int[] leftRow, int[] upperD, int[] lowerD, int n) {
        if(col == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int row = 0; row < n; row++) {
            if(leftRow[row] == 0 && lowerD[row + col] == 0 && upperD[n - 1 + col - row] == 0) {
                char[] charArray = temp.get(row).toCharArray();
                charArray[col] = 'Q';
                temp.set(row, new String(charArray));
                leftRow[row] = 1;
                lowerD[row + col] = 1;
                upperD[n - 1 + col - row] = 1;
                helper(col + 1, temp, ans, leftRow, upperD, lowerD, n);    
                charArray[col] = '.';
                temp.set(row, new String(charArray));
                leftRow[row] = 0;
                lowerD[row + col] = 0;
                upperD[n - 1 + col - row] = 0;
            }
        }
    }
}
