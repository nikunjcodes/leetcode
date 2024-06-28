class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0 ; i<n ; i++){
            for(int j=i ; j<n ; j++){
                int temp=matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0 ; i<n; i++)
            reverse(matrix[i],0,n-1);
    }
        private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}