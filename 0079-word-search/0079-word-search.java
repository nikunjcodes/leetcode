class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board[0].length ; j++){
                if(helper(board , word , i ,  j , 0 ))
                    return true;
            }
        }
        return false;
    }
    boolean helper(char[][]board , String word , int i , int j , int idx){
        if(idx == word.length())
            return true;
        if(i>=board.length || i<0 || j>=board[i].length || j<0 || board[i][j]!=word.charAt(idx))
            return false;
        if(board[i][j]=='*')
            return false;
        char temp = board[i][j];
        board[i][j]='*';
        boolean ans = helper(board , word , i , j-1 , idx+1) || helper(board , word , i , j+1 , idx+1) || helper(board , word , i-1 , j , idx+1) || helper(board , word , i+1 , j , idx+1);
        board[i][j] = temp;
        return ans;
    }
}