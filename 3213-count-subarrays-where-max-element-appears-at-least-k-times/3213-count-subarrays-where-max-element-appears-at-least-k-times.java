class Solution {
    public long countSubarrays(int[] nums, int k) {
            long ans = 0;
    int i = 0, j = 0;
    int n = nums.length, max = Integer.MIN_VALUE, freq = 0;
    for (int l : nums) max = Math.max(max, l);
   
    while (j <= n) {
        if (freq >= k){
            while (i < j ) {
                ans += n - (j-1);
                if (nums[i] != max)  i++;
                else {
                    freq--;
                    i++;
                    if (freq < k) break;   
                } 
            } 
        }
        if (j == n) break;
        if (nums[j] == max) freq++;
        j++;
    }
    return ans;
    }
}