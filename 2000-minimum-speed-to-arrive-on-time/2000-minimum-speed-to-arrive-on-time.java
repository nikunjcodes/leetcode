class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left=1;
        int right=(int)1e7;
        for(int i=0 ; i<dist.length ; i++)
            right = Math.max(right , dist[i]);
        int ans=-1;
        while(left <=right){
            int mid = (right-left)/2  +left;
            if(helper(mid , dist , hour)){
                right = mid-1;
                ans=mid;

            }
            else
                left = mid+1;
        }
        return ans;
    }
    boolean helper(int mid , int[] dist , double k){
        double time=0.0;
        for(int i=0 ; i<dist.length ; i++){
            time+=(double)dist[i]/mid;
            if(i!=dist.length-1)
                time = Math.ceil(time);
        }
        return time<=k;
    }
}