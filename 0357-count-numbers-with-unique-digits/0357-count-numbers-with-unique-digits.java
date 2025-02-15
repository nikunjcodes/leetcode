class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
        int ans =10;
        int temp=9;
        int digits=9;
        while(n-->1 && digits>0){
            temp = temp*digits;
            digits--;
            ans+=temp;
        }
        return ans;
    }
}