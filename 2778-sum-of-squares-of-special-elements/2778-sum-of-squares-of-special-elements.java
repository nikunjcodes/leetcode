class Solution {
    public int sumOfSquares(int[] nums) {
        int sum=0;
        int s = nums.length;
        for(int i =1 ; i<=nums.length ; i++){
            if(s%i==0){
                sum=sum+nums[i-1]*nums[i-1];
            }
        }
        return(sum);
    }
}