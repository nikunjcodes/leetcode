class Solution {
    public int maximumTastiness(int[] price, int k) {
           Arrays.sort(price);
           int left=0;
           int right = price[price.length-1] - price[0];
           int ans=0;
           while(left <=right){
            int mid = (right-left)/2  + left;
            if(helper(mid , price , k)){
                left = mid+1;
                ans= mid;
            }
            else
                right= mid-1;
           }
           return ans;           
    }
    boolean helper(int mid , int[] price , int k){
        int count=1;
        int last= price[0];
        for(int i=1 ; i<price.length ; i++){
            if(price[i] - last >=mid){
                count++;
                last= price[i];
            }
            if(count >=k)
                return true;
        }
        return false;
    }
} 