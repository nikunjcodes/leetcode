class Solution {
    public String triangleType(int[] nums) {
        if(nums[0]+nums[1] <= nums[2] || nums[1] + nums[2] <=nums[0] || nums[0]+nums[2] <=nums[1])
            return "none";
        if(nums[0]==nums[1] && nums[1]==nums[2])
            return "equilateral";
        int count=0;
        if(nums[0]==nums[1]) count++;
        if(nums[0]==nums[2]) count++;
        if(nums[1]==nums[2]) count++;
        if(count==1)
            return "isosceles";
        else
            return "scalene";
        
    }
}