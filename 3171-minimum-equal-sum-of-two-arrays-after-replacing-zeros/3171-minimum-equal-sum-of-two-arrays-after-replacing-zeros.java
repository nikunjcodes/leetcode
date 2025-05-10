class Solution {
    public long minSum(int[] nums1, int[] nums2) {
            long z1=0 , z2=0 , sum1=0 , sum2=0;
           for(int i : nums1){
            if(i == 0) z1++;
            sum1 += i;
        }

        for(int i : nums2){
            if(i == 0) z2++;
            sum2 += i;
        }
        long min1 = sum1 + z1;
        long min2 = sum2 + z2;
        if(z1 == 0 && z2 == 0){
            return sum1 == sum2 ? sum1 : -1;
        }else if(z1 == 0){
            return sum2 + z2 <=sum1 ?sum1 : -1;
        }else if (z2 == 0){
            return sum1 + z1 <= sum2 ? sum2 : -1;
        }
        return Math.max(min1, min2);
    }

}