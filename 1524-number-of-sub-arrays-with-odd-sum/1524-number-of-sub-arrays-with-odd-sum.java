class Solution {
    final int M = 1000000007;
    public int numOfSubarrays(int[] arr) {
        long odd=0;
        long sum=0;
        for(int a : arr){
            sum+=a;
            odd+=sum%2;
        }
        odd +=(arr.length-odd)*odd;
        return (int)(odd%M);
    }
}