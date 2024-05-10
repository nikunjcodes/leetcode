class Solution {
static boolean convertToBase(int N,int b){
        String result =Integer.toString(N,b);
        for(int i =0 ; i<result.length()/2 ; i++){
            if(!(result.charAt(i)==result.charAt(result.length()-1)))
                return false;  
    }
    return true;
}

    public boolean isStrictlyPalindromic(int n) {
        for(int i =2 ; i<=n-2 ; i++){
            if(!convertToBase(n,i))
                return false;
            }
        
        return true;

    }
}