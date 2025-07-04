class Solution {
    public char kthCharacter(long k, int[] operations) {
        int res = 0;
        while (k > 1) {
            int count = 0;
            long n = k;
            while (n > 0) {
                n >>= 1;
                count++;
            }
            int idx=0;
            if((k & k-1) == 0){
                idx = count-2;
                k/=2;
            }
            else{
                idx = count-1;
                k -= (1L << (count - 1));
            }

            res += operations[idx];
            
        }
        return (char) ('a' + (res % 26));
    }
}
