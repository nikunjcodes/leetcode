public class Solution {

    public class Cell {
        public int i;
        public int j;
        public int val;
        public Cell(int i, int j, int val){
            this.i= i;
            this.j = j;
            this.val = val;
        }
    }

    public class TopK {
        public Cell[] cells;

        public TopK(int k) {
            cells = new Cell[k];
        }
        public void Add(Cell newcell) {
            if (cells[0] == null || newcell.val > cells[0].val) {
                cells[0] = newcell;
                for(int i = 1; i < cells.length && (cells[i] == null || cells[i-1].val > cells[i].val); ++i) {
                    Cell tmp = cells[i];
                    cells[i] = cells[i-1];
                    cells[i-1] = tmp;
                }
            }
        }
    }

    public long maximumValueSum(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        TopK top4 = new TopK(4);
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                top4.Add(new Cell(i, j, board[i][j]));
            }
        }

        long maxsum = Long.MIN_VALUE;

        for(Cell cell1 : top4.cells) {
            
            TopK top2 = new TopK(2);
            for(int i = 0; i < m; ++i){
                for(int j = 0; j < n; ++j) {
                    if (i != cell1.i && j != cell1.j) {
                        top2.Add(new Cell(i, j, board[i][j]));
                    }
                }
            }

            for(Cell cell2 : top2.cells) {

                int max = Integer.MIN_VALUE;
                for(int i = 0; i < m; ++i){
                    for(int j = 0; j < n; ++j){
                        if (i != cell1.i && i != cell2.i && j != cell1.j && j != cell2.j && board[i][j] > max) {
                            max = board[i][j];
                        }
                    }
                }

                long sum = (long)cell1.val + (long)cell2.val + (long)max;
                if (sum > maxsum){
                    maxsum = sum;
                }
            }
        }

        return maxsum;

    }
}