class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() <k)
            return false;
        return helper(s.toCharArray() , k);
    }
    boolean helper(char[] arr , int k ){
        int odd=0;
        int[] freq = new int[26];
        for(char c  : arr){
            freq[c-'a']++;
        }
        for(int i=0 ; i<26 ; i++){
            if(freq[i]%2==1)
                odd++;
        }
        if(odd > k)
            return false;
        return true;
    }
}