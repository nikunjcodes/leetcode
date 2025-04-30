class Solution {
    public int findNumbers(int[] nums) {
        int ans =0;
        for(int num : nums)
            ans+= helper(num)%2==0 ? 1 : 0;
        return ans;
    }
    int helper(int num){
        int digits=0;
        while(num >0){
            digits++;
            num=num/10;
        }
        return digits;
    }
}