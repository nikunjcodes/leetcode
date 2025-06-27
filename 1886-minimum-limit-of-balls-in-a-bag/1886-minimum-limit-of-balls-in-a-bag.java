class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left=1;
        int right=0;
        for(int num : nums){
            right = Math.max(right , num);
        }
        while(left<=right){
            int mid = (right-left)/2 + left;
            if(helper(mid ,  nums , maxOperations)){
                right = mid-1;
            }
            else
                left = mid+1;
        }
        return left;
    }
    boolean helper(int mid , int[] nums , int max){
    
        for(int num : nums){
            int x = num/mid;
            if(num%mid!=0)
                x++;
            x--;
            max-=x;
            if(max<0)
                return false;
        }
        return true;
    }
}