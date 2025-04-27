class Solution {
    public int maxScore(int[] cardPoints, int k) {
       int max=0;
       int n = cardPoints.length;
       int lsum=0 , rsum=0;
       for(int i=0 ;  i<k ; i++)
            lsum+=cardPoints[i];
        max = lsum;
        int r = n-1;
        for(int i=k-1 ;  i>=0 ; i--){
            lsum -= cardPoints[i];
            rsum+=cardPoints[r];
            r--;
            max = Math.max(lsum +rsum , max);
        }
        return max;
    }
}