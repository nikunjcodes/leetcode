class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for(int[] book : bookings){
            for(int i= book[0]-1 ; i<=book[1]-1;i++){
                ans[i]+=book[2];
            }
        }
        return ans;
    }
}