class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int pdt=1;
        Arrays.fill(ans , 1);
        for(int i=0 ; i<nums.length ; i++){
            ans[i] = ans[i]*pdt;
            pdt = pdt*nums[i];
        }
        pdt=1;
        for(int j=nums.length-1 ; j>=0 ; j--){
            ans[j] = ans[j]*pdt;
            pdt = pdt*nums[j];
        }
        return ans;
    }
}