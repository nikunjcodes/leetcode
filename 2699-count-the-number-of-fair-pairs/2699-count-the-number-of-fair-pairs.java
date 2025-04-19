class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return helper(nums , upper) - helper(nums , lower-1);
    }

    long helper(int[] nums , int flag){
        long ans =0;
        int j= nums.length-1;
        for(int i=0 ; i<j ; i++){
            while(i<j && nums[i] + nums[j] > flag)
                j--;
            ans+=j-i;
        }
        return ans;
    }
}