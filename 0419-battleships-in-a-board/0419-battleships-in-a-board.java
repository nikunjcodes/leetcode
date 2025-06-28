class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n=  board[0].length;
        int ans=0;
        int[][] vis = new int[m][n];
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(board[i][j]=='X' && vis[i][j]==0){
                    dfs(i , j , ans , board , m , n , vis);
                    ans++;
                }
            }
        }
        return ans;
    }
    void dfs(int i , int j , int ans , char[][] board , int m , int n , int[][] vis){
        if(i<0 || j<0 || i>=m || j>=n || vis[i][j]==1 || board[i][j]!='X')
            return;
        vis[i][j]=1;
        dfs(i-1 , j ,ans , board , m , n , vis);
        dfs(i , j-1 ,ans , board , m , n , vis);
        dfs(i , j+1 ,ans , board , m , n , vis);
        dfs(i+1 , j ,ans , board , m , n , vis);


    }
}