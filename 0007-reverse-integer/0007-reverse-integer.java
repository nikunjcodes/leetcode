class Solution {
    public int reverse(int x) {
        int ans=0;
        while(x!=0){
            int rem = x%10;
            int temp = ans*10 + rem;
            if((temp-rem)/10!=ans)
                return 0;
            ans = temp;
            x=x/10;
        }
        return ans;
    }
}