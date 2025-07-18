class Solution {
    public double averageWaitingTime(int[][] customers) {
        double num = customers.length;
        double ans=0;
        int curr=0;
        for(int[] customer : customers){
            int start = Math.max(curr , customer[0]);
            curr = start + customer[1];
            ans+= start - customer[0] + customer[1];
        }
        return ans/num;
        
    }
}