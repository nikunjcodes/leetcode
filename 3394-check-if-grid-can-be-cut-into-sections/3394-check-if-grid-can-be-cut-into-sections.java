class Solution {
    public boolean checkValidCuts(int n, int[][] rec) {
        int[][] x = new int[rec.length][2];
        int[][] y = new int[rec.length][2];
        for(int i=0 ; i<rec.length ; i++){
            x[i][0] = rec[i][0];
            x[i][1] = rec[i][2];
            y[i][0] = rec[i][1];
            y[i][1] = rec[i][3];
        }
        return helper(x) || helper(y);
    }
    boolean helper(int[][] intervals){
        Arrays.sort(intervals , (a,b)-> Integer.compare(a[0] , b[0]));
        int part =0;
        int maxEnd = intervals[0][1];
        for(int[] interval : intervals){
            if(maxEnd <= interval[0])
                part++;
            maxEnd = Math.max(maxEnd , interval[1]);
        }
        return part >=2;
    }
}