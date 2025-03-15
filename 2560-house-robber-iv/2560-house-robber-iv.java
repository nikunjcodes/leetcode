class Solution {
    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            if(num > max)
                max=num;
            if(num < min)
                min=  num;
        }
        int ans=0;
        while(min <=max){
            int mid = min + (max-min)/2;
            if(helper(mid , nums , k)){
                ans = mid;
                max= mid-1;
            }
            else
                min = mid+1;
        }
        return ans;
    }
    boolean helper(int mid , int[] nums , int k){
        int temp=0;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] <=mid){
                temp++;
                i++;
            }
            if(temp >=k)
                return true;
        }
        return false;
    }
}