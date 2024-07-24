class Solution {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
    
    static int helper(char[][] board, int row, int col) {
        if (row == 9) 
            return 1; 
        if (col == 9) 
            return helper(board, row + 1, 0);
        if (board[row][col] != '.')
            return helper(board, row, col + 1); 
        for (char c = '1'; c <= '9'; c++) {
            if (checker(board, row, col, c)) {
                board[row][col] = c;
                if (helper(board, row, col + 1)==1) 
                    return 1; 
                board[row][col] = '.';
            }
        }
        return 0; 
    }
    static boolean checker(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) 
                return false; 
            if (board[row][i] == c) 
                return false;
        }
        int startC = (col/3)*3;
        int startR = (row/3)*3;
        for(int i=startR ; i<startR+3; i++){
            for(int j=startC ; j<startC+3 ; j++){
                if(board[i][j]==c)
                    return false;
        }
        }
        
        return true;
    }
}
