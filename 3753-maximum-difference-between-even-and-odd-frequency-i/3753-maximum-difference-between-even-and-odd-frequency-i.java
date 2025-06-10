class Solution {
    public int maxDifference(String s) {
        int[] mpp = new int[26];
        for(char c : s.toCharArray()){
            mpp[c-'a']++;
        }
        int odd = 0;
        int even =Integer.MAX_VALUE;
        for(int i=0 ; i<26 ; i++){
            if(mpp[i]%2==0 && mpp[i] >0){
                even = Math.min(even , mpp[i]);
            }
            else if(mpp[i]%2!=0)
                odd = Math.max(odd , mpp[i]);
        }
        return odd - even;
    }
}