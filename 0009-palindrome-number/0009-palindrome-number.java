class Solution {
    public boolean isPalindrome(int x) {
        if(-1*x>0)
            return(false);
        else{
            int rev=x,sum=0;
            while(x>0){
                int rem =  x%10;
                sum=sum*10 + rem;
                x=x/10;
            }
            if(sum==rev)
                return true;
            else
                return false;

        }
    }
}