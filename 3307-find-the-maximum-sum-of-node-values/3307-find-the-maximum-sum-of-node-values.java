class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long total = 0;
        int xorCount = 0;
        int minGain = Integer.MAX_VALUE;
        for(int num : nums){
            int xored = num ^k;
            if(xored > num){
                total += xored;
                xorCount++;
                minGain = Math.min(minGain, xored - num);
            }else {
                total += num;
                minGain = Math.min(minGain, num - xored);

            }
        }

        if(xorCount % 2 == 1){
            total -= minGain;
        }
        return total;
    }
}