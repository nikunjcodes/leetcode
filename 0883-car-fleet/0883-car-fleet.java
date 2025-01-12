class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[target];
        for(int i=0 ; i<position.length ; i++)
            time[position[i]] = (double) (target - position[i])/speed[i];
        double prev = 0.0;
        int ans=0;
        for(int i= target - 1 ; i>=0 ; i--){
            double curr = time[i];
            if(curr>prev){
                prev= curr;
                ans++;
            }
        }
        return ans;
    }
}