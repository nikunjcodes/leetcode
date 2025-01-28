class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] dire = {{-1,0} , {0,-1} , {1,0} , {0,1} , {1,1} , {-1,-1} , {1,-1} , {-1,1}};
        List<List<Integer>> ans = new ArrayList<>();
        int[][] board = new int[8][8];
        for(int[] queen : queens){
            board[queen[0]][queen[1]] = 1;
        }
        for(int[] dir : dire ){

        int x = king[0];
        int y = king[1];
        while(x>=0 && y>=0 && x<8 && y<8){
            x+=dir[0];
            y+=dir[1];
        
        if(x>=0 && y>=0 && x<8 && y<8 && board[x][y]==1){
            ans.add(List.of(x,y));
             break;
        }
        }
        }

        return ans;
    }
}