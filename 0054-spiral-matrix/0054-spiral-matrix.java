class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans =new ArrayList<>();
        int rowS = 0;
        int colS=0;
        int rowEnd = matrix.length-1;
        int colEnd = matrix[0].length-1;
        while(rowEnd>=rowS && colEnd >=colS){
            for(int i=colS ; i<=colEnd ; i++){
                ans.add(matrix[rowS][i]);
            }
            rowS++;
            for(int i=rowS ; i<=rowEnd ; i++){
                ans.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(rowS <=rowEnd){
                for(int j=colEnd ; j>=colS ; j--)
                    ans.add(matrix[rowEnd][j]);
            }
            rowEnd--;
            if(colS <=colEnd){
                for(int j=rowEnd ; j>=rowS ; j--)
                    ans.add(matrix[j][colS]);
            }
            colS++;
        }
        return ans;
    }
}