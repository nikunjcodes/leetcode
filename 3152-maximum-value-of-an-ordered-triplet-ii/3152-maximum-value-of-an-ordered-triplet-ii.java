class Solution {
    public long maximumTripletValue(int[] nums) {
                long ans=0;
        long maxV=0;
        long maxDiff=0;
        for(int num  : nums){
            ans = Math.max(ans  , 1L*maxDiff*num);
            maxDiff = Math.max(maxDiff , maxV-num);
            maxV = Math.max(maxV ,  num);
        }
        return ans;
    }
}