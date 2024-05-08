class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for(int i =0 ; i<len ; i++)
            ans[i] = 1;
        int pdt = 1;
        for(int i =0 ; i<len ; i++){
            ans[i] = ans[i] * pdt;
            pdt = pdt * nums[i];
        }
        pdt =1 ;
        for(int i=len-1 ; i>=0 ; i--){
            ans[i] = ans[i] *pdt;
            pdt  = pdt*nums[i];
        }
        return ans;
    }
}