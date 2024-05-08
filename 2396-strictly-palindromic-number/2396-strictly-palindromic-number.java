class Solution {
static boolean convertToBase(int N,int b){
        String result = "";
        int flag=0;
        while(N>0){
            int rem = N%b;
            N = N/b;
            result = rem + result;
        }
        for(int i =0 ; i<result.length()/2 ; i++){
            
            if(result.charAt(i)==result.charAt(result.length()-1))
                flag=1;
            else{
                flag=0;
                break;
            }
        }
        if(flag==0)
            return false;
        else
            return true;
    }

    public boolean isStrictlyPalindromic(int n) {
        int c =0 ;
        for(int i =2 ; i<=n-2 ; i++){
            if(convertToBase(n,i))
                c++;
            else{
                c=0;
                break;
            }
        }
        if(c==0)
            return(false);
        else
            return true;
    }
}