class Solution {
    boolean helper(int[] weights , int days, int curr){
        int cap=0,cnt=0;
        for(int weight : weights){
            if(weight+cap > curr){
                cap=weight;
                cnt++;
            }
            else
                cap+=weight;
        }
        if(cnt+1>days)
            return true;
        else
            return false;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left= 0,right=0;
        for(int weight : weights){
            right+=weight;
            left=  Math.max(left , weight);
        }
        while(left <=right){
            int mid = (left+right)/2;
            if(helper(weights , days, mid))
                left = mid+1;
            else
                right= mid-1;
        }
        return left;
    }
}