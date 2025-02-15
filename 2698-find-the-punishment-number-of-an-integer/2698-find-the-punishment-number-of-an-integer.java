class Solution {
    public int punishmentNumber(int n) {
        int ans=0;
        for(int i=1 ; i<=n ; i++){
            int temp = i*i;
            if(helper(temp,i))
                ans+=temp;
        }
        return ans;
    }
    boolean helper(int num , int sum){
        if(sum<0 || num<sum)
            return false;
        if(num==sum)
            return true;
        return helper(num/10, sum-num%10) || helper(num/100 , sum-num%100) || helper(num/1000 , sum-num%1000);
    }
}