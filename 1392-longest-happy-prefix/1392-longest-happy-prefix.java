class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] kmp = new int[n];
        int i=1,j=0;
        while(i<n){
            if(s.charAt(i)==s.charAt(j)){
                j++;
                kmp[i] = j;
                i++;
            }
            else{
                if(j>0)
                    j=kmp[j-1];
                else{
                    kmp[i] = 0;
                    i++;
                }
            }
        }
        return s.substring(0,kmp[n-1]);

    }
}