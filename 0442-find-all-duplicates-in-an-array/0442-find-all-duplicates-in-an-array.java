class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int n = nums.length;
        for(int i=0 ; i<n ; i++){
            int temp = Math.abs(nums[i]);
            if(nums[temp-1] < 0)
                ans.add(temp);
            nums[temp-1]*=-1;
        }
        return ans;
    }
}