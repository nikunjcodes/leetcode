class Solution {
    public boolean check(int[] nums) {
        int flag=0;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] > nums[(i+1)%nums.length]){
                flag++;
            }
        }
        if(flag>1)
            return false;
        return true;
    }
}