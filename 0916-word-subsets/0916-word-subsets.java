class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq = new int[26];
        for(String word : words2){
            int[] temp = getFrequency(word);
            for(int i=0 ; i<26; i++)
                freq[i] = Math.max(freq[i] , temp[i]);
        }
        List<String> ans = new ArrayList<>();
        for(String word : words1){
            int[] temp = getFrequency(word);
            if(helper(freq , temp))
                ans.add(word);
        }
        return ans;
    }
    int[] getFrequency(String word){
        int[] freq = new int[26];
        for(char c  : word.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }
    boolean helper(int[] freq , int[] temp){
        for(int i=0 ; i<26 ; i++){
            if(temp[i]<freq[i])
                return false;
        }
        return true;
    }
    
}