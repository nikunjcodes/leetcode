class Solution {
    public int sum(int nums[],int divisor)  {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/(double)divisor);
        }
        return sum;
    } 
    
    
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int maxii=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxii=Math.max(maxii,nums[i]);
        }
        int low=0;
        int high=maxii;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(sum(nums,mid)<=threshold){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;


        
    }
}