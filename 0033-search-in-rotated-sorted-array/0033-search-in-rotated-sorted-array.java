class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid=0;
        while(low<=high){
            mid = (low+high)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<=nums[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
            else{
                if(nums[high]>=target && nums[mid]<=target)
                    low = mid+1;
                else
                    high = mid-1;
                    
                }
            }
        
        return -1;
    }
}