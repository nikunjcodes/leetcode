class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] rf = new int[mat.length];
        int[] cf = new int[mat[0].length];
        Map<Integer , int[]> hmap = new HashMap<>();
        for(int i=0 ; i<mat.length ; i++){
            for(int j=0 ; j<mat[0].length; j++)
                hmap.put(mat[i][j] ,new int[] {i,j});
        }
        for(int i=0 ; i<arr.length ; i++){
            int[] temp = hmap.get(arr[i]);
            rf[temp[0]]++;
            cf[temp[1]]++;
            if(rf[temp[0]]== mat[0].length || cf[temp[1]] == mat.length)
                return i;
        }
        return -1;
    }
}