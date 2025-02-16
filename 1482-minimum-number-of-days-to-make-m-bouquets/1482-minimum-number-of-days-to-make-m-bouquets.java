class Solution {
    boolean helper(int[] bloomDay , int mid , int m , int k ){
        int temp=0;
        int bouq = 0;
        for(int i=0 ; i<bloomDay.length ; i++){
            if(bloomDay[i]<=mid)
                temp++;
            else{
                bouq+= temp/k;
                temp=0;
            }
        }
        bouq+=temp/k;
        if(bouq>=m)
            return true;
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long)m*k>bloomDay.length)
            return -1;
        int max=0,min=Integer.MAX_VALUE;
        for(int i=0 ; i<bloomDay.length; i++){
            min = Math.min(min , bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int left=min,right=max;
        while(left<right){
            int mid = (left+right)/2;
            if(helper(bloomDay , mid , m , k))
                right = mid;
            else
                left=mid+1;

        }
        return left;
        
    }
}