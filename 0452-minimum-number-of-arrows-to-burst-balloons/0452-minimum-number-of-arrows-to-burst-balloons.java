class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0)
            return 0;
        Arrays.sort(points , (a,b)->Integer.compare(a[1],b[1]));
        int currPos = points[0][1];
        int anss =1;
        for(int i=1 ; i<points.length ; i++){
            if(currPos >=points[i][0])
                continue;
            anss++;
            currPos = points[i][1];
        }
        return anss;
    }
}