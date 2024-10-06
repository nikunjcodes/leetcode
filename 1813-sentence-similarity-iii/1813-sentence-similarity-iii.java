class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        String[] words1 = sentence1.split("\\s");
        String[] words2 = sentence2.split("\\s");
        return words1.length <= words2.length ? helper(words1, words2) : helper(words2, words1);
    }
    
    private boolean helper(String[] words1, String[] words2){
        int matchCount = 0;
        
        int len1 = words1.length;  
        int len2 = words2.length; 
        
        int i = 0;
        while(i < len1 && words1[i].equals(words2[i])){
            i++;
            matchCount++;
        }
        
        while(i < len1 && words1[i].equals(words2[len2 - (len1 - i)])){
            i++;
            matchCount++;
        }
        
        return matchCount == len1;
    }
 }