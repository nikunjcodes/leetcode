class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        for(int i=low ; i<=high ; i++){
            ans+=helper(i);
        }
        return ans;
    }
    int helper(int num){
        String s  = String.valueOf(num);
        int n = s.length();
        if(n%2==1)
            return 0;
        int temp=0;
        for(int i=0 ; i<n/2 ; i++)
            temp+= (s.charAt(i) -'0') -( s.charAt(n-i-1) -'0');
        if(temp==0)
            return 1;
        else
            return 0;
    }
}