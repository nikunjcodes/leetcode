class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0 ; i<9 ; i++){
            
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> col= new HashSet<Character>();
            HashSet<Character> box = new HashSet<Character>();
            for(int j=0; j<9 ; j++){
            
                 if (board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if (board[j][i]!='.' && !col.add(board[j][i]))
                    return false;
                
                int ridx = 3*(i/3);
                int cidx = 3*(i%3);
                if(board[ridx + j/3][cidx + j%3] !='.' && !box.add(board[ridx + j/3][cidx + j%3] ))
                    return false;
                
            }

        }
                    return true;

    }
}