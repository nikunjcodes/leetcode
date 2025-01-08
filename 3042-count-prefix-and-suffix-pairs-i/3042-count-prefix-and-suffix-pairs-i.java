class Solution {
    public int countPrefixSuffixPairs(String[] words) {
           int len = words.length;
           int ans =0;
           for(int i=0 ; i< len ; i++){
            for(int j=i+1 ; j<len ; j++){
                if(words[j].startsWith(words[i]) && words[j].endsWith(words[i]))
                    ans++;
            }
           } 
           return ans;
    }
}