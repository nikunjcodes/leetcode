class Solution {
    int helper(int[] piles , int h){
        int total=0;
        for(int i=0 ; i<piles.length ; i++){
            total+=Math.ceil((double )piles[i] / (double)h);
        }
        return total;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=1;
        for(int i=0 ; i<piles.length ; i++)
            max = Math.max(max , piles[i]);
        int low=1,high = max;
        while(low < high){
            int mid = (low+high)/2;
            int hours = helper(piles , mid);
            if(hours <=h)
                high=mid;
            else
                low = mid+1;
        }
            return low;

    }
}