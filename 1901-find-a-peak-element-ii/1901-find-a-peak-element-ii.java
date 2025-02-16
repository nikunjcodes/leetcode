class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int left=0;
        int right = mat[0].length-1;
        while(left<=right){
            int maxRow=0;
            int mid = (left+right)/2;
            for(int i=0 ; i<mat.length ; i++){
                if(mat[i][mid] >= mat[maxRow][mid])
                    maxRow = i;
            }
            boolean bleft = mid-1>=left && mat[maxRow][mid-1] > mat[maxRow][mid];
            boolean bright= mid+1<=right && mat[maxRow][mid+1] > mat[maxRow][mid];
            if(!bleft && !bright)
                return new int[]{maxRow , mid};
            if(bright)
                left = mid+1;
            else
                right = mid-1;
        }
        return null;
    }
}