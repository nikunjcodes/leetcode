class Solution {
    public int kthFactor(int n, int k) {
        int flag=-1;
        for(int i=1 ; i<=n ; i++){
            if(n%i==0){
                if(k==1){
                flag=i;
                break;
                }
                else
                    k--;
            }
        }
        return flag;
    }
}